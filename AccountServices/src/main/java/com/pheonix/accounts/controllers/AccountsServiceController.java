package com.pheonix.accounts.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pheonix.accounts.pojo.Accounts;
import com.pheonix.accounts.pojo.BankAccounts;
import com.pheonix.accounts.pojo.CardAccounts;
import com.pheonix.accounts.pojo.CardThirdPartyAccounts;
import com.pheonix.accounts.pojo.InsuranceAccounts;
import com.pheonix.accounts.service.AccountsDomainService;

@RestController
public class AccountsServiceController {

	private static final Log log = LogFactory.getLog(AccountsServiceController.class);



	@Autowired
	AccountsDomainService accountsDomainService;

	@RequestMapping(value = { "/v1/accounts" }, method = RequestMethod.GET)
	public ResponseEntity<Accounts> aggregateAccounts() {
		long start = System.currentTimeMillis();

		log.info("inside the aggregateAccounts");
		// here goes aggregate domain services
		Accounts accounts = new Accounts();

		try {
			CompletableFuture<BankAccounts> bankAccounts = accountsDomainService.getBankAccountsFromDomain();
			CompletableFuture<InsuranceAccounts> insuranceAccounts = accountsDomainService
					.getInsuranceAccountsFromDomain();
			CompletableFuture<CardAccounts> cardAccounts = accountsDomainService.getCardsAccountsFromDomain();
			CompletableFuture<CardThirdPartyAccounts> thirdPartyCardAccounts = accountsDomainService
					.getOtherCardsAccountsFromDomain();

			CompletableFuture.allOf(bankAccounts, insuranceAccounts, cardAccounts, thirdPartyCardAccounts).join();

			
			/*log.info("bankAccounts --> " + bankAccounts.get());
			log.info("insuranceAccounts --> " + insuranceAccounts.get());
			log.info("cardAccounts--> " + cardAccounts.get());
			log.info("thirdPartyCardAccounts--> " + thirdPartyCardAccounts.get());*/

			
			List<BankAccounts> bankaccountsobj = new ArrayList<BankAccounts>();
			bankaccountsobj.add(bankAccounts.get());
			List<CardAccounts> cardaccountsobj = new ArrayList<CardAccounts>();
			cardaccountsobj.add(cardAccounts.get());
			List<CardThirdPartyAccounts> cardThirdpartyobj = new ArrayList<CardThirdPartyAccounts>();
			cardThirdpartyobj.add(thirdPartyCardAccounts.get());
			List<InsuranceAccounts> insuranceaccountsobj = new ArrayList<InsuranceAccounts>();
			insuranceaccountsobj.add(insuranceAccounts.get());

			accounts.setBankAccounts(bankaccountsobj);
			accounts.setCardAccounts(cardaccountsobj);
			accounts.setCardThirdPartyAccounts(cardThirdpartyobj);
			accounts.setInsuranceAccounts(insuranceaccountsobj);
			
			log.info("AggregatedAccounts: " + accounts);
			log.info("Elapsed time: " + (System.currentTimeMillis() - start));

		} catch (InterruptedException e) {

			e.printStackTrace();

		} catch (ExecutionException e) {

			e.printStackTrace();
		}

		return new ResponseEntity<Accounts>(accounts, HttpStatus.OK);

	}

}

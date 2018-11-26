package com.pheonix.bankaccounts.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pheonix.bankaccounts.pojo.BankAccounts;
import com.pheonix.bankaccounts.services.BankDomainService;



@RestController
public class BankAccountDomainController {

	private static final Logger log = LoggerFactory.getLogger(BankAccountDomainController.class);
	
	@Autowired
	BankDomainService bankDomainService;

	@RequestMapping(value = { "/v1/banks/accounts" }, method = RequestMethod.GET)
	public ResponseEntity<BankAccounts> bankAccounts() {
		log.info("inside the bankAccounts");
		// here goes aggregate domain services
		BankAccounts bankAccounts = bankDomainService.bankAccounts();
		return new ResponseEntity<BankAccounts>(bankAccounts, HttpStatus.OK);

	}

}

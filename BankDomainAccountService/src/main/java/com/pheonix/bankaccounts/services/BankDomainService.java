package com.pheonix.bankaccounts.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pheonix.bankaccounts.pojo.Balance;
import com.pheonix.bankaccounts.pojo.BankAccounts;

@Service
public class BankDomainService {
	
	private static final Logger log = LoggerFactory.getLogger(BankDomainService.class);

	
	public BankAccounts bankAccounts() {
		log.info("inside the bankAccounts Service");
		
		BankAccounts bankAccounts = createBankAccounts();
		
		log.info("bankAccounts is : "+ bankAccounts);
		
		return bankAccounts;

	}


	private BankAccounts createBankAccounts() {
		
		String accountId = "BNK-ACCT-1234";
		String accountName = "VISA-BANK-XZY-SAVINGS";
		String accountNo = java.util.UUID.randomUUID().toString();
		String accountStatus = "ACTIVE";
		String accountType = "SAVINGS";
		Balance balances = new Balance();
		balances.setCurrentBalance(1234.245);
		balances.setSavingsBalance(34.47);
		
		//Account account = new  Account(accountNo, accountType,accountId,accountName,accountStatus,balances);
		
		String bankingMode = "01";
		String linkedTo = "ROOT";
		
		BankAccounts bankAccounts = new BankAccounts(accountNo, accountType,accountId,
				accountName,accountStatus,balances,bankingMode,linkedTo);
		
		/*bankAccounts.setBankingMode("01");
		bankAccounts.setLinkedTo("ROOT");*/
		return bankAccounts;
	}

}

package com.pheonix.insuranceaccounts.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pheonix.insuranceaccounts.pojo.Balance;
import com.pheonix.insuranceaccounts.pojo.InsuranceAccounts;

@Service
public class InsuranceDomainService {

	private static final Logger log = LoggerFactory.getLogger(InsuranceDomainService.class);

	public InsuranceAccounts insuranceAccounts() {
		log.info("inside the insuranceAccounts Service");

		InsuranceAccounts insuranceAccounts = createInsuranceAccounts();

		log.info("insuranceAccounts is : " + insuranceAccounts);

		return insuranceAccounts;

	}

	private InsuranceAccounts createInsuranceAccounts() {

		String accountId = "INS-ACCT-10188";
		String accountName = "HLT-ACC-XZY-INS";
		String accountNo = java.util.UUID.randomUUID().toString();
		String accountStatus = "ACTIVE";
		String accountType = "INSURANCE";
		Balance balances = new Balance();

		balances.setSavingsBalance(100.47);

		// Account account = new Account(accountNo,
		// accountType,accountId,accountName,accountStatus,balances);

		String insuranceMode = "117";

		String linkedTo = "ROOT";

		InsuranceAccounts insuranceAccounts = new InsuranceAccounts(accountNo, accountType, accountId, accountName,
				accountStatus, balances, insuranceMode, linkedTo);

		return insuranceAccounts;
	}
}

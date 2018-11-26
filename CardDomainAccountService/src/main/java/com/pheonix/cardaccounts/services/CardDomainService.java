package com.pheonix.cardaccounts.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pheonix.cardaccounts.pojo.Balance;
import com.pheonix.cardaccounts.pojo.CardAccounts;

@Service
public class CardDomainService {

	private static final Logger log = LoggerFactory.getLogger(CardDomainService.class);

	public CardAccounts cardAccounts() {
		log.info("inside the bankAccounts Service");

		CardAccounts cardAccounts = createCardAccounts();

		log.info("cardAccounts is : " + cardAccounts);

		return cardAccounts;

	}

	private CardAccounts createCardAccounts() {

		String accountId = "CRD-ACCT-7788";
		String accountName = "AMX-CARD-XZY-CARDS";
		String accountNo = java.util.UUID.randomUUID().toString();
		String accountStatus = "ACTIVE";
		String accountType = "CARDS";
		Balance balances = new Balance();
		balances.setCurrentBalance(9867.0);
		balances.setCardBalance(711.47);

		// Account account = new Account(accountNo,
		// accountType,accountId,accountName,accountStatus,balances);

		String cardMode = "07";
		String cardStatus = "ACT-LINKED";
		boolean overSeasCardActivation = false;
		boolean overSeasCardUsageAllowed = false;
		String linkedTo = "ROOT";

		CardAccounts cardAccounts = new CardAccounts(accountNo, accountType, accountId, accountName, accountStatus,
				balances, cardMode, cardStatus, overSeasCardActivation, overSeasCardUsageAllowed, linkedTo);

		return cardAccounts;
	}

}

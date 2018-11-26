package com.pheonix.cardaccounts.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pheonix.cardaccounts.pojo.Balance;
import com.pheonix.cardaccounts.pojo.CardThirdPartyAccounts;

@Service
public class CardThirdpartyDomainService {
	
	
private static final Logger log = LoggerFactory.getLogger(CardThirdpartyDomainService.class);

	
	public CardThirdPartyAccounts cardThirdPartyAccounts() {
		log.info("inside the bankAccounts Service");
		
		CardThirdPartyAccounts cardThirdPartyAccounts = createCardThirdPartyAccounts();
		
		log.info("cardThirdPartyAccounts is : "+ cardThirdPartyAccounts);
		
		return cardThirdPartyAccounts;

	}


	private CardThirdPartyAccounts createCardThirdPartyAccounts() {
		
		String accountId = "OTRCRD-ACCT-9091";
		String accountName = "RLX-CARD-XZY-OTRCARDS";
		String accountNo = java.util.UUID.randomUUID().toString();
		String accountStatus = "ACTIVE";
		String accountType = "OTRCARDS";
		Balance balances = new Balance();
		balances.setCurrentBalance(11101.11);
		balances.setCardBalance(1034.47);
		
		//Account account = new  Account(accountNo, accountType,accountId,accountName,accountStatus,balances);
		
		String cardMode = "98";
		String cardStatus = "ACT-LINKED";
		boolean overSeasCardActivation = false;
		boolean overSeasCardUsageAllowed = false;
		String linkedTo = "ROOT";
		boolean thirdPartyCardsAllowed = false;
		
		CardThirdPartyAccounts cardThirdPartyAccounts = new CardThirdPartyAccounts(accountNo, accountType,accountId,
				accountName,accountStatus,balances,cardMode,cardStatus,overSeasCardActivation,
				overSeasCardUsageAllowed,linkedTo,thirdPartyCardsAllowed);
		
		
		return cardThirdPartyAccounts;
	}


}

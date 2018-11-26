package com.pheonix.cardaccounts.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pheonix.cardaccounts.pojo.CardAccounts;
import com.pheonix.cardaccounts.pojo.CardThirdPartyAccounts;
import com.pheonix.cardaccounts.services.CardDomainService;
import com.pheonix.cardaccounts.services.CardThirdpartyDomainService;

@RestController
public class CreditCardAccountDomainController {
	
private static final Logger log = LoggerFactory.getLogger(CreditCardAccountDomainController.class);

	@Autowired
	CardDomainService cardDomainService;
	
	@Autowired
	CardThirdpartyDomainService cardThirdpartyDomainService;

	@RequestMapping(value = { "/v1/cards/accounts" }, method = RequestMethod.GET)
	public ResponseEntity<CardAccounts> creditCardAccounts() {
		log.info("inside the creditCardAccounts");
		//here goes aggregate domain services
		CardAccounts cardAccounts = cardDomainService.cardAccounts();
		return new ResponseEntity<CardAccounts>(cardAccounts, HttpStatus.OK);

	}
	
	@RequestMapping(value = { "/v1/cards/others/accounts" }, method = RequestMethod.GET)
	public ResponseEntity<CardThirdPartyAccounts> creditCardOtherAccounts() {
		log.info("inside the creditCardOtherAccounts");
		//here goes aggregate domain services
		CardThirdPartyAccounts cardThirdPartyAccounts = cardThirdpartyDomainService.cardThirdPartyAccounts();
		return new ResponseEntity<CardThirdPartyAccounts>(cardThirdPartyAccounts, HttpStatus.OK);

	}

}

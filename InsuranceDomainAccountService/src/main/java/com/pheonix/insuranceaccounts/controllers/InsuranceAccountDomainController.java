package com.pheonix.insuranceaccounts.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pheonix.insuranceaccounts.pojo.InsuranceAccounts;
import com.pheonix.insuranceaccounts.services.InsuranceDomainService;

@RestController
public class InsuranceAccountDomainController {
	
private static final Logger log = LoggerFactory.getLogger(InsuranceAccountDomainController.class);

	@Autowired
	InsuranceDomainService insuranceDomainService;
	

	@RequestMapping(value = { "/v1/insurance/accounts" }, method = RequestMethod.GET)
	public ResponseEntity<InsuranceAccounts> insuranceAccounts() {
		log.info("inside the insuranceAccounts");
		//here goes aggregate domain services
		InsuranceAccounts insuranceAccounts = insuranceDomainService.insuranceAccounts();
		return new ResponseEntity<InsuranceAccounts>(insuranceAccounts, HttpStatus.OK);

	}
	
	

}

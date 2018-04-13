package com.pheonix.insuranceaccounts.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	
private static final Log log = LogFactory.getLog(InsuranceAccountDomainController.class);

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

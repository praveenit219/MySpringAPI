package com.pheonix.profile.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pheonix.profile.pojo.Customer;
import com.pheonix.profile.services.ProfileDomainService;

@RestController
public class ProfileServiceController {

	private static final Log log = LogFactory.getLog(ProfileServiceController.class);
	
	@Autowired
	ProfileDomainService profileDomainService;

	@RequestMapping(value = { "/v1/customer/details" }, method = RequestMethod.GET)
	public ResponseEntity<Customer> fullCustomerDetails() {
		log.info("inside the customer full details");
		// here goes aggregate domain services
		Customer customer = profileDomainService.customerInformation();
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);

	}

	

	@RequestMapping(value = { "/v1/customer/mail" }, method = RequestMethod.GET)
	public ResponseEntity<String> profileEmail() {
		log.info("inside the profileEmail");
		// here goes aggregate domain services
		return new ResponseEntity<String>("profileEmail..", HttpStatus.OK);

	}

	@RequestMapping(value = { "/v1/customer/phonenumber" }, method = RequestMethod.GET)
	public ResponseEntity<String> profilePhonenumber() {
		log.info("inside the profilePhonenumber");
		// here goes aggregate domain services
		return new ResponseEntity<String>("profilePhonenumber...", HttpStatus.OK);

	}

	@RequestMapping(value = { "/v1/customer/address" }, method = RequestMethod.GET)
	public ResponseEntity<String> profileAddress() {
		log.info("inside the profileAddress");
		// here goes aggregate domain services
		return new ResponseEntity<String>("profileAddress...", HttpStatus.OK);

	}

}

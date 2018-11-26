package com.pheonix.CustomerService.controllers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pheonix.CustomerService.pojo.Accounts;
import com.pheonix.CustomerService.pojo.BankAccounts;
import com.pheonix.CustomerService.pojo.Customer;
import com.pheonix.CustomerService.pojo.CustomerProfile;
import com.pheonix.CustomerService.services.CustomerDomainService;

@RestController
public class CustomerServiceController {

	private static final Logger log = LoggerFactory.getLogger(CustomerServiceController.class);

	@Autowired
	CustomerDomainService customerDomainService;

	@RequestMapping(value = { "/v1/customer/details/all" }, method = RequestMethod.GET)
	public ResponseEntity<CustomerProfile> customerProfile() {
		log.info("inside the CustomerProfile full details");

		long start = System.currentTimeMillis();

		CustomerProfile customerProfile = new CustomerProfile();

		try {
			CompletableFuture<Accounts> accounts = customerDomainService.getAccountsFromAggregatedService();
			CompletableFuture<Customer> customer = customerDomainService.getCustomerProfileFromDomain();

			CompletableFuture.allOf(accounts, customer).join();

			

			customerProfile.setAccounts(accounts.get());
			customerProfile.setCustomer(customer.get());

			log.info("customer full profile: " + customerProfile);
			log.info("Elapsed time: " + (System.currentTimeMillis() - start));

		} catch (InterruptedException e) {

			e.printStackTrace();

		} catch (ExecutionException e) {

			e.printStackTrace();
		}

		return new ResponseEntity<CustomerProfile>(customerProfile, HttpStatus.OK);

	}
	
	@RequestMapping(value = { "/v1/customer/details/banks" }, method = RequestMethod.GET)
	public ResponseEntity<BankAccounts> customerProfileOnlyProfile() throws Exception {
		BankAccounts bankAccounts = customerDomainService.getCustomerOnlyBankAccounts();
		return new ResponseEntity<BankAccounts>(bankAccounts, HttpStatus.OK);
	
	}

}

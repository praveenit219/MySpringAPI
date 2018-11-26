package com.pheonix.customer.dashboard.controller;

import java.util.ArrayList;
import java.util.List;
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

import com.pheonix.customer.dashboard.pojo.Accounts;
import com.pheonix.customer.dashboard.pojo.Customer;
import com.pheonix.customer.dashboard.pojo.CustomerProfile;
import com.pheonix.customer.dashboard.pojo.DashBoard;
import com.pheonix.customer.dashboard.services.DashBoardAggregateService;

@RestController
public class DashBoardController {
	
	private static final Logger log = LoggerFactory.getLogger(DashBoardController.class);



	@Autowired
	DashBoardAggregateService dashBoardAggregateService;
	
	@RequestMapping(value = { "/v1/dashboard" }, method = RequestMethod.GET)
	public ResponseEntity<DashBoard> aggregateAccounts() {
		long start = System.currentTimeMillis();

		log.info("inside the aggregateAccounts");
		// here goes aggregate domain services
		DashBoard dashBoard = new DashBoard();

		try {
			CompletableFuture<Accounts> accounts = dashBoardAggregateService.getAccountsService();
			CompletableFuture<CustomerProfile> customerProfile = dashBoardAggregateService
					.getCustomerProfileService();
			CompletableFuture<Customer> customer = dashBoardAggregateService.getCustomerDetailsService();
			
			CompletableFuture.allOf(accounts, customerProfile, customer).join();




			List<Accounts> accountsobj = new ArrayList<Accounts>();
			if(accounts.isDone()) {
				accountsobj.add(accounts.get());
			}
			
			List<CustomerProfile> customerProfileobj = new ArrayList<CustomerProfile>();
			if(customerProfile.isDone()) {
				customerProfileobj.add(customerProfile.get());
			}
			
			List<Customer> customerobj = new ArrayList<Customer>();
			if(customer.isDone()) {
				customerobj.add(customer.get());
			}
			
			

			
			dashBoard.setAccounts(accountsobj);
			dashBoard.setCustomer(customerobj);
			dashBoard.setCustomerProfile(customerProfileobj);

			log.info("AggregatedAccounts: " + accounts);
			log.info("Elapsed time: " + (System.currentTimeMillis() - start));

		} catch (InterruptedException e) {

			e.printStackTrace();

		} catch (ExecutionException e) {

			e.printStackTrace();
		}

		return new ResponseEntity<DashBoard>(dashBoard, HttpStatus.OK);

	}

}

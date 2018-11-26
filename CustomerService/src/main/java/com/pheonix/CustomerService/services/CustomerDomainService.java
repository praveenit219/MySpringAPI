package com.pheonix.CustomerService.services;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pheonix.CustomerService.config.ResourceEndpointUrl;
import com.pheonix.CustomerService.pojo.Accounts;
import com.pheonix.CustomerService.pojo.BankAccounts;
import com.pheonix.CustomerService.pojo.Customer;

@Service
public class CustomerDomainService {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerDomainService.class);

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ResourceEndpointUrl resourceEndpointUrl;

	@Async
	public CompletableFuture<Accounts> getAccountsFromAggregatedService() throws InterruptedException {
		log.info("firing accounts through eureka loadbalanced");
		String url = null;
		Accounts results = null;
		if (null != resourceEndpointUrl) {
			log.info("getting accounts endpoints to form url");
			url = "http://" + resourceEndpointUrl.getAccountsDomainEndPoint()
			+ resourceEndpointUrl.getAccountsResource().get(0);
		}

		if (null != url)
			results = restTemplate.getForObject(url, Accounts.class);
		log.info("resulst from  Accounts: " + results);
		return CompletableFuture.completedFuture(results);
	}

	@Async
	public CompletableFuture<Customer> getCustomerProfileFromDomain() throws InterruptedException {
		log.info("firing customer profile through eureka loadbalanced");
		String url = null;
		Customer results = null;
		if (null != resourceEndpointUrl) {
			log.info("getting profile endpoints to form url");
			url = "http://" + resourceEndpointUrl.getProfileDomainEndPoint()
			+ resourceEndpointUrl.getProfileResource().get(0);
			log.info(url);
		}

		if (null != url)
			results = restTemplate.getForObject(url, Customer.class);

		log.info("resulst from Profile Accounts: " + results);
		return CompletableFuture.completedFuture(results);
	}
	
	
	@HystrixCommand(fallbackMethod = "getCustomerOnlyBankAccounts_fallback")
	public BankAccounts getCustomerOnlyBankAccounts() throws Exception {
		
		log.info("firing customer bank onlyaccounts through eureka loadbalanced");
		String url = null;
		BankAccounts results = null;
		if (null != resourceEndpointUrl) {
			log.info("getting profile endpoints to form url");
			url = "http://BANKSDOMAINSERVICE/v1/banks/accounts";
			log.info(url);
		}

		if (null != url)
			results = restTemplate.getForObject(url, BankAccounts.class);

		log.info("resulst from BankAccounts : " + results);
		return results;
		
	}
	
	public BankAccounts getCustomerOnlyBankAccounts_fallback() throws Exception {
		log.info("firing fallback url bank onlyaccounts as service is down");
		return new BankAccounts();
		
	}

	
}

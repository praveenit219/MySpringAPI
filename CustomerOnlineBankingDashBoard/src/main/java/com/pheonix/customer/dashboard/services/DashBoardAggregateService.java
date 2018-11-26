package com.pheonix.customer.dashboard.services;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pheonix.customer.dashboard.config.ResourceEndpointUrl;
import com.pheonix.customer.dashboard.pojo.Accounts;
import com.pheonix.customer.dashboard.pojo.Customer;
import com.pheonix.customer.dashboard.pojo.CustomerProfile;



@Service
public class DashBoardAggregateService {
	
	private static final Logger log = LoggerFactory.getLogger(DashBoardAggregateService.class);

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ResourceEndpointUrl resourceEndpointUrl;
	
	@Async
	//@HystrixCommand(fallbackMethod = "getAccountsFromDomain_Fallback")
	public CompletableFuture<Accounts> getAccountsService() throws InterruptedException {
		log.info("firing Aggregated domain accounts through eureka loadbalanced");
		String url = null;
		Accounts results = null;
		if (null != resourceEndpointUrl) {
			log.info("getting Accounts endpoints to form url");
			url = "http://" + resourceEndpointUrl.getAccountsDomainEndPoint()
			+ resourceEndpointUrl.getAccountsResource().get(0);
		}

		if (null != url)
			results = restTemplate.getForObject(url, Accounts.class);
		log.info("resulst from Aggregated Accounts: " + results);
		return CompletableFuture.completedFuture(results);
	}
	
	@Async
	//@HystrixCommand(fallbackMethod = "getCustomerDetailsFromDomain_Fallback")
	public CompletableFuture<CustomerProfile> getCustomerProfileService() throws InterruptedException {
		log.info("firing Customer profile through eureka loadbalanced");
		String url = null;
		CustomerProfile results = null;
		if (null != resourceEndpointUrl) {
			log.info("getting customer profile endpoints to form url");
			url = "http://" + resourceEndpointUrl.getCustomerServiceDomainEndPoint()
			+ resourceEndpointUrl.getCustomerServiceResource().get(0);
		}

		if (null != url)
			results = restTemplate.getForObject(url, CustomerProfile.class);
		log.info("resulst from customer Profile : " + results);
		return CompletableFuture.completedFuture(results);
	}
	
	@Async
	//@HystrixCommand(fallbackMethod = "getCustomerDetailsFromDomain_Fallback")
	public CompletableFuture<Customer> getCustomerDetailsService() throws InterruptedException {
		log.info("firing Customer profile through eureka loadbalanced");
		String url = null;
		Customer results = null;
		if (null != resourceEndpointUrl) {
			log.info("getting customer Details endpoints to form url");
			url = "http://" + resourceEndpointUrl.getCustomerServiceDomainEndPoint()
			+ resourceEndpointUrl.getCustomerServiceResource().get(0);
		}

		if (null != url)
			results = restTemplate.getForObject(url, Customer.class);
		log.info("resulst from customer Details: " + results);
		return CompletableFuture.completedFuture(results);
	}

}

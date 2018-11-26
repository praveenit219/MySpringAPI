package com.pheonix.customer.dashboard.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ResourceEndpointUrl {

	
	@Value("#{'${accounts.domain.accountsResourceUri}'.split(',')}") 
	private List<String> accountsResource;

	@Value("#{'${customer.domain.customerServiceResourceUri}'.split(',')}") 
	private List<String> customerServiceResource;

	@Value("#{'${customer.domain.profileServiceResourceUri}'.split(',')}") 
	private List<String> profileServiceResource;
	
	@Value("${accounts.domain.accountsEndpoint:null}")
	private String accountsDomainEndPoint;

	@Value("${customer.domain.customerServiceEndpoint:null}")
	private String customerServiceDomainEndPoint;
	
	@Value("${customer.domain.profileServiceEndpoint:null}")
	private String profileServiceDomainEndPoint;

	
	

	public String getAccountsDomainEndPoint() {
		return accountsDomainEndPoint;
	}

	public void setAccountsDomainEndPoint(String accountsDomainEndPoint) {
		this.accountsDomainEndPoint = accountsDomainEndPoint;
	}

	public String getCustomerServiceDomainEndPoint() {
		return customerServiceDomainEndPoint;
	}

	public void setCustomerServiceDomainEndPoint(String customerServiceDomainEndPoint) {
		this.customerServiceDomainEndPoint = customerServiceDomainEndPoint;
	}

	public String getProfileServiceDomainEndPoint() {
		return profileServiceDomainEndPoint;
	}

	public void setProfileServiceDomainEndPoint(String profileServiceDomainEndPoint) {
		this.profileServiceDomainEndPoint = profileServiceDomainEndPoint;
	}

	public List<String> getAccountsResource() {
		return accountsResource;
	}

	public void setAccountsResource(List<String> accountsResource) {
		this.accountsResource = accountsResource;
	}

	public List<String> getCustomerServiceResource() {
		return customerServiceResource;
	}

	public void setCustomerServiceResource(List<String> customerServiceResource) {
		this.customerServiceResource = customerServiceResource;
	}

	public List<String> getProfileServiceResource() {
		return profileServiceResource;
	}

	public void setProfileServiceResource(List<String> profileServiceResource) {
		this.profileServiceResource = profileServiceResource;
	}

	
	


}


package com.pheonix.CustomerService.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ResourceEndpointUrl {

	@Value("#{'${accounts.domain.accountsResourceUri}'.split(',')}") 
	private List<String> accountsResource;

	@Value("#{'${profile.domain.profileResourceUri}'.split(',')}") 
	private List<String> profileResource;	

	@Value("${accounts.domain.accountsEndpoint:null}")
	private String accountsDomainEndPoint;	

	@Value("${profile.domain.profileEndpoint:null}")
	private String profileDomainEndPoint;

	public List<String> getAccountsResource() {
		return accountsResource;
	}

	public void setAccountsResource(List<String> accountsResource) {
		this.accountsResource = accountsResource;
	}

	public List<String> getProfileResource() {
		return profileResource;
	}

	public void setProfileResource(List<String> profileResource) {
		this.profileResource = profileResource;
	}

	public String getAccountsDomainEndPoint() {
		return accountsDomainEndPoint;
	}

	public void setAccountsDomainEndPoint(String accountsDomainEndPoint) {
		this.accountsDomainEndPoint = accountsDomainEndPoint;
	}

	public String getProfileDomainEndPoint() {
		return profileDomainEndPoint;
	}

	public void setProfileDomainEndPoint(String profileDomainEndPoint) {
		this.profileDomainEndPoint = profileDomainEndPoint;
	}

	
	
	


}


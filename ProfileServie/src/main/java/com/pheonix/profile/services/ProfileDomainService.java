package com.pheonix.profile.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pheonix.profile.pojo.Address;
import com.pheonix.profile.pojo.Customer;

@Service
public class ProfileDomainService {

	private static final Logger log = LoggerFactory.getLogger(ProfileDomainService.class);

	public Customer customerInformation() {
		log.info("inside the customer information Service");

		Customer customerInfo = fetchCustomerInfo();

		log.info("customerInfo is : " + customerInfo);

		return customerInfo;

	}

	private Customer fetchCustomerInfo() {

		String accountType = "PRV-CONFIDENTIAL";
		String loginBy = "email";
		String email = "name.email@domain.com";
		String username = "username";
		String password = "XXXXXX";
		String ssoUrl = "http://domain.com/" + java.util.UUID.randomUUID();
		String phoneno = "888-9999-222";
		String addressType = " PRV-CONFIDENTIAL";
		String street = "street-42";
		String buildingno = " BLK 445";
		String doorno = "11-987";
		String town = "pasar panjang";
		String country = "singapore";
		
		Address address = new Address();
		address.setAddressType(addressType);
		address.setStreet(street);
		address.setBuildingno(buildingno);
		address.setDoorno(doorno);
		address.setTown(town);
		address.setCountry(country);
		

		Customer customer = new Customer(accountType, loginBy, email, username, password, ssoUrl, phoneno, address);

		return customer;
	}

}

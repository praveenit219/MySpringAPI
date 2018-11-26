package com.pheonix.customer.dashboard.pojo;

import java.util.List;

public class DashBoard {

	private List<Accounts> accounts;
	private List<CustomerProfile> customerProfile;
	private List<Customer> customer;
	public List<Accounts> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Accounts> accounts) {
		this.accounts = accounts;
	}
	public List<CustomerProfile> getCustomerProfile() {
		return customerProfile;
	}
	public void setCustomerProfile(List<CustomerProfile> customerProfile) {
		this.customerProfile = customerProfile;
	}
	public List<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "DashBoard [accounts=" + accounts + ", customerProfile=" + customerProfile + ", customer=" + customer
				+ "]";
	}
	
	
	
	
}

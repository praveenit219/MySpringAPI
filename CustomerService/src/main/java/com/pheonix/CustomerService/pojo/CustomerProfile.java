package com.pheonix.CustomerService.pojo;

public class CustomerProfile {
	
	private Accounts accounts;
	private Customer customer;
	
	public Accounts getAccounts() {
		return accounts;
	}
	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CustomerProfile [accounts=" + accounts + ", customer=" + customer + "]";
	}
	
	

}

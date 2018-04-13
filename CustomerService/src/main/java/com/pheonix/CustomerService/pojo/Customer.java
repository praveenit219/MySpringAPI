package com.pheonix.CustomerService.pojo;

public class Customer {
	
	private String accountType;
	private String loginBy;
	private String email;
	private String username;
	private String password;
	private String ssoUrl;
	private String phoneno;
	private Address address;
	
	public Customer() {}
	
	public Customer(String accountType, String loginBy, String email, String username, String password, String ssoUrl,
			String phoneno, Address address) {
		
		this.accountType = accountType;
		this.loginBy = loginBy;
		this.email = email;
		this.username = username;
		this.password = password;
		this.ssoUrl = ssoUrl;
		this.phoneno = phoneno;
		this.address = address;
	}
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getLoginBy() {
		return loginBy;
	}
	public void setLoginBy(String loginBy) {
		this.loginBy = loginBy;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSsoUrl() {
		return ssoUrl;
	}
	public void setSsoUrl(String ssoUrl) {
		this.ssoUrl = ssoUrl;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
	
	


}

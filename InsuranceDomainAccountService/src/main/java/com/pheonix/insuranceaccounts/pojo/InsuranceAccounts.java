package com.pheonix.insuranceaccounts.pojo;

public class InsuranceAccounts extends Account {
	
	
	private String insuranceMode;
	private String linkedTo;
	
	public InsuranceAccounts(String accountNo,String accountType, String accountId, String accountName, 
			String accountStatus, Balance balances, String insuranceMode, String linkedTo) {
		
		super(accountNo, accountType, accountId, accountName,accountStatus, balances);
		
		this.linkedTo =linkedTo;
		this.insuranceMode = insuranceMode;
		
	}
	
	
	
	public String getInsuranceMode() {
		return insuranceMode;
	}
	public void setInsuranceMode(String insuranceMode) {
		this.insuranceMode = insuranceMode;
	}
	public String getLinkedTo() {
		return linkedTo;
	}
	public void setLinkedTo(String linkedTo) {
		this.linkedTo = linkedTo;
	}
	
	

}

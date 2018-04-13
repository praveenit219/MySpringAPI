package com.pheonix.bankaccounts.pojo;

public class BankAccounts extends Account {

	
	private String bankingMode;
	private String linkedTo;
	
	
	
	
	
	public BankAccounts(String accountNo,String accountType, String accountId, String accountName, 
			String accountStatus, Balance balances, String bankingMode, String linkedTo) {
		
		super(accountNo, accountType, accountId, accountName,accountStatus, balances);
		this.bankingMode = bankingMode;
		this.linkedTo =linkedTo;
	}
	
	
	public String getBankingMode() {
		return bankingMode;
	}
	public void setBankingMode(String bankingMode) {
		this.bankingMode = bankingMode;
	}
	public String getLinkedTo() {
		return linkedTo;
	}
	public void setLinkedTo(String linkedTo) {
		this.linkedTo = linkedTo;
	}


	@Override
	public String toString() {
		return "BankAccounts [bankingMode=" + bankingMode + ", linkedTo=" + linkedTo + "]";
	}
	
	
}

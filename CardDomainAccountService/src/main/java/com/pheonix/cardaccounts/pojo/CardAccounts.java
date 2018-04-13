package com.pheonix.cardaccounts.pojo;

public class CardAccounts extends Account {
	
	
	private String cardMode;
	private String cardStatus;
	private boolean overSeasCardActivation;
	private boolean overSeasCardUsageAllowed;
	private String linkedTo;
	
	
	public CardAccounts(String accountNo,String accountType, String accountId, String accountName, 
			String accountStatus, Balance balances, String cardMode, String cardStatus,
			boolean overSeasCardActivation, boolean overSeasCardUsageAllowed,String linkedTo) {
		
		super(accountNo, accountType, accountId, accountName,accountStatus, balances);
		this.cardMode = cardMode;
		this.linkedTo =linkedTo;
		this.cardStatus = cardStatus;
		this.overSeasCardActivation = overSeasCardActivation;
		this.overSeasCardUsageAllowed = overSeasCardUsageAllowed;
		
	}
	
	
	
	
	public String getCardMode() {
		return cardMode;
	}
	public void setCardMode(String cardMode) {
		this.cardMode = cardMode;
	}
	public String getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}
	
	public boolean isOverSeasCardActivation() {
		return overSeasCardActivation;
	}




	public void setOverSeasCardActivation(boolean overSeasCardActivation) {
		this.overSeasCardActivation = overSeasCardActivation;
	}




	public boolean isOverSeasCardUsageAllowed() {
		return overSeasCardUsageAllowed;
	}
	public void setOverSeasCardUsageAllowed(boolean overSeasCardUsageAllowed) {
		this.overSeasCardUsageAllowed = overSeasCardUsageAllowed;
	}
	public String getLinkedTo() {
		return linkedTo;
	}
	public void setLinkedTo(String linkedTo) {
		this.linkedTo = linkedTo;
	}
	
	

}

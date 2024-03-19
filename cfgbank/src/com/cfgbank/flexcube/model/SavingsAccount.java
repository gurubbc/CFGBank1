package com.cfgbank.flexcube.model;

public class SavingsAccount extends Account {
	
	// specific to SavingsAccount
	private double interestRate;

	
	
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public SavingsAccount(String accountType, int accountNumber, double accountBalance, double interestRate) {
		super(accountType, accountNumber, accountBalance);
		this.interestRate = interestRate;
	}
	
	// this is specific to this class
	public double calculateInterest() {
		// local variable
		double interestEarned=this.getAccountBalance()*this.interestRate;
		System.out.println("SavingsAccount...interest is "+interestEarned);
		return interestEarned;
	}
	
	// Method overriding
	public void checkBalance() {
		super.checkBalance();
		System.out.println("Interest Earned is "+(this.getAccountBalance()*this.interestRate));
	}

	@Override
	public String toString() {
		return "SavingsAccount [interestRate=" + interestRate + ", accountType=" + this.getAccountType() + ", accountNumber="
				+ this.getAccountNumber() + ", accountBalance=" + this.getAccountBalance() + "]";
	}

	@Override
	public double withdraw(double withdrawAmount) {
		if (withdrawAmount <= this.getAccountBalance()) {
			System.out.println("Successfully withdrawn....");
			this.setAccountBalance(this.getAccountBalance()-withdrawAmount);
			return withdrawAmount;
			
		}  else {
			System.out.println("You have insufficient balance, can't withdraw");
			System.out.println("Enter a smaller amount");
			return 0;
		}

	}

	
	
	
	
}

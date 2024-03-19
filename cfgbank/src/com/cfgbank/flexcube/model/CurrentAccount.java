package com.cfgbank.flexcube.model;

public class CurrentAccount extends Account {
	
	// specific to CurrentAccount
	// You can overwithdraw upto 2000 dirhams
	private double overwidthrawLimit;

	public CurrentAccount(String accountType, int accountNumber, double accountBalance, double overwidthrawLimit) {
		super(accountType, accountNumber, accountBalance);
		this.overwidthrawLimit = overwidthrawLimit;
	}
	
	@Override
	public double withdraw(double withdrawAmount) {
		System.out.println("Current Account : Current balance "+this.getAccountBalance());
		System.out.println("Over Withdraw Limit "+this.overwidthrawLimit);
		System.out.println("So, you can withdraw upto "+(this.getAccountBalance()+this.overwidthrawLimit));
		if (withdrawAmount <= (this.getAccountBalance()+this.overwidthrawLimit)) {
			System.out.println("Current Account Successfully withdrawn....");
			this.setAccountBalance(this.getAccountBalance()-withdrawAmount);
			return withdrawAmount;
			
		}  else {
			System.out.println("Current Account You have insufficient balance, can't withdraw");
			System.out.println("Enter a smaller amount");
			return 0;
		}
	}

	@Override
	public String toString() {
		return "CurrentAccount [overwidthrawLimit=" + overwidthrawLimit + ", accountType=" + this.getAccountType()
				+ ", accountNumber=" + this.getAccountNumber()+ ", accountBalance=" + this.getAccountBalance() + "]";
	}

	
	
}

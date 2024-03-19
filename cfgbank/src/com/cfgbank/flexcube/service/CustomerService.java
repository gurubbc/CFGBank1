package com.cfgbank.flexcube.service;

import com.cfgbank.flexcube.model.Account;
import com.cfgbank.flexcube.model.CurrentAccount;
import com.cfgbank.flexcube.model.Customer;
import com.cfgbank.flexcube.model.SavingsAccount;

import java.util.Random;
import java.util.UUID;

public class CustomerService {
	public Account openAccount(Customer customer, String accountType) {

		// kyc logic starts here, first check the mobile number length
		Account newAccount=null;  
		boolean isKYCValid=false;

		// convert mobileNumber to String type
		String mobNumber=String.valueOf(customer.getMobileNumber());
		boolean isMobileNumberValid=mobNumber.length()==10?true:false;
		boolean isEmailValid=(customer.getEmailId().length()!=0);
		String rnp=String.valueOf(customer.getRnpNumber());
		boolean isRnpNumberValid=(rnp.length()!=0) && (rnp.length()==10);
		boolean isCinNumberValid=(customer.getCinNumber().length()!=0 && customer.getCinNumber().length()==10);

		
		if (isMobileNumberValid && isEmailValid && isRnpNumberValid && isCinNumberValid) {
			// include the logic to create the type of account
			if (accountType.equalsIgnoreCase("Savings"))
				newAccount=new SavingsAccount("Savings", generateAccountNumber(),2000.0,0.029);
			if (accountType.equalsIgnoreCase("Current"))
				newAccount=new CurrentAccount("Current", generateAccountNumber(),2000.0,2000.0);
				

		}
			
		return newAccount;

	}
	
	public int generateAccountNumber() {
			Random r=new Random();
//			return Integer.parseInt(UUID.randomUUID().toString());
			return r.nextInt(100);
			
	}
	
	
}

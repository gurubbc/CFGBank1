package com.cfgbank.flexcube;

import java.util.Date;

import com.cfgbank.flexcube.model.Account;
import com.cfgbank.flexcube.model.Customer;
import com.cfgbank.flexcube.controller.Services;

public class MainApp {

	public static void main(String[] args) {
		Customer customer=new Customer(1, "Guru", "Murthy", "12 Main Street, Casablanca", new Date(2000,10,2), 'M', 9731801675L, "guru@yahoo.com", 1234567890L, "AB23482858", 50,null);
		
		Services services=new Services();
		
		Account account=services.applyForNewAccount(customer,"Savings");
		
		if (account.getAccountNumber()!=0) {
			System.out.println("Acccount has been opened successfully");
			System.out.println("This is your account no "+account.getAccountNumber());
			System.out.println("Find your account details below");
			customer.setAccount(account);
			System.out.println(customer);
			System.out.println("Before withdraw "+customer.getAccount().getAccountBalance());
			customer.getAccount().withdraw(500000);
			System.out.println("After withdraw "+customer.getAccount().getAccountBalance());
			customer.getAccount().deposit(500);
			System.out.println("After deposit "+customer.getAccount().getAccountBalance());
			
		}
		else {
			System.out.println("Please check the KYC details, some error in document");
			System.out.println("One of the KYC validation failed....please check");
			System.out.println("Account has not been created");
		}
		
		Account account1=services.applyForNewAccount(customer,"Current");
		
		if (account1.getAccountNumber()!=0) {
			System.out.println("Acccount has been opened successfully");
			System.out.println("This is your account no "+account1.getAccountNumber());
			System.out.println("Account type is "+account1.getAccountType());
			System.out.println("Find your account details below");
			customer.setAccount(account1);
			System.out.println(customer);
			System.out.println("Before withdraw "+customer.getAccount().getAccountBalance());
			customer.getAccount().withdraw(4000);
			System.out.println("After withdraw "+customer.getAccount().getAccountBalance());
			customer.getAccount().deposit(500);
			System.out.println("After deposit "+customer.getAccount().getAccountBalance());
			
		}
		else {
			System.out.println("Please check the KYC details, some error in document");
			System.out.println("One of the KYC validation failed....please check");
			System.out.println("Account has not been created");
		}
	}

}

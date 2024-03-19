package com.cfgbank.flexcube;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cfgbank.flexcube.model.Account;
import com.cfgbank.flexcube.model.CurrentAccount;
import com.cfgbank.flexcube.model.Customer;
import com.cfgbank.flexcube.model.SavingsAccount;

public class MainApp1 {

	public static void main(String[] args) {
		Map<Integer, Customer> allCustomers=new HashMap<>();
		
		// Create a bunch of customer object
		Account ac1=new SavingsAccount("Savings",12345,3882828382.2,0.2);
		Customer c1=new Customer(20, "Fadwa", "Dani", "Main St", new java.util.Date(), 'F',123485848, "f@gmail.com", 181818L, "abcd123", 22, ac1);

		Account ac2=new CurrentAccount("Current", 2345, 929922.0, 500);
		Customer c2=new Customer(21, "Jamal", "Aitsalh", "Main St", new java.util.Date(), 'M',34343434, "jamal@yahoo.com", 2828282L, "abcd333", 22, ac2);

		
		Account ac3=new SavingsAccount("Savings",122345,385382.2,0.2);
		Customer c3=new Customer(22, "Yusuf", "Akbar", "1st Street", new java.util.Date(), 'M',3838833, "yusuf@gmail.com", 181818L, "itlm2727", 21, ac3);

		
	
		allCustomers.put(c1.getId(), c1);
		allCustomers.put(c2.getId(), c2);
		allCustomers.put(c3.getId(), c3);
		
		// Use Case 1:
//		List out only customer's first name
		
		Set<Integer> allKeys=allCustomers.keySet();
		Iterator iterator=allKeys.iterator();
		while (iterator.hasNext()) {
			int key=(int) iterator.next();
			Customer cust=allCustomers.get(key);
			System.out.println(cust.getFirstName());
			
		}
		
		System.out.println("Total account balance is "+totalBalance(allCustomers));
		System.out.println("Name of the customer with highest balance is "+displayTheHighestAccountBalanceHoderName(allCustomers));
		
		System.out.println("List of yahoo users "+filterAllGmailUsers(allCustomers));
		
	}
	
	public static double totalBalance(Map<Integer, Customer> allCustomers) {
		double totalAccountBalance=0;
		Set<Integer> allKeys=allCustomers.keySet();
		Iterator<Integer> iterator=allKeys.iterator();
		while (iterator.hasNext()) {
			int key=(int) iterator.next();
			Customer cust=allCustomers.get(key);
			totalAccountBalance=totalAccountBalance+cust.getAccount().getAccountBalance();
			
		}
		return totalAccountBalance;
	}
	
	public static String displayTheHighestAccountBalanceHoderName(Map<Integer, Customer> allCustomers) {
		String nameOfCustomer="";
		double highestAccountBalance=0;
		Set<Integer> allKeys=allCustomers.keySet();
		Iterator<Integer> iterator=allKeys.iterator();
		while (iterator.hasNext()) {
			int key=(int) iterator.next();
			Customer cust=allCustomers.get(key);
			if (cust.getAccount().getAccountBalance() > highestAccountBalance)
			{
				highestAccountBalance=cust.getAccount().getAccountBalance();
				nameOfCustomer=cust.getFirstName();
			}
			
		}
		return nameOfCustomer;
	}
	
	public static List<String> filterAllGmailUsers(Map<Integer, Customer> allCustomers) {
		List<String> allGmailUsers=new ArrayList<>();
		Set<Integer> allKeys=allCustomers.keySet();
		Iterator<Integer> iterator=allKeys.iterator();
		while (iterator.hasNext()) {
			int key=(int) iterator.next();
			Customer cust=allCustomers.get(key);
			String emailAddress=cust.getEmailId().toUpperCase();
			if (emailAddress.contains("YAHOO")) {
				allGmailUsers.add(cust.getFirstName());
			}
			
		}
		return allGmailUsers;
	}
}

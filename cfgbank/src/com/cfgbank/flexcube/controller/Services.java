package com.cfgbank.flexcube.controller;

import com.cfgbank.flexcube.model.Account;
import com.cfgbank.flexcube.model.Customer;
import com.cfgbank.flexcube.service.CustomerService;

public class Services {
	
	public Account applyForNewAccount(Customer customer, String accountType) {
		CustomerService customerService=new CustomerService();
		return customerService.openAccount(customer, accountType);
	}
}

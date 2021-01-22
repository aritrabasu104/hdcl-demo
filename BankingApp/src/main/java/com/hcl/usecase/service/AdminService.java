package com.hcl.usecase.service;

import java.util.List;

import com.hcl.usecase.model.Account;
import com.hcl.usecase.model.BalanceDetail;
import com.hcl.usecase.model.Customer;

public interface AdminService {

	Customer register(Customer customer);
	Account addAccount(Account account);
	void activateAccounts();
	
	List<Customer> getCustomers();
	List<Account> getAccounts();
	BalanceDetail updateBalance(BalanceDetail balanceDetail);
}

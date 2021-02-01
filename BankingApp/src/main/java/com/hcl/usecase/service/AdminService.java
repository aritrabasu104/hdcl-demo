package com.hcl.usecase.service;

import java.util.List;

import com.hcl.usecase.model.Account;
import com.hcl.usecase.model.BalanceDetail;
import com.hcl.usecase.model.BankCustomer;

public interface AdminService {

	BankCustomer register(BankCustomer customer);
	Account addAccount(Account account);
//	void activateAccounts();
	
	List<BankCustomer> getCustomers();
	List<Account> getAccounts();
	BalanceDetail updateBalance(BalanceDetail balanceDetail);
}

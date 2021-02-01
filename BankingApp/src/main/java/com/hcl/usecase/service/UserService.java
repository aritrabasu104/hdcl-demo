package com.hcl.usecase.service;

import java.util.Date;
import java.util.List;

import com.hcl.usecase.error.custom.InsufficientBalanceException;
import com.hcl.usecase.error.custom.SameAccountException;
import com.hcl.usecase.model.Account;
import com.hcl.usecase.model.BankTransaction;

public interface UserService {

	void transferFund(Account fromAccount,Account toAccount, Double amount) throws InsufficientBalanceException, SameAccountException;

	List<BankTransaction> generateStatement(Date fromDate, Date toDate, Account account);

	Account getAccountDetail(Long accNo);
}

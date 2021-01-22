package com.hcl.usecase.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.usecase.error.custom.InsufficientBalanceException;
import com.hcl.usecase.error.custom.SameAccountException;
import com.hcl.usecase.model.Account;
import com.hcl.usecase.model.BalanceDetail;
import com.hcl.usecase.model.Transaction;
import com.hcl.usecase.model.Transaction.TransactionType;
import com.hcl.usecase.repository.AccountRepository;
import com.hcl.usecase.repository.BalanceDetailRepository;
import com.hcl.usecase.repository.TransactionRepository;
import com.hcl.usecase.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private BalanceDetailRepository balanceDetailRepository;

	@Override
	public void transferFund(Account fromAccount, Account toAccount, Double amount) throws InsufficientBalanceException, SameAccountException {
		fromAccount = accountRepository.findById(fromAccount.getAccountId()).get();
		toAccount = accountRepository.findById(toAccount.getAccountId()).get();
		if(fromAccount.getAccountId().equals(toAccount.getAccountId()))
			throw new SameAccountException(fromAccount);
		else if(fromAccount.getBalanceDetail().getBalance() < amount)
			throw new InsufficientBalanceException(fromAccount);
		
		BalanceDetail fromAccountBalanceDetail = fromAccount.getBalanceDetail();
		BalanceDetail toAccountBalanceDetail = toAccount.getBalanceDetail();
		
		// update balances and save transaction records
		fromAccountBalanceDetail.setBalance(fromAccountBalanceDetail.getBalance()-amount);
		toAccountBalanceDetail.setBalance(toAccountBalanceDetail.getBalance()+amount);
		
		balanceDetailRepository.save(fromAccountBalanceDetail);
		balanceDetailRepository.save(toAccountBalanceDetail);
	
		saveTransactionInfo(fromAccountBalanceDetail,toAccountBalanceDetail, amount);
		
	}
	
	private void saveTransactionInfo(BalanceDetail fromAccountBalanceDetail,BalanceDetail toAccountBalanceDetail, Double amount) {
		Date date = new Date();
		
		Transaction debit = new Transaction();
		debit.setAmount(amount);
		debit.setTransactionType(TransactionType.DEBIT);
		debit.setDate(date);
		debit.setBalanceDetail(fromAccountBalanceDetail);
		transactionRepository.save(debit);
		
		Transaction credit = new Transaction();
		credit.setAmount(amount);
		credit.setTransactionType(TransactionType.CREDIT);
		credit.setDate(date);
		credit.setBalanceDetail(toAccountBalanceDetail);
		transactionRepository.save(credit);
	}

	@Override
	public List<Transaction> generateStatement(Date fromDate, Date toDate, Account account) {
		account = accountRepository.findById(account.getAccountId()).get();
		return account.getBalanceDetail().getTransactions().stream().filter(item->{
			return item.getDate().after(fromDate) && item.getDate().before(toDate);
		}).collect(Collectors.toList());
	}
	

}

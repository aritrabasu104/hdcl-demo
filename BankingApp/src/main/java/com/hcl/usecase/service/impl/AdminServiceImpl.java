package com.hcl.usecase.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.usecase.model.Account;
import com.hcl.usecase.model.Account.AccountStatus;
import com.hcl.usecase.model.BalanceDetail;
import com.hcl.usecase.model.BankCustomer;
import com.hcl.usecase.repository.AccountRepository;
import com.hcl.usecase.repository.BalanceDetailRepository;
import com.hcl.usecase.repository.CustomerRepository;
import com.hcl.usecase.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private BalanceDetailRepository balanceDetailRepository;
	
	@Override
	public BankCustomer register(BankCustomer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Account addAccount(Account account) {
		account = accountRepository.save(account);
		BalanceDetail balanceDetail = new BalanceDetail();
		balanceDetail.setAccount(account);
		balanceDetail.setBalance(0d);
		balanceDetail = balanceDetailRepository.save(balanceDetail);
		account.setBalanceDetail(balanceDetail);
		account.setAccountStatus(AccountStatus.ACTIVE);	
		return accountRepository.save(account);
	}

//	@Override
//	public void activateAccounts() {
//		List<Account> accounts = accountRepository.findAllByAccountStatus(AccountStatus.PENDING_VERIFICATION)
//				.stream().map(account -> {
//					BalanceDetail balanceDetail = new BalanceDetail();
//					balanceDetail.setAccount(account);
//					balanceDetail.setBalance(0d);
//					balanceDetail = balanceDetailRepository.save(balanceDetail);
//					account.setBalanceDetail(balanceDetail);
//					account.setAccountStatus(AccountStatus.ACTIVE);	
//					return account;
//				}).collect(Collectors.toList());
//		accountRepository.saveAll(accounts);
//	}

	@Override
	public List<BankCustomer> getCustomers() {
		List<BankCustomer> result = new ArrayList<>();
		customerRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public List<Account> getAccounts() {
		List<Account> result = new ArrayList<>();
		accountRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public BalanceDetail updateBalance(BalanceDetail balanceDetail) {
		Double updatedBalance = balanceDetail.getBalance();
		balanceDetail = balanceDetailRepository.findById(balanceDetail.getId()).get();
		balanceDetail.setBalance(updatedBalance);
		balanceDetail = balanceDetailRepository.save(balanceDetail);
		return balanceDetail;
	}
}

package com.hcl.usecase.error.custom;

import com.hcl.usecase.model.Account;

public class InsufficientBalanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1702359716273594933L;
	public InsufficientBalanceException(Account account) {
		super("Insufficient balance for Account: "+account.getAccountId());
	}

}

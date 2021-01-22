package com.hcl.usecase.error.custom;

import com.hcl.usecase.model.Account;

public class SameAccountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1702359716273594933L;
	public SameAccountException(Account account) {
		super("Same source and destination account: "+account.getAccountId());
	}

}

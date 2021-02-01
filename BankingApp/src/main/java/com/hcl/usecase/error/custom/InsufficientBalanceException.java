package com.hcl.usecase.error.custom;

public class InsufficientBalanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1702359716273594933L;
	public InsufficientBalanceException(Long accountId) {
		super("Insufficient balance for Account: "+accountId);
	}

}

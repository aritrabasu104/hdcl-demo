package com.hcl.usecase.api.error;

public class InsufficientBalanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1702359716273594933L;
	public InsufficientBalanceException() {
		super("Insufficient balance for user Account: ");
	}

}

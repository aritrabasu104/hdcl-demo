package com.hcl.usecase.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class AccountResponseDto {

	private Long accountId;
	
	private String accountType;
	
	private String accountStatus;
	
	private CustomerRegistrationResponseDto customer;
	
	private BalanceDetailWithIdDto balanceDetail;
}

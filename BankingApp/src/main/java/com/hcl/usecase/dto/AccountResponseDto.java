package com.hcl.usecase.dto;



import com.hcl.usecase.model.Account.AccountStatus;
import com.hcl.usecase.model.Account.AccountType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class AccountResponseDto {

	private Long accountId;
	
	private AccountType accountType;
	
	private AccountStatus accountStatus;
	
	private CustomerRegistrationResponseDto customer;
	
	private BalanceDetailWithIdDto balanceDetail;
}

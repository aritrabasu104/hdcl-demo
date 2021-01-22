package com.hcl.usecase.dto;

import com.hcl.usecase.model.Account.AccountType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class AccountRequestDto {

	private AccountType accountType;
	
	private CustomerRegistrationResponseDto customer;
	
}

package com.hcl.usecase.dto;

import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class TransferRequestDto {

	private AccountIdOnlyDto fromAccount;
	
	private AccountIdOnlyDto toAccount;
	
	@Min(1)
	private Double amount;
	
}

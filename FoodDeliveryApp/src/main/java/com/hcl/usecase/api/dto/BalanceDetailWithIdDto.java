package com.hcl.usecase.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BalanceDetailWithIdDto {

	private Long id;
	
	private Double balance;
		
}

package com.hcl.usecase.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BalanceUpdateDto {

	private Long id;
	
	private Double balance;
	
}

package com.hcl.usecase.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BalanceDetailDto {

	private Double balance;
	
	private List<TransactionDto> transactions;
	
}

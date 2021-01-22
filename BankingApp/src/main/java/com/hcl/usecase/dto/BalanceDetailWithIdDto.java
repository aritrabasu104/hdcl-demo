package com.hcl.usecase.dto;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BalanceDetailWithIdDto {

	private UUID id;
	
	private Double balance;
	
	private List<TransactionDto> transactions;
	
}

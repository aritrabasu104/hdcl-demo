package com.hcl.usecase.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BalanceUpdateDto {

	private UUID id;
	
	private Double balance;
	
}

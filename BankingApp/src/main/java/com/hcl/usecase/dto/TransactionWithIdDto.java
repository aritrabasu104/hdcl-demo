package com.hcl.usecase.dto;

import java.util.Date;
import java.util.UUID;

import com.hcl.usecase.model.Transaction.TransactionType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class TransactionWithIdDto {
	private UUID id;
	
	private Double amount;
	
	private Date date;
	
	private TransactionType transactionType;
	
}

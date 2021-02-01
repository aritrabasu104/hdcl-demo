package com.hcl.usecase.dto;

import java.util.Date;

import com.hcl.usecase.model.BankTransaction.TransactionType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class TransactionWithIdDto {
	private Long id;
	
	private Double amount;
	
	private Date date;
	
	private TransactionType transactionType;
	
}

package com.hcl.usecase.dto;

import java.util.Date;

import javax.validation.constraints.Min;

import com.hcl.usecase.model.Transaction.TransactionType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class TransactionDto {
	@Min(1)
	private Double amount;
	
	private Date date;
	
	private TransactionType transactionType;
	
}

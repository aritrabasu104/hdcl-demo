package com.hcl.usecase.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Transaction {

	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private UUID Id;
	
	@ManyToOne
	private BalanceDetail balanceDetail;
	
	private Double amount;
	
	private Date date;
	
	private TransactionType transactionType;
	
	public enum TransactionType{
		CREDIT,DEBIT
	}
}

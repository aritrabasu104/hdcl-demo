package com.hcl.usecase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_num_seq")
	@SequenceGenerator(
			  name = "account_num_seq",
			  initialValue = 100000000)
	@EqualsAndHashCode.Include
	private Long accountId;
	
	private AccountType accountType;
	
	private AccountStatus accountStatus = AccountStatus.PENDING_VERIFICATION;
	
	@ManyToOne
	private Customer customer;
	
	@OneToOne(mappedBy = "account")
	private BalanceDetail balanceDetail;
	
	public enum AccountStatus{
		PENDING_VERIFICATION,ACTIVE,DISABLED
	}
	public enum AccountType{
		SAVINGS, CURRENT, CREDIT_CARD
	}
	
}

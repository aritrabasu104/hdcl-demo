package com.hcl.usecase.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BalanceDetail {

	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Long Id;
	
	private Double balance;
	
	@OneToOne
	private Account account;
	
	@OneToMany(mappedBy = "balanceDetail")
	private List<BankTransaction> transactions;
	
}

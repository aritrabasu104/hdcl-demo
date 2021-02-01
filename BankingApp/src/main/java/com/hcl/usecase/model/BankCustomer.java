package com.hcl.usecase.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @author aritr
 * model for new connection
 */
@Entity
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BankCustomer {
	
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Long Id;
	
	@NotBlank
	private String fname;
	
	@NotBlank
	private String lname;
	
	@Email
	private String email;
	
	@NotNull
	@Column(unique=true)
	@Pattern(regexp="(^$|[0-9]{10})")
	private String mobileNumber;
	
	@OneToMany(mappedBy = "customer")
	private List<Account> accounts;
	
}

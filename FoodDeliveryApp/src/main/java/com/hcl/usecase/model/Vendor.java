package com.hcl.usecase.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vendor {

	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private Long accountNumber;	
	
	@OneToMany(mappedBy = "vendor")
	private List<Food> food;
}

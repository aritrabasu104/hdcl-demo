package com.hcl.usecase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Food {

	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotNull
	private String name;
	
	@Min(1)
	@NotNull
	private Double price;
	
	@ManyToOne
	private Vendor vendor;
}

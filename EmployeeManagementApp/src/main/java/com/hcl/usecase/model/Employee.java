package com.hcl.usecase.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {

	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private UUID id;
	
	@NotNull
	private String name;
	
	private LocalDate joiningDate;
	
	private LocalTime joiningTime;
	
	@NotNull
	private Boolean isManager;
}

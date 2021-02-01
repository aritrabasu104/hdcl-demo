package com.hcl.usecase.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter @Setter @ToString
public class OrderUnit {
	
	private Integer quantity;
	
	@ManyToOne
	private Food food;
}

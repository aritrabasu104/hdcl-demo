package com.hcl.usecase.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class FoodOrder {
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotNull
	@ManyToOne
	private User user;
	
	@NotNull
	private Long accountNo;
	
	@ElementCollection
	private List<OrderUnit> orderUnits;
	
	private OrderStatus orderStatus = OrderStatus.PENDING;
	
	private String comment = "";
	
	public enum OrderStatus{
		PENDING,ACCEPTED,REJECTED
	}
}

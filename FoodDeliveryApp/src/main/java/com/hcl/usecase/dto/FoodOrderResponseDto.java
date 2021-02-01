package com.hcl.usecase.dto;

import java.util.List;

import com.hcl.usecase.model.FoodOrder.OrderStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class FoodOrderResponseDto {
	
	private UserResponseDto user;
	
	private Long accountNo;
	
	private List<OrderUnitResponseDto> orderUnits;
	
	private OrderStatus orderStatus;
	
	private String comment;
}

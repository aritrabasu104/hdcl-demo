package com.hcl.usecase.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
public class OrderUnitResponseDto {
	
	private Integer quantity;
	private FoodRequestDto food;
}

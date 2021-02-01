package com.hcl.usecase.dto;

import javax.validation.constraints.Min;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
public class OrderUnitRequestDto {
	@Min(1)
	private Integer quantity;
	@NotNull
	private FoodResponseDto food;
}

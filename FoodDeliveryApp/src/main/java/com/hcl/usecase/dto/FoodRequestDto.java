package com.hcl.usecase.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class FoodRequestDto {

	@NotNull
	private String name;
	
	@Min(1)
	@NotNull
	private Double price;
	
	private VendorResponseDto vendor;
}

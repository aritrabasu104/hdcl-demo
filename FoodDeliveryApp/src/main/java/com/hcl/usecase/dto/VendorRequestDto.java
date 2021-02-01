package com.hcl.usecase.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class VendorRequestDto {

	@NotNull
	private String name;
	
	@NotNull
	private Long accountNumber;	
	
	private List<FoodResponseDto> food;
}

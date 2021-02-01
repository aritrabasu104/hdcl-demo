package com.hcl.usecase.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDto {

	@NotNull
	private UserResponseDto user;

	@NotNull
	private Long accountNo;

	@NotNull
	@Valid
	private List<OrderUnitRequestDto> orderUnits;

}

package com.hcl.usecase.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class UserRequestDto {
	@NotNull
	private String name;
	
}

package com.hcl.usecase.api.dto;

import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequestDto {

	private AccountIdOnlyDto fromAccount;
	
	private AccountIdOnlyDto toAccount;
	
	@Min(1)
	private Double amount;
	
}

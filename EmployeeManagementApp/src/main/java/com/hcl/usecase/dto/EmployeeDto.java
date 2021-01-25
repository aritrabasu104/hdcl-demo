package com.hcl.usecase.dto;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class EmployeeDto {

	@NotBlank
	private String name;
	
	@Valid
	private LocalDate joiningDate;
	
	@Valid
	private MyLocalTime joiningTime;
	
	@NotNull
	private Boolean isManager;
	

	@Getter @Setter
	public static class MyLocalDate{
		
		@Min(2010)
		private Integer year;
		
		@Min(1)@Max(12)
		private Integer month;
		
		@Min(1)@Max(31)
		private Integer dayOfMonth;
	}
	
	@Getter @Setter
	public class MyLocalTime{
		
		@Min(0)@Max(23)
		private Integer hour;
		
		@Min(0)@Max(59)
		private Integer minute;
		
		@Min(0)@Max(59)
		private Integer second;
	}
}

package com.hcl.usecase.dto;

import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class StatementDto {

	private AccountIdOnlyDto accountIdOnlyDto;
	
	private MONTH fromMonth;
	
	private MONTH toMonth;
	
	@Min(value = 2010)
	private Integer fromYear;
	
	@Min(value = 2010)
	private Integer toYear;
	
	@Getter
	public enum MONTH{
		JAN(1),FEB(2),MAR(3),APR(4),MAY(5),JUN(6),JUL(7),AUG(8),SEP(9),OCT(10),NOV(11),DEC(12);
		
		private int number;
		
		MONTH(int number){
			this.number = number;
		}
	}
	
}

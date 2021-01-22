package com.hcl.usecase.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @author aritr
 * model for new connection
 */
@Getter @Setter @ToString
public class CustomerRegistrationRequestDto {
	
	@NotBlank
	private String fname;
	
	@NotBlank
	private String lname;
	
	@Email
	private String email;
	
	@NotBlank
	@Pattern(regexp="(^$|[0-9]{10})")
	private String mobileNumber;
	
	
}

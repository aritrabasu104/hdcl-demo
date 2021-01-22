package com.hcl.usecase.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.usecase.dto.AccountRequestDto;
import com.hcl.usecase.dto.AccountResponseDto;
import com.hcl.usecase.dto.BalanceDetailDto;
import com.hcl.usecase.dto.BalanceUpdateDto;
import com.hcl.usecase.dto.CustomerRegistrationRequestDto;
import com.hcl.usecase.dto.CustomerRegistrationResponseDto;
import com.hcl.usecase.model.Account;
import com.hcl.usecase.model.BalanceDetail;
import com.hcl.usecase.model.Customer;
import com.hcl.usecase.service.AdminService;

@RestController
@Validated
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/customer")
	public ResponseEntity<List<CustomerRegistrationResponseDto>> register(){
		return ResponseEntity.status(201)
				.body(adminService.getCustomers().stream().map(item ->
				modelMapper.map(item, CustomerRegistrationResponseDto.class)).collect(Collectors.toList()));
	}
	
	@PostMapping("/customer")
	public ResponseEntity<CustomerRegistrationResponseDto> register(@Valid @RequestBody CustomerRegistrationRequestDto 
			customerRegistrationRequestDto){
		Customer customer = modelMapper.map(customerRegistrationRequestDto, Customer.class);
		return ResponseEntity.ok(modelMapper.map(adminService.register(customer), CustomerRegistrationResponseDto.class));
	}
	
	@GetMapping("/account")
	public ResponseEntity<List<AccountResponseDto>> getAcoounts(){
		return ResponseEntity.ok(adminService.getAccounts().stream().map(item ->
				modelMapper.map(item, AccountResponseDto.class)).collect(Collectors.toList()));
	}
	
	@PostMapping("/account")
	public ResponseEntity<AccountResponseDto> addAcoount(@Valid @RequestBody AccountRequestDto 
			accountRequestDto){
		Account account = modelMapper.map(accountRequestDto, Account.class);
		return ResponseEntity.status(201)
				.body(modelMapper.map(adminService.addAccount(account), AccountResponseDto.class));
	}
	
	@PostMapping("/balance")
	public ResponseEntity<BalanceDetailDto> updateBalance(@Valid @RequestBody BalanceUpdateDto balanceUpdateDto){
		BalanceDetail balanceDetail = modelMapper.map(balanceUpdateDto, BalanceDetail.class);
		return ResponseEntity.status(201)
				.body(modelMapper.map(adminService.updateBalance(balanceDetail), BalanceDetailDto.class));
	}
}

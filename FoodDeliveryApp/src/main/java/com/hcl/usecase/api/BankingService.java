package com.hcl.usecase.api;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.usecase.api.dto.AccountResponseDto;
import com.hcl.usecase.api.dto.TransferRequestDto;
import com.sun.istack.NotNull;

@FeignClient(name = "http://banking-service/api/user")
public interface BankingService {

	@PostMapping("/transfer")
	public ResponseEntity<?> transfer (@Valid @RequestBody TransferRequestDto transferRequestDto);
	
	@GetMapping("/balance")
	public ResponseEntity<AccountResponseDto> getBalance(@RequestParam @NotNull Long accNo);
}

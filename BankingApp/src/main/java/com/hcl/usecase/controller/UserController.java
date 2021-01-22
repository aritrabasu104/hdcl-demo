package com.hcl.usecase.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.usecase.dto.StatementDto;
import com.hcl.usecase.dto.TransactionWithIdDto;
import com.hcl.usecase.dto.TransferRequestDto;
import com.hcl.usecase.error.custom.InsufficientBalanceException;
import com.hcl.usecase.error.custom.SameAccountException;
import com.hcl.usecase.model.Account;
import com.hcl.usecase.model.Transaction;
import com.hcl.usecase.service.UserService;

@RestController
@Validated
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserService userService;

	@PostMapping("/transfer")
	public ResponseEntity<?> register(@Valid @RequestBody TransferRequestDto transferRequestDto)
			throws InsufficientBalanceException, SameAccountException {
		Account fromAccount = modelMapper.map(transferRequestDto.getFromAccount(), Account.class);
		Account toAccount = modelMapper.map(transferRequestDto.getToAccount(), Account.class);
		userService.transferFund(fromAccount, toAccount, transferRequestDto.getAmount());
		return ResponseEntity.ok().build();
	}

	@PostMapping("/statement")
	public ResponseEntity<List<TransactionWithIdDto>> generateStatement(@Valid @RequestBody StatementDto statementDto) {
		Account account = modelMapper.map(statementDto.getAccountIdOnlyDto(), Account.class);
		Calendar calendar = Calendar.getInstance();
		calendar.set(statementDto.getFromYear(), statementDto.getFromMonth().getNumber() - 1, 1);
		Date fromDate = calendar.getTime();

		calendar.set(statementDto.getToYear(), statementDto.getToMonth().getNumber() - 1, 1);
		Date toDate = calendar.getTime();

		List<Transaction> transactions = userService.generateStatement(fromDate, toDate, account);
		return ResponseEntity.ok(transactions.stream().map(item -> modelMapper.map(item, TransactionWithIdDto.class))
				.collect(Collectors.toList()));
	}

}

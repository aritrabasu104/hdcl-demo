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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.usecase.api.error.InsufficientBalanceException;
import com.hcl.usecase.dto.FoodOrderResponseDto;
import com.hcl.usecase.dto.FoodSearchResponseDto;
import com.hcl.usecase.dto.OrderDto;
import com.hcl.usecase.model.FoodOrder;
import com.hcl.usecase.service.UserService;

@RestController
@Validated
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/search")
	public ResponseEntity<List<FoodSearchResponseDto>> searchFoodByName(@RequestParam String name){
		return ResponseEntity.status(200)
				.body(userService.searchFood(name).stream().map(item-> 
				modelMapper.map(item,FoodSearchResponseDto.class)).collect(Collectors.toList()));
	}
	
	@GetMapping("/orderhistory")
	public ResponseEntity<List<FoodOrderResponseDto>> fetchOrderHistory(@RequestParam Long userId){
		return ResponseEntity.status(200)
				.body(userService.getOrderHistory(userId).stream().map(item->
						modelMapper.map(item, FoodOrderResponseDto.class)).collect(Collectors.toList()));
	}
	
	@PostMapping("/order")
	public ResponseEntity<FoodOrderResponseDto> orderFood(@Valid @RequestBody OrderDto orderDto) throws InsufficientBalanceException{
		return ResponseEntity.status(201)
				.body(modelMapper.map(userService.placeOrder(modelMapper.map(orderDto, FoodOrder.class)),FoodOrderResponseDto.class));
	}
	
	
}

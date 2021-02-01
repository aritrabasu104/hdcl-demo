package com.hcl.usecase.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.usecase.dto.FoodRequestDto;
import com.hcl.usecase.dto.FoodSearchResponseDto;
import com.hcl.usecase.dto.UserRequestDto;
import com.hcl.usecase.dto.UserResponseDto;
import com.hcl.usecase.dto.VendorRequestDto;
import com.hcl.usecase.dto.VendorResponseDto;
import com.hcl.usecase.model.Food;
import com.hcl.usecase.model.User;
import com.hcl.usecase.model.Vendor;
import com.hcl.usecase.service.AdminService;

@RestController
@Validated
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AdminService adminService;

	@GetMapping("/food")
	public ResponseEntity<List<FoodSearchResponseDto>> getFoods() {
		return ResponseEntity.status(200).body(adminService.getFoods().stream().map(item-> 
		modelMapper.map(item,FoodSearchResponseDto.class)).collect(Collectors.toList()));
	}

	@GetMapping("/vendor")
	public ResponseEntity<List<Vendor>> getVendors() {
		return ResponseEntity.status(200).body(adminService.getVendors());
	}

	@GetMapping("/user")
	public ResponseEntity<List<UserResponseDto>> getUsers() {
		return ResponseEntity.status(200).body(adminService.getUsers().stream()
				.map(item -> modelMapper.map(item, UserResponseDto.class)).collect(Collectors.toList()));
	}

	@PostMapping("/food")
	public ResponseEntity<Food> registerFood(@RequestBody FoodRequestDto food) {
		return ResponseEntity.status(201).body(adminService.addFood(modelMapper.map(food, Food.class)));
	}

	@PostMapping("/vendor")
	public ResponseEntity<VendorResponseDto> registerVendor(@RequestBody VendorRequestDto vendorRequestDto) {
		return ResponseEntity.status(201).body(modelMapper
				.map(adminService.addFood(modelMapper.map(vendorRequestDto, Vendor.class)), VendorResponseDto.class));
	}

	@PostMapping("/user")
	public ResponseEntity<User> registerUser(@RequestBody UserRequestDto user) {
		return ResponseEntity.status(201).body(adminService.addUser(modelMapper.map(user, User.class)));
	}
}

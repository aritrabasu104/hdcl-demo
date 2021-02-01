package com.hcl.usecase.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.usecase.model.Food;
import com.hcl.usecase.model.User;
import com.hcl.usecase.model.Vendor;
import com.hcl.usecase.repository.FoodRepository;
import com.hcl.usecase.repository.UserRepository;
import com.hcl.usecase.repository.VendorRepository;
import com.hcl.usecase.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@Override
	public Food addFood(Food food) {
		return foodRepository.save(food);
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<Food> getFoods() {
		return StreamSupport.stream(foodRepository.findAll().spliterator(),false).collect(Collectors.toList());
	}

	@Override
	public List<User> getUsers() {
		return StreamSupport.stream(userRepository.findAll().spliterator(),false).collect(Collectors.toList());
	}

	@Override
	public Vendor addFood(Vendor vendor) {
		return vendorRepository.save(vendor);
	}

	@Override
	public List<Vendor> getVendors() {
		return StreamSupport.stream(vendorRepository.findAll().spliterator(),false).collect(Collectors.toList());
	}

}

package com.hcl.usecase.service;

import java.util.List;

import com.hcl.usecase.model.Food;
import com.hcl.usecase.model.User;
import com.hcl.usecase.model.Vendor;

public interface AdminService {

	Vendor addFood(Vendor vendor);
	
	Food addFood(Food food);
	
	User addUser(User user);

	List<Food> getFoods();

	List<User> getUsers();
	
	List<Vendor> getVendors();

}

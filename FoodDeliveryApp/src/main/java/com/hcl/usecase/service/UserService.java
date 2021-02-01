package com.hcl.usecase.service;

import java.util.List;

import com.hcl.usecase.api.error.InsufficientBalanceException;
import com.hcl.usecase.model.Food;
import com.hcl.usecase.model.FoodOrder;

public interface UserService {

	FoodOrder placeOrder(FoodOrder order) throws InsufficientBalanceException;
	
	List<FoodOrder> getOrderHistory(Long userId);

	List<Food> searchFood(String name);
}

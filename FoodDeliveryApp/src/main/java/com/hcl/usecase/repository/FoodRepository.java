package com.hcl.usecase.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hcl.usecase.model.Food;

public interface FoodRepository extends CrudRepository<Food, Long> {

	List<Food> findByNameContainsIgnoringCase(String name);
}

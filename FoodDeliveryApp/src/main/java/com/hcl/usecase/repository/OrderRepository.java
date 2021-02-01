package com.hcl.usecase.repository;

import org.springframework.data.repository.CrudRepository;

import com.hcl.usecase.model.FoodOrder;

public interface OrderRepository extends CrudRepository<FoodOrder, Long> {

}

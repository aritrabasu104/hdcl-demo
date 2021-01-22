package com.hcl.usecase.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.hcl.usecase.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {

}

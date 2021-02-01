package com.hcl.usecase.repository;

import org.springframework.data.repository.CrudRepository;

import com.hcl.usecase.model.BankCustomer;

public interface CustomerRepository extends CrudRepository<BankCustomer, Long> {

}

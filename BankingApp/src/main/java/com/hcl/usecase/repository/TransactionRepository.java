package com.hcl.usecase.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.hcl.usecase.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, UUID> {

}

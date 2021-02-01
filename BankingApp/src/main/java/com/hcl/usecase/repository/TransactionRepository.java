package com.hcl.usecase.repository;

import org.springframework.data.repository.CrudRepository;

import com.hcl.usecase.model.BankTransaction;

public interface TransactionRepository extends CrudRepository<BankTransaction, Long> {

}

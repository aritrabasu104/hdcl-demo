package com.hcl.usecase.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.hcl.usecase.model.BalanceDetail;

public interface BalanceDetailRepository extends CrudRepository<BalanceDetail, UUID> {

}

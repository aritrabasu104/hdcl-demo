package com.hcl.usecase.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hcl.usecase.model.Account;
import com.hcl.usecase.model.Account.AccountStatus;

public interface AccountRepository extends CrudRepository<Account, Long> {

	List<Account> findAllByAccountStatus(AccountStatus status);
}

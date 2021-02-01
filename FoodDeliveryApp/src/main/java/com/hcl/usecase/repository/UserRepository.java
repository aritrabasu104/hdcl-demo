package com.hcl.usecase.repository;

import org.springframework.data.repository.CrudRepository;

import com.hcl.usecase.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}

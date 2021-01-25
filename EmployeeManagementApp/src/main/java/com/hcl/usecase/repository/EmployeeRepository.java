package com.hcl.usecase.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.hcl.usecase.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, UUID> {

}

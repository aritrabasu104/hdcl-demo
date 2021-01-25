package com.hcl.usecase.service;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.hcl.usecase.model.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee employee);

	List<Employee> getTop5EmployeesByDate();

	List<Employee> getEmployeesSortedByTime(@Valid LocalDate date);

	List<Employee> getEmployeesWithXp();
	
	List<Employee> getManagers();
	
	List<Employee> getNonManagers();

	List<LocalDate> getWorkingDays(List<LocalDate> holidays);
}

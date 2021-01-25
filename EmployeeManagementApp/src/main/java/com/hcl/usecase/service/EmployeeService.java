package com.hcl.usecase.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.hcl.usecase.model.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee employee);

	List<Employee> getTop5EmployeesByDate();

	List<Employee> getEmployeesSortedByTime(@Valid LocalDate date);

	List<Employee> getEmployeesWithXp();
	
	Map<Boolean, List<Employee>> getEmployeesCategorized();

	List<LocalDate> getWorkingDays(List<LocalDate> holidays);
}

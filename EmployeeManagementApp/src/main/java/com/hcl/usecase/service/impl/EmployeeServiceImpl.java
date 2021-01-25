package com.hcl.usecase.service.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.usecase.model.Employee;
import com.hcl.usecase.repository.EmployeeRepository;
import com.hcl.usecase.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	@Override
	public List<Employee> getTop5EmployeesByDate() {
		return StreamSupport.stream(employeeRepository.findAll().spliterator(),false)
		 	.sorted((emp2,emp1)->emp1.getJoiningDate().compareTo(emp2.getJoiningDate())).limit(5).collect(Collectors.toList());

	}
	
	@Override
	public List<Employee> getEmployeesSortedByTime(LocalDate date) {
		return StreamSupport.stream(employeeRepository.findAll().spliterator(),false)
				.filter(item->item.getJoiningDate().equals(date))
			 	.sorted((emp2,emp1)->emp1.getJoiningTime()
			 			.compareTo(emp2.getJoiningTime())).collect(Collectors.toList());

		
	}
	@Override
	public List<Employee> getEmployeesWithXp() {
		return StreamSupport.stream(employeeRepository.findAll().spliterator(),false)
				.filter(item->item.getJoiningDate().plusYears(7).isBefore(LocalDate.now()))
			 	.sorted((emp1,emp2)->emp1.getJoiningDate().compareTo(emp2.getJoiningDate())).collect(Collectors.toList());
	}
	@Override
	public Map<Boolean, List<Employee>> getEmployeesCategorized() {
		Map<Boolean, List<Employee>> map = StreamSupport.stream(employeeRepository.findAll().spliterator(),false)
				.collect(Collectors.partitioningBy(item->item.getIsManager()));
		return map;
	}
	
	@Override
	public List<LocalDate> getWorkingDays(List<LocalDate> holidays) {
		Predicate<LocalDate> isHoliday = item ->  holidays.contains(item);
		Predicate<LocalDate> isWeekend = item ->  item.getDayOfWeek() == DayOfWeek.SATURDAY ||
    			item.getDayOfWeek() == DayOfWeek.SUNDAY;
		return Stream.iterate(LocalDate.now(), date -> date.plusDays(1)).limit(7)
        .filter(isHoliday.or(isWeekend).negate()).collect(Collectors.toList());
	}
	
}

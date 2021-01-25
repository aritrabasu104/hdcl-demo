package com.hcl.usecase.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.usecase.dto.EmployeeDto;
import com.hcl.usecase.dto.EmployeeDto.MyLocalDate;
import com.hcl.usecase.model.Employee;
import com.hcl.usecase.service.EmployeeService;


@RestController
@Validated
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody EmployeeDto employeeDto){
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		employee.setJoiningTime(LocalTime.of(employeeDto.getJoiningTime().getHour(),
				employeeDto.getJoiningTime().getMinute(),employeeDto.getJoiningTime().getSecond()));
		return ResponseEntity.ok(employeeService.addEmployee(employee));
	}
	
	@GetMapping("/employee/top5")
	public ResponseEntity<List<Employee>> getTop5EmployeesByDate(){
		return ResponseEntity.ok(employeeService.getTop5EmployeesByDate());
	}
	@GetMapping("/employee/experienced")
	public ResponseEntity<List<Employee>> getEmployeesWithXp(){
		return ResponseEntity.ok(employeeService.getEmployeesWithXp());
	}
	
	@GetMapping("/employee/managers")
	public ResponseEntity<List<Employee>> getManagers(){
		return ResponseEntity.ok(employeeService.getManagers());
	}
	
	@GetMapping("/employee/regulars")
	public ResponseEntity<List<Employee>> getRegulars(){
		return ResponseEntity.ok(employeeService.getNonManagers());
	}
	
	@PostMapping("/day/working")
	public ResponseEntity<List<LocalDate>> getWorkingDays(@Valid @RequestBody List<MyLocalDate> holidays){
		List<LocalDate> holidaysLocal = holidays.stream().map(date->LocalDate.of(date.getYear(),
				date.getMonth(), date.getDayOfMonth())).collect(Collectors.toList());
		return ResponseEntity.ok(employeeService.getWorkingDays(holidaysLocal));
	}
	
	@PostMapping("/employee/sortedByTime")
	public ResponseEntity<List<Employee>> getEmployeesByJoiningTime(@Valid @RequestBody MyLocalDate date){
		return ResponseEntity.ok(employeeService.getEmployeesSortedByTime(LocalDate.of(date.getYear(),
				date.getMonth(), date.getDayOfMonth())));
	}
}

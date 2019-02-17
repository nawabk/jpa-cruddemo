package com.luv2code.com.cruddemo.service;

import java.util.List;

import com.luv2code.com.cruddemo.entity.Employee;

public interface EmployeeService {

public List<Employee> getAll();
	
	public Employee getById(int employeeId);
	
	public void save(Employee employee);
	
	public void delete(int employeeId);
}

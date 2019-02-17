package com.luv2code.com.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.com.cruddemo.dao.EmployeeDao;
import com.luv2code.com.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDaoJpaImpl") EmployeeDao employeeDao) {
		this.employeeDao=employeeDao;
	}
	
	@Transactional
	@Override
	public List<Employee> getAll() {
		
		return this.employeeDao.getAll();
	}

	@Transactional
	@Override
	public Employee getById(int employeeId) {
		
		return this.employeeDao.getById(employeeId);
	}

	@Transactional
	@Override
	public void save(Employee employee) {
		this.employeeDao.save(employee);
	}

	@Transactional
	@Override
	public void delete(int employeeId) {
		this.employeeDao.delete(employeeId);
	}

}

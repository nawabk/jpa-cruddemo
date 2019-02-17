package com.luv2code.com.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.com.cruddemo.entity.Employee;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoJpaImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}

	@Override
	public List<Employee> getAll() {
		Query theQuery = this.entityManager.createQuery("from Employee");
		List<Employee> employees=theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee getById(int employeeId) {
		Employee employee= this.entityManager.find(Employee.class, employeeId);
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Employee dbEmployee = 	entityManager.merge(employee);
		
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void delete(int employeeId) {
		//delete object with given primary key
		Query theQuery=entityManager.createQuery("delete from Employee where id:=employeeId");
		theQuery.setParameter("employeeId", employeeId);
		theQuery.executeUpdate();
	}

}

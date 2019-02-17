package com.luv2code.com.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.com.cruddemo.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManager entityManager;
	
	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	
	@Override
	public List<Employee> getAll() {
		Session session=entityManager.unwrap(Session.class);
		Query<Employee> theQuery=session.createQuery("from Employee",Employee.class);
		List<Employee> employees=theQuery.getResultList();
		return employees;
	}

	@Override
	
	public Employee getById(int employeeId) {
		Session session=entityManager.unwrap(Session.class);
	     Employee employee=session.get(Employee.class, employeeId);
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
		
	}

	@Override
	public void delete(int employeeId) {
		Session session=entityManager.unwrap(Session.class);
		Employee employee=session.get(Employee.class, employeeId);
		session.delete(employee);
	}

}

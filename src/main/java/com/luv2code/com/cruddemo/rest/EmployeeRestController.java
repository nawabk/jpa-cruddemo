package com.luv2code.com.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.com.cruddemo.entity.Employee;
import com.luv2code.com.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

	private EmployeeService employeeService;
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	@GetMapping
	public ResponseEntity<List<Employee>> getAll(){
		List<Employee> employees=this.employeeService.getAll();
	     return ResponseEntity.ok().body(employees);
	}
	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getById(@PathVariable("employeeId") int employeeId) {
		Employee employee=this.employeeService.getById(employeeId);
		if(employee==null) {
			throw new EmployeeNotFoundException("The Employee Does Not Exist");
		}
		return ResponseEntity.ok().body(employee);
	}
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		employee.setId(0);
		this.employeeService.save(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}
	@PutMapping("/{employeeId}")
	public void updateEmployee(@PathVariable("employeeId") int employeeId,@RequestBody Employee employee) {
		employee.setId(employeeId);
		this.employeeService.save(employee);
	}
	@DeleteMapping("/{employeeId}")
	public void deleteEmployee(@PathVariable("employeeId")int employeeId) {
		this.employeeService.delete(employeeId);
	}
}
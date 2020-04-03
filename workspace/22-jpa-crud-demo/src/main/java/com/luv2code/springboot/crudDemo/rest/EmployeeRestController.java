package com.luv2code.springboot.crudDemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.crudDemo.dao.EmployeeDao;
import com.luv2code.springboot.crudDemo.entity.Employee;
import com.luv2code.springboot.crudDemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		Employee emp = employeeService.findById(employeeId);

		if (emp == null) {
			throw new RuntimeException("Employee not found " + employeeId);
		}
		return emp;
	}

	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee theEmp) {

		// just in case they send an empid in request ....set id to 0
		theEmp.setId(0);

		employeeService.save(theEmp);

		return theEmp;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmp) {

		employeeService.save(theEmp);

		return theEmp;
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {

		Employee emp = employeeService.findById(employeeId);
		System.out.println("Found the employee: "+emp);
		if (emp == null) {
			throw new RuntimeException("Employee not found " + employeeId);
		}
		employeeService.deleteById(employeeId);
		return "deleted id: "+employeeId;
	}

}

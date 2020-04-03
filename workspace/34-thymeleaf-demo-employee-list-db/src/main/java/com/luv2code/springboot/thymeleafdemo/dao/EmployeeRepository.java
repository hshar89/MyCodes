package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
   
	//thats it.... no need to write any extra code
	
	//add a method to sort by last Name
	//Spring will look for pattern in the method name findAllBy - OrderBy - LastName
	public List<Employee> findAllByOrderByLastNameAsc();
		
}

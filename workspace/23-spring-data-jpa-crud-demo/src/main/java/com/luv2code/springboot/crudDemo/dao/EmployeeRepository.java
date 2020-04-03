package com.luv2code.springboot.crudDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.crudDemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
   
	//thats it.... no need to write any extra code
}

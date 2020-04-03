package com.luv2code.springboot.crudDemo.dao;

import java.util.List;

import com.luv2code.springboot.crudDemo.entity.Employee;

public interface EmployeeDao {
  
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
}

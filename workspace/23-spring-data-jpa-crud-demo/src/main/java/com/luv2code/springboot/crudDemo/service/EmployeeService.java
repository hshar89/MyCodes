package com.luv2code.springboot.crudDemo.service;

import java.util.List;

import com.luv2code.springboot.crudDemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int id);

	public void save(Employee employee);

	public void deleteById(int id);
}

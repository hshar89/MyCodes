package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
	@Autowired
	private EmployeeRepository erp;
	
	@Override
	public List<Employee> findAll() {
		
		return erp.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int id) {
		
		Optional<Employee> result = erp.findById(id);
		Employee emp = null;
		if(result.isPresent()) {
			emp = result.get();
		}else {
			throw new RuntimeException("Did not find employee id: "+id);
		}
		return emp;
	}

	@Override
	public void save(Employee employee) {
		
		erp.save(employee);

	}

	@Override
	public void deleteById(int id) {
		erp.deleteById(id);
	}

}

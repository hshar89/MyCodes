package com.luv2code.springboot.crudDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.luv2code.springboot.crudDemo.entity.Employee;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {
	
	private EntityManager entityManager;
	
	public EmployeeDaoJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		Query query  = entityManager.createQuery("from Employee");
		
		List<Employee> results = query.getResultList();
		return results;
	}

	@Override
	public Employee findById(int id) {
		//get employee
		Employee emp = entityManager.find(Employee.class, id);
		return emp;
	}

	@Override
	public void save(Employee employee) {
		
        Employee emp = entityManager.merge(employee);
        employee.setId(emp.getId());
	}

	@Override
	public void deleteById(int id) {
		
       //delete object with primary key
		Query query = entityManager.createQuery("delete from Employee where id=:empId");
		query.setParameter("empId", id);
		query.executeUpdate();
	}

}

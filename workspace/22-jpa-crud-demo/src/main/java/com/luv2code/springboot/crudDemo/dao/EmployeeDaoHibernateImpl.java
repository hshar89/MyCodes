package com.luv2code.springboot.crudDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.crudDemo.entity.Employee;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

	//define field for entity manager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public EmployeeDaoHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public List<Employee> findAll() {
		
		//get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		//create a query
		Query query = session.createQuery("from Employee",Employee.class);
		
		//execute the query
		List<Employee> results = query.getResultList();
		
		return results;
	}
	@Override
	public Employee findById(int id) {
		
		//get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		//get the employee
		Employee employee  = session.get(Employee.class, id);
		
		return employee;
	}
	@Override
	public void save(Employee employee) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(employee);
		
	}
	@Override
	public void deleteById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createQuery("delete from Employee where id=:empId");
		query.setParameter("empId", id);
		query.executeUpdate();
	}

}

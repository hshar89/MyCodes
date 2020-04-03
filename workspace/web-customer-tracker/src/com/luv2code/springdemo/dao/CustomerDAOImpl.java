package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//get the list of customers from the query		
		Query<Customer> theQuery = session.createQuery("from Customer order by lastname",
				Customer.class);
		
		//execute the query
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
	 
		Session session = sessionFactory.getCurrentSession();
		
		Query theQuery = session.createQuery("delete Customer where id=:customerId");
		
		theQuery.setParameter("customerId", id);
		
		theQuery.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomer(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		if(name!=null && name.trim().length()>0) {
		
			query = session.createQuery("from Customer where lower(firstname) like :name OR lower(lastname) "
				+ "like :name",Customer.class);
			query.setParameter("name", "%"+name.toLowerCase()+"%");
		
		}else {
			System.out.println("Name is null in search");
			query = session.createQuery("from Customer order by lastname",Customer.class);
			
		}
		List<Customer> customers = query.getResultList();
		return customers;
	}

}

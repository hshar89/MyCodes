package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
    
	@Autowired
	private CustomerDAO customerDAO;
	
	 
	@Override
	@Transactional
	public List<Customer> getCustomers() {	
		return customerDAO.getCustomers();
	}


	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		customerDAO.saveCustomer(theCustomer);
	}


	@Override
	@Transactional
	public Customer getCustomer(int id) {
		
		return customerDAO.getCustomer(id);
	}


	@Override
	@Transactional
	public void deleteCustomer(int id) {
		
		customerDAO.deleteCustomer(id);
		
	}


	@Override
	@Transactional
	public List<Customer> searchCustomer(String name) {
		return customerDAO.searchCustomer(name);
	}

}

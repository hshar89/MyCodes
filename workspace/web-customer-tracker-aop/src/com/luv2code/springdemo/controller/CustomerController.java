package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@GetMapping("/list")
	public String listCustomers(Model model) {
		//get the customers from the DAO
		List<Customer> customers= customerService.getCustomers();
		
		//add the customers to spring mvc model
		model.addAttribute("customers", customers);
		return "list-customers";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create a new model attribute for object data
		Customer customer = new Customer();
		
		theModel.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer theCustomer) {
		  
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")int id, Model model) {
		
		//get customer form the database
		Customer customer = customerService.getCustomer(id);
		
		//set as model attribute
		model.addAttribute("customer", customer);
		
		//send customer as attribute in the model
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		System.out.print("\nDeleting customer\n");
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName") String name, Model model) {
		List<Customer> customers = customerService.searchCustomer(name);
		
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}

}

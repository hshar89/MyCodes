package com.designpatterns.mvc.view;

import com.designpatterns.mvc.model.Employee;

public class EmployDashboadView {
	
	public void printEmployeeInfo(Employee emp ) {
		System.out.println("Name: "+emp.getFirstname()+" "+emp.getLastname());
		System.out.println("ssn "+emp.getSsnumber());
		System.out.println("Salary "+emp.getSalary());
	}
}

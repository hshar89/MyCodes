package com.designpatterns.mvc;

import com.designpatterns.mvc.controller.EmployeeController;
import com.designpatterns.mvc.model.Employee;
import com.designpatterns.mvc.view.EmployDashboadView;

public class Main {

	public static void main(String[] args) {
		
		Employee emp = retrieveEmployee();
		//Create our view to which we will write our employee information 
		EmployDashboadView dbv =new EmployDashboadView();
		EmployeeController ec = new EmployeeController(emp,dbv);
		ec.updateDashBoardView();
	}
	public static Employee retrieveEmployee() {
		Employee emp = new Employee();
		emp.setFirstname("Ram");
		emp.setLastname("prasad");
		emp.setSalary(132003.09);
		emp.setSsnumber("1234456");
		return emp;
	}

}

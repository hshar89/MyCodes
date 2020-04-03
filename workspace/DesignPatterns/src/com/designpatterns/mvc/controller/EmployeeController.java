package com.designpatterns.mvc.controller;

import com.designpatterns.mvc.model.Employee;
import com.designpatterns.mvc.view.EmployDashboadView;

public class EmployeeController {
	
	private Employee emp;
	private EmployDashboadView edv;
	public EmployeeController(Employee emp, EmployDashboadView edv) {
		this.emp = emp;
		this.edv = edv;
	}
	
	public void setEmployee(String name, String lastName) {
		emp.setFirstname(name);
		emp.setLastname(lastName);
	}
	public String getEmployeeName() {
		return emp.getFirstname()+" "+emp.getLastname();
	}
	public void setSSN(String ssn) {
		emp.setSsnumber(ssn);
	}
	public String getSSN() {
		return emp.getSsnumber();
	}
	
	public void updateDashBoardView() {
		edv.printEmployeeInfo(emp);
	}
}

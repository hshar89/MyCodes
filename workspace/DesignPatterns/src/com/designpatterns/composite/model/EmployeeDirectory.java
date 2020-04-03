package com.designpatterns.composite.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory implements Employee {
	private List<Employee> employees;
	public EmployeeDirectory() {
		this.employees = new ArrayList<>();
	}
	
	public void addEmployee(Employee e) {
		employees.add(e);
	}
	@Override
	public void showEmpoyeeDetails() {
		for(Employee e: employees) {
			e.showEmpoyeeDetails();
		}

	}

	@Override
	public String getName() {
		return null;
	}

}

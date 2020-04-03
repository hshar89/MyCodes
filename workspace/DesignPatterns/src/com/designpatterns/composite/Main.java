package com.designpatterns.composite;

import com.designpatterns.composite.model.Director;
import com.designpatterns.composite.model.Employee;
import com.designpatterns.composite.model.EmployeeDirectory;
import com.designpatterns.composite.model.Manager;

public class Main {

	public static void main(String[] args) {
		
		Employee e3 = new Director("Humble",3,"Director",null);
		Employee e1 = new Manager("testy",1,"Manager",e3);
		Employee e2 = new Manager("Angry",2,"Manager",e3);
		
		EmployeeDirectory directory = new EmployeeDirectory();
		directory.addEmployee(e1);
		directory.addEmployee(e2);
		directory.addEmployee(e3);
		directory.showEmpoyeeDetails();

	}

}

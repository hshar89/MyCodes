package com.designpatterns.mvc.model;

public class Employee {
	
	private String firstname;
	private String lastname;
	private String ssnumber;
	private double salary;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSsnumber() {
		return ssnumber;
	}
	public void setSsnumber(String ssnumber) {
		this.ssnumber = ssnumber;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}

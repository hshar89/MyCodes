package com.designpatterns.builder.model;

public class DefaultPerson implements Person{
	
	//Required Parameters
	private final String firstName;
	private final String lastName;
	
	//Optional parameter
	protected String phoneNumber;
	protected String address;
	protected int age;
	
	public DefaultPerson(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	protected DefaultPerson(Builder builder) {
		this(builder.getFirstName(),builder.getLastName());
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}

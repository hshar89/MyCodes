package com.designpatterns.builder.model;

public class User {
	
	private final String firstName;
	private final String lastName;
	private final int age;
	private final String phoneNumber;
	private final String address;
	
	public User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phoneNumber = builder.phoneNumber;
		this.address = builder.address;
	}
	
	
	public static class UserBuilder {
		private final String firstName;
		private final String lastName;
		private  int age;
		private  String phoneNumber;
		private  String address;
		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}
		public UserBuilder phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}
		public User build() {
			return new User(this);
		}
		
	}


	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", phoneNumber="
				+ phoneNumber + ", address=" + address + "]";
	}
}

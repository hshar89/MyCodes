package com.designpatterns.builder.model;

public interface Person {

	String getFirstName();

	String getLastName();

	String getPhoneNumber();

	int getAge();

	String getAddress();

	class DefaultPerson implements Person {

		// Required Parameters
		private final String firstName;
		private final String lastName;

		// Optional parameter
		protected String phoneNumber;
		protected String address;
		protected int age;

		public DefaultPerson(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		protected DefaultPerson(Builder builder) {
			this(builder.getFirstName(), builder.getLastName());
			this.phoneNumber = builder.phoneNumber;
			this.address = builder.address;
			this.age = builder.age;
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

		@Override
		public String toString() {
			return "DefaultPerson [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
					+ ", address=" + address + ", age=" + age + "]";
		}
		
	}

	// inner class builder
	public class Builder extends DefaultPerson {
		public Builder(String firstName, String lastName) {
			super(firstName, lastName);
		}

		public Builder phoneNumber(String phone) {
			super.phoneNumber = phone;
			return this;
		}

		public Builder age(int age) {
			super.age = age;
			return this;
		}

		public Builder address(String address) {
			super.address = address;
			return this;
		}

		public Person buildPerson() {
			return new DefaultPerson(this);
		}
	}
}

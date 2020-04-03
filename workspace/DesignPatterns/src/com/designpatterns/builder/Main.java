package com.designpatterns.builder;

import com.designpatterns.builder.model.Person;
import com.designpatterns.builder.model.User;

public class Main {

	public static void main(String[] args) {

		User james = new User.UserBuilder("James", "Smith").address("123 kagga").age(45).phoneNumber("123456789")
				.build();
		System.out.println(james);

		Person oldPerson = new Person.Builder("James", "ready").
				phoneNumber("007").address("123 main stree").age(56).buildPerson();
		System.out.println(oldPerson);
	}

}

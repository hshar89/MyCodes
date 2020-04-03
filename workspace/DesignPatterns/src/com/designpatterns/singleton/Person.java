package com.designpatterns.singleton;

public class Person {
	
	private static final Person instance = new Person(); 
	private Person() {}
	
	public static Person getInstance() {
		return instance;
	}
}

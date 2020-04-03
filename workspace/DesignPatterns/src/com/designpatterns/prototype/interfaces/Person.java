package com.designpatterns.prototype.interfaces;

public class Person implements Prototype{
	
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public Prototype clone() {
		return new Person(name,age);
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

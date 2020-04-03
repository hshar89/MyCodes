package com.designpatterns.prototype.interfaces;

public class Cat implements Animal{
	private String name;
	private int age;
	
	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override 
	public Animal clone() throws CloneNotSupportedException{
		return (Animal) super.clone();
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}
}

package com.designpatterns.prototype.interfaces;

public class Dolphin implements Prototype {
	
	private String name;
	private int age;
	
	
	public Dolphin(String name, int age) {
		this.name = name;
		this.age = age;
	}


	@Override
	public Prototype clone() {
		// TODO Auto-generated method stub
		return new Dolphin(name,age);
	}

}

package com.designpatterns.composite.model;

public class Director implements Employee {
	
	private String name;
	private int id;
	private String pos;
	private Employee superior;
	
	public Director(String name, int id, String pos,Employee superior) {
		this.name = name;
		this.id = id;
		this.pos = pos;
		this.superior = superior;
	}

	@Override
	public void showEmpoyeeDetails() {
		System.out.println(name+" "+id+" "+pos);
	}

	@Override
	public String getName() {
		return name;
	}

}

package com.designpatterns.composite.model;

public class Manager implements Employee {
	
	private String name;
	private int id;
	private String pos;
	private Employee superior;
	
	public Manager(String name, int id, String pos, Employee s) {
		this.name = name;
		this.id = id;
		this.pos = pos;
		this.superior = s;
	}
	@Override
	public void showEmpoyeeDetails() {
		System.out.println(name+" "+id+" "+pos+" reports to "+superior.getName());

	}
	public String getName() {
		return name;
	}
}

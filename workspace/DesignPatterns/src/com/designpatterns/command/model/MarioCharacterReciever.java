package com.designpatterns.command.model;

public class MarioCharacterReciever {
	
	private String name;
	
	public void moveUp() {
		System.out.println(name+" move up");
	}
	public void moveRight() {
		System.out.println(name+" move right");
	}
	public void moveleft() {
		System.out.println(name+" move left");
	}
	public void moveDown() {
		System.out.println(name+" move down");
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

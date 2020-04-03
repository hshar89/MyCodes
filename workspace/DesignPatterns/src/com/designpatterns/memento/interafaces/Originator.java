package com.designpatterns.memento.interafaces;
//The class/object that we want to save
public class Originator {
	//this string is to simply undertstanding 
	//in real application you would have an actual 
	//Java model class - Person.class, Character.java
	private String state;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Memento createMemento() {
		return new Memento(state);
	}
	public void setMemento(Memento mo) {
		state = mo.getState();
	}
	
}

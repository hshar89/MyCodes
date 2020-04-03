package com.designpatterns.factory.interfaces;

public abstract class Hamburger {
	public String name;
	public String sauce;
	public String buns;
	
	public void prepare() {
		System.out.println("Preparing "+name);
		System.out.println("Adding sause "+sauce);	
		System.out.println("Adding buns "+buns);
	}
	public void cook() {
		System.out.println("Cooking....");
	}
	public void box() {
		System.out.println("Boxiing.....");
	}
	public String getName() {
		return name;
	}
}

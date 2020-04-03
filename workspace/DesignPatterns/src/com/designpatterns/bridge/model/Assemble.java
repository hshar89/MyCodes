package com.designpatterns.bridge.model;

public class Assemble implements Workshop {

	@Override
	public void make() {
		System.out.println("...also");
		System.out.println("Assembled");

	}

}

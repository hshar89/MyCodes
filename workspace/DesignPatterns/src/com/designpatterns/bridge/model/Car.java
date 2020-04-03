package com.designpatterns.bridge.model;

public class Car extends Vehicle {

	public Car(Workshop workshop1, Workshop workshop2) {
		super(workshop1, workshop2);
	}

	@Override
	public void manufacture() {
		System.out.println("Car ...");
		workshop1.make();
		workshop2.make();
	}

}

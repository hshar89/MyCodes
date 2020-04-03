package com.designpatterns.factory.model;

import com.designpatterns.factory.interfaces.Hamburger;

public class JamicanCheeseBurger extends Hamburger {
	
	public JamicanCheeseBurger() {
		name = "JamaicanStyleCheeseBurger";
		sauce ="Spicy Jamaican sauce";
		buns = "Cookie dough buns";
	}
	
	@Override
	public void cook() {
		System.out.println("Cooking jamaican style...");
	}

}

package com.designpatterns.factory.interfaces;

public abstract class HamburgerStore {
	
	public Hamburger orderHamburger(String type) {
		Hamburger burger;
		burger = createHamburger(type);
		burger.prepare();
		burger.cook();
		burger.box();
		return burger;
	}
	
	public abstract Hamburger createHamburger(String type);
}

package com.designpatterns.factory.model;

import com.designpatterns.factory.interfaces.Hamburger;
import com.designpatterns.factory.interfaces.HamburgerStore;

public class JamHamburgerStore extends HamburgerStore{

	@Override
	public Hamburger createHamburger(String type) {
		if(type.equalsIgnoreCase("cheese")) {
			return new JamicanCheeseBurger();
		}else if(type.equalsIgnoreCase("Veggie")) {
			return new JamicanVeggieBurger();
		}
		return null;
	}
	
	
}

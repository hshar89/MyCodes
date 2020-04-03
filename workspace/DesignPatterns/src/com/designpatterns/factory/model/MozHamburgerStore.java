package com.designpatterns.factory.model;

import com.designpatterns.factory.interfaces.Hamburger;
import com.designpatterns.factory.interfaces.HamburgerStore;

public class MozHamburgerStore extends HamburgerStore {

	@Override
	public Hamburger createHamburger(String type) {
		if(type.equalsIgnoreCase("cheese")) {
			return new MozCheeseBurger();
		}else if(type.equalsIgnoreCase("Veggie")) {
			return new MozVeggieBurger();
		}
		return null;
	}

}

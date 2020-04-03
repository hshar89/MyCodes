package com.designpatterns.factory;

import com.designpatterns.factory.interfaces.Hamburger;
import com.designpatterns.factory.interfaces.HamburgerStore;
import com.designpatterns.factory.model.JamHamburgerStore;
import com.designpatterns.factory.model.MozHamburgerStore;

public class Main {

	public static void main(String[] args) {
		
		HamburgerStore mozibs = new MozHamburgerStore();
		HamburgerStore jamiacan = new JamHamburgerStore();
		
		Hamburger burger = mozibs.orderHamburger("cheese");
		System.out.println("Paulo ordered "+burger.getName());

		burger = jamiacan.orderHamburger("Veggie");
		System.out.println("James wanted : "+burger.getName());
	}

}

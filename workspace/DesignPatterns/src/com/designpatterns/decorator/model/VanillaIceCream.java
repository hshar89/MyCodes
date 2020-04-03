package com.designpatterns.decorator.model;

import com.designpatterns.decorator.interfaces.IceCream;
import com.designpatterns.decorator.interfaces.IceCreamDecorator;

public class VanillaIceCream extends IceCreamDecorator {

	public VanillaIceCream(IceCream iceCream) {
		super(iceCream);
	}

	@Override
	public double cost() {
		System.out.println("Adding vanilla ice-cream!");
		return 1.0+super.cost();
	}
	

}

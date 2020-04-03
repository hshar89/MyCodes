package com.designpatterns.decorator.model;

import com.designpatterns.decorator.interfaces.IceCream;
import com.designpatterns.decorator.interfaces.IceCreamDecorator;

public class ChocolateIceCream extends IceCreamDecorator{

	public ChocolateIceCream(IceCream iceCream) {
		super(iceCream);
	}

	@Override
	public double cost() {
		System.out.println("Adding Chocolate ice-cream!");
		return 1.0+super.cost();
	}
	

}

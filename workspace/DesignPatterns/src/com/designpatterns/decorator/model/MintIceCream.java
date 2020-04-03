package com.designpatterns.decorator.model;

import com.designpatterns.decorator.interfaces.IceCream;
import com.designpatterns.decorator.interfaces.IceCreamDecorator;

public class MintIceCream extends IceCreamDecorator {

	public MintIceCream(IceCream iceCream) {
		super(iceCream);
	}

	@Override
	public double cost() {
		System.out.println("Adding mint ice-cream!");
		return 1.5+super.cost();
	}
	
	

}

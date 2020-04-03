package com.designpatterns.decorator.model;

import com.designpatterns.decorator.interfaces.IceCream;

public class BasicIceCream implements IceCream{
	
	public BasicIceCream() {
		System.out.println("Creating Basic ice cream");
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 0.5;
	}
   
	
}

package com.designpatterns.visitor.model;

import com.designpatterns.visitor.interfaces.Visitable;
import com.designpatterns.visitor.interfaces.Visitor;

public class Jacket implements Visitable{
	
	private double price;

	public Jacket(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public double accept(Visitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visitor(this);
	}
}

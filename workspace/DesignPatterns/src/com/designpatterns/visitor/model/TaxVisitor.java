package com.designpatterns.visitor.model;

import java.text.DecimalFormat;

import com.designpatterns.visitor.interfaces.Visitor;

public class TaxVisitor implements Visitor{
	
	DecimalFormat df = new DecimalFormat("#.##");
	public TaxVisitor() {
		
	}
	@Override
	public double visitor(Shirt shirtItem) {
		System.out.println("Shirt final price with tax");
		return Double.parseDouble(df.format(shirtItem.getPrice()+0.18*shirtItem.getPrice()));
	}

	@Override
	public double visitor(Tshirt tshirtItem) {
		System.out.println("Tshirt final price with tax");
		return Double.parseDouble(df.format(tshirtItem.getPrice()+0.2*tshirtItem.getPrice()));
	}

	@Override
	public double visitor(Jacket jacketItem) {
		System.out.println("Jacket item price with tax");
		return Double.parseDouble(df.format(jacketItem.getPrice()+0.10*jacketItem.getPrice()));
	}

}

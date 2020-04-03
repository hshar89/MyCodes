package com.designpatterns.chainofresponsibility.interfaces;

public class DirectorPurchasePower extends PurchasePower {

	@Override
	protected double getAllowable() {
		return BASE*20;
	}

	@Override
	protected String getRole() {
		// TODO Auto-generated method stub
		return "Director";
	}

}

package com.designpatterns.chainofresponsibility.interfaces;

public class ManagerPurchasePower extends PurchasePower {

	@Override
	protected double getAllowable() {
		return BASE*10;
	}

	@Override
	protected String getRole() {
		// TODO Auto-generated method stub
		return "Manager";
	}

}

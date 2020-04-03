package com.designpatterns.chainofresponsibility.interfaces;

public class CEOPurchasePower extends PurchasePower {
	
	
	@Override
	protected double getAllowable() {
		
		return BASE*100;
	}

	@Override
	protected String getRole() {
		// TODO Auto-generated method stub
		return "CEO";
	}

}

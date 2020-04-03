package com.designpatterns.strategy.controller;

public class CreditCardAlgorithm implements Payment{
    private String name;
    private String cardNumber;
    public CreditCardAlgorithm(String name, String cardNumber) {
    	this.name = name;
    	this.cardNumber = cardNumber;
    }
	@Override
	public void pay(int amount) {
		// TODO Auto-generated method stub
      	System.out.println(amount+" paid with card");	
	}
  
}

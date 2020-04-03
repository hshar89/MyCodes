package com.designpatterns.state.model;

public class SoldOutState implements State {
	
    SodaVendingMachine svm;
	
	public SoldOutState(SodaVendingMachine svm) {
		this.svm = svm;
	}
	@Override
	public void insertMoney() {
		System.out.println("Machine sold out");

	}

	@Override
	public void select() {
		System.out.println("No soda available");

	}

	@Override
	public void ejectMoney() {
		System.out.println("insert money before ejecting");

	}

	@Override
	public void dispense() {
		System.out.println("Sold out");

	}
	@Override
	public String toString() {
		return "Sold out";
	}

}

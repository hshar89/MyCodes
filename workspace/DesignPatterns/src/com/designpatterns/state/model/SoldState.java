package com.designpatterns.state.model;

public class SoldState implements State {
	
	SodaVendingMachine svm;
	
	public SoldState(SodaVendingMachine svm) {
		this.svm = svm;
	}

	@Override
	public void insertMoney() {
		System.out.println("Give a second soda coming right up");
	}

	@Override
	public void select() {
		System.out.println("Nope... you cannot eject money if you already have the soda");
	}

	@Override
	public void ejectMoney() {
		System.out.println("Sorry.. soda is coming...");

	}

	@Override
	public void dispense() {
		System.out.println("Trying to get second soda for free");
		if(svm.getCount()>0) {
			svm.setState(svm.getNoMoneyState());
		}else {
			System.out.println("Sorry out of soda's");
			svm.setState(svm.getSoldOutState());
		}
	}
	@Override
	public String toString() {
		return "Dispensing soda";
	}

}

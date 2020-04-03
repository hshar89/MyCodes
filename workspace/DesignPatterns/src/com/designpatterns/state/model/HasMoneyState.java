package com.designpatterns.state.model;

public class HasMoneyState implements State {
	
	SodaVendingMachine svm;

	public HasMoneyState(SodaVendingMachine svm) {
			this.svm = svm;
		}

	@Override
	public void insertMoney() {
		System.out.println("No Need to insert another dollar bill");
	}

	@Override
	public void select() {
		System.out.println("Select item....");
		svm.setState(svm.getSoldState());
	}

	@Override
	public void ejectMoney() {
		System.out.println("returning your dollar ");
		svm.setState(svm.getNoMoneyState());
	}

	@Override
	public void dispense() {
		System.out.println("No soda dispensed...");

	}
	@Override
	public String toString() {
		return "Waiting for a new selection";
	}

}

package com.designpatterns.state.model;

public class NoMoneyState implements State {

	SodaVendingMachine svm;

	public NoMoneyState(SodaVendingMachine svm) {
			this.svm = svm;
		}

	@Override
	public void insertMoney() {
		System.out.println("You inserted a dollar");
		svm.setState(svm.getHasMoneyState());

	}

	@Override
	public void select() {
		System.out.println("You selected soda, But no money added!");

	}

	@Override
	public void ejectMoney() {
		System.out.println("You haven't inserted a dollar");

	}

	@Override
	public void dispense() {
		System.out.println("you need to add money first");
	}
	@Override
	public String toString() {
		return "Waiting for a dollar...";
	}

}

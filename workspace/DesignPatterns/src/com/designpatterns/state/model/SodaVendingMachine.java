package com.designpatterns.state.model;

public class SodaVendingMachine {
	
	private State soldState;
	private State soldOutState;
	private State noMoneyState;
	private State hasMoneyState;
	
	State state = soldOutState;
	int count = 0;
	
	public SodaVendingMachine(int count) {
		soldOutState = new SoldOutState(this);
		soldState = new SoldState(this);
		noMoneyState = new NoMoneyState(this);
		hasMoneyState = new HasMoneyState(this);
		this.count = count;
		
		if(count>0) {
			state = noMoneyState;//if there are more than 0 sodas then state to nomoneystat
			
		}
	}
	public void insertMoney() {
		state.insertMoney();
		
	}
	public void ejectMoney() {
		state.ejectMoney();
	}
	public void selectSoda() {
		state.select();
		count--;
	}
	public void dispense() {
		state.dispense();
	}
	public State getSoldState() {
		return soldState;
	}
	public void setSoldState(State soldState) {
		this.soldState = soldState;
	}
	public State getSoldOutState() {
		return soldOutState;
	}
	public void setSoldOutState(State soldOutState) {
		this.soldOutState = soldOutState;
	}
	public State getNoMoneyState() {
		return noMoneyState;
	}
	public void setNoMoneyState(State noMoneyState) {
		this.noMoneyState = noMoneyState;
	}
	public State getHasMoneyState() {
		return hasMoneyState;
	}
	public void setHasMoneyState(State hasMoneyState) {
		this.hasMoneyState = hasMoneyState;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("The SodaVending Machine Co");
		result.append("\nInventory "+count+" soda");
		if(count!=1) {
			result.append("s");
		}
		result.append("\n");
		result.append(" Soda Vending Machine is :"+state+"\n");
		return result.toString();
	}
}


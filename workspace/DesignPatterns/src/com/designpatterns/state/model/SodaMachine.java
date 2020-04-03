package com.designpatterns.state.model;

public class SodaMachine {
	//States
	final static int SOLD_OUT=0;
	final static int NO_MONEY=1;
	final static int HAS_MONEY=2;
	final static int SOLD=3;
	
	int state = SOLD_OUT;
	public int count = 0;
	public SodaMachine(int count) {
		this.count = count;
		if(count>0) {
			//has soda but no one has bought any
			state = NO_MONEY;
		}
	}
	
	public void insertMoney() {
		if(state == HAS_MONEY) {
			System.out.println("You can't insert another dollar bill");
		}else if(state == NO_MONEY) {
			state = HAS_MONEY;
			System.out.println("You inserted a dollar");
		}else if(state == SOLD_OUT) {
			System.out.println("Machine is sold out. You can't buy");
		}else if(state == SOLD) {
			System.out.println("Please wait! we are already giving you a soda");
		}
	}
	public void ejectMoney() {
		if(state ==HAS_MONEY) {
			System.out.println("Returning dollar bill");
			state = NO_MONEY;
		}else if(state == NO_MONEY) {
			System.out.println("You haven't inserted dollar bill");
		}else if(state == SOLD) {
			System.out.println("Already selected soda");
		}else if(state == SOLD_OUT) {
			System.out.println("Machine is sold out");
		}
	}
	public void selectSoda() {
		if(state ==SOLD) {
			System.out.println("Dispensing your soda");
		}else if(state == NO_MONEY) {
			System.out.println("You selected soda but did not enter money");
		}else if(state ==SOLD_OUT) {
			System.out.println("You are out of luck no soda");
		}else if(state ==HAS_MONEY) {
			System.out.println("You selected a soda");
			state = SOLD;
			dispense();
		}
	}
	public void dispense() {
		if(state ==SOLD) {
			System.out.println("Dispensing your soda ");
			count--;
			if(count==0) {
				System.out.println("Sorry out of sodas");
				state = SOLD_OUT;
			}else {
				state = NO_MONEY;
			}
		}else if(state ==NO_MONEY) {
			System.out.println("Please insert a dollar bill first");
		}else if(state ==SOLD_OUT) {
			System.out.println("Machine sold out");
		}else if(state ==HAS_MONEY) {
			System.out.println("No soda dispensed");
		}
	}
	
}

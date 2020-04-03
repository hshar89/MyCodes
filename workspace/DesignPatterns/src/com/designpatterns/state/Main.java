package com.designpatterns.state;

import com.designpatterns.state.model.SodaMachine;
import com.designpatterns.state.model.SodaVendingMachine;

public class Main {

	public static void main(String[] args) {
		
		SodaVendingMachine svm = new SodaVendingMachine(10);
		System.out.println(svm);
		svm.insertMoney();
		svm.selectSoda();
		svm.dispense();
		System.out.println(svm);
		svm.insertMoney();
		svm.selectSoda();
		svm.insertMoney();
		svm.selectSoda();
		System.out.println(svm);
	}
	public void testStateObviousSolution() {
		SodaMachine sm = new SodaMachine(10);
		sm.insertMoney();
		sm.selectSoda();
		
		System.out.println("Inventory : "+sm.count);
		//sm.dispense();
		
		sm.insertMoney();
		sm.ejectMoney();
		sm.selectSoda();
		
		System.out.println("Inventory "+sm.count);
		sm.insertMoney();
		sm.selectSoda();
		sm.insertMoney();
		sm.selectSoda();
		sm.ejectMoney();
		
		System.out.println("Inventory : "+sm.count);
	}

}

package com.designpatterns.memento;

import com.designpatterns.memento.interafaces.CareTaker;
import com.designpatterns.memento.interafaces.Memento;
import com.designpatterns.memento.interafaces.Originator;

public class Main {

	public static void main(String[] args) {
		Originator ori = new Originator();
		ori.setState("Monster");
		Memento mo= ori.createMemento();
		
		CareTaker care = new CareTaker();
		care.addMomento(mo);
		
		ori.setState("Monster 2");
		ori.setState("Monster 3");
		
		mo = ori.createMemento();
		care.addMomento(mo);
		ori.setState("Monster 4");
		
		System.out.println("originator current state :"+ori.getState());
		System.out.println("Restoring to previous state ");
		mo = care.getMemento(1);
		ori.setMemento(mo);
		System.out.println("Originator get current state "+ori.getState());
		mo = care.getMemento(0);
		ori.setMemento(mo);
		System.out.println("Originator current state "+ori.getState());
	}

}

package com.designpatterns.memento.interafaces;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
	
	private List stateList = new ArrayList();
	
	public void addMomento(Memento mo) {
		stateList.add(mo);
	}
	public Memento getMemento(int index) {
		return (Memento)stateList.get(index);
	}
}

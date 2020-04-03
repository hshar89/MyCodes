package com.designpatterns.mediator.model;

import java.util.ArrayList;
import java.util.List;

import com.designpatterns.mediator.interfaces.ATCMediator;
import com.designpatterns.mediator.interfaces.Aircraft;

public class ATCMediatorImpl implements ATCMediator{
	
	private List<Aircraft> aircrafts;
	public ATCMediatorImpl() {
		aircrafts = new ArrayList<>();
	}
	@Override
	public void sendMessage(String msg, Aircraft craft) {
		for(Aircraft a: aircrafts) {
			//message should not be recieved by sending aircraft
			if(a!=craft) {
				a.recieve(msg);
			}
		}
		
	}
	@Override
	public void addAircraft(Aircraft craft) {
		aircrafts.add(craft);
	}

}

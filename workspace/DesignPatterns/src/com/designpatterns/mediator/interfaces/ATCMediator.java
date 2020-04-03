package com.designpatterns.mediator.interfaces;

public interface ATCMediator {
	
	public void sendMessage(String msg,Aircraft craft);
	void addAircraft(Aircraft craft);
}

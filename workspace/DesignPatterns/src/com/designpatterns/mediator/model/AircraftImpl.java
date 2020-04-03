package com.designpatterns.mediator.model;

import com.designpatterns.mediator.interfaces.ATCMediator;
import com.designpatterns.mediator.interfaces.Aircraft;

public class AircraftImpl extends Aircraft {

	public AircraftImpl(ATCMediator mediator, String name) {
		super(mediator, name);
	}

	@Override
	public void send(String msg) {
		System.out.println(this.name +" Sending message "+msg);
		mediator.sendMessage(msg, this);
	}

	@Override
	public void recieve(String msg) {
		System.out.println(this.name +" recieved the messsage "+msg);

	}
	
}

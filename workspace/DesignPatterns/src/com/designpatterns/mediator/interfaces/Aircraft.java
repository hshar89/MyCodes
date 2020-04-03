package com.designpatterns.mediator.interfaces;

public abstract class Aircraft {
	protected ATCMediator mediator;
	protected String name;
	public Aircraft(ATCMediator mediator, String name) {
		this.mediator = mediator;
		this.name= name;
	}
	public abstract void send(String msg);
	public abstract void recieve(String msg);
}

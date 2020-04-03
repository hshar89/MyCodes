package com.designpatterns.mediator;

import com.designpatterns.mediator.interfaces.ATCMediator;
import com.designpatterns.mediator.interfaces.Aircraft;
import com.designpatterns.mediator.model.ATCMediatorImpl;
import com.designpatterns.mediator.model.AircraftImpl;

public class Main {

	public static void main(String[] args) {
		ATCMediator mediator = new ATCMediatorImpl();
		Aircraft c1 = new AircraftImpl(mediator,"747B");
		Aircraft c2 = new AircraftImpl(mediator,"737B");
		Aircraft c3 = new AircraftImpl(mediator,"A380");
		mediator.addAircraft(c1);
		mediator.addAircraft(c2);
		mediator.addAircraft(c3);
		c1.send("Hello we are crashing ");
	}

}

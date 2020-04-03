package com.designpatterns.adapter.model;

import com.designpatterns.adapter.interfaces.SocketAdapter;

public class SocketAdapterImplementation extends Socket implements SocketAdapter{

	@Override
	public Volts get120Volts() {
		return getVolt();
	}

	@Override
	public Volts get12Volts() {
		Volts v = getVolt();
		return convertVolt(v,10);
	}

	@Override
	public Volts get3Volts() {
		Volts v = getVolt();
		return convertVolt(v,40);
	}

	@Override
	public Volts get1Volt() {
		Volts v = getVolt();
		return convertVolt(v,120);
	}
	private Volts convertVolt(Volts v, int i) {
		return new Volts(v.getVolts()/i);
	}

}

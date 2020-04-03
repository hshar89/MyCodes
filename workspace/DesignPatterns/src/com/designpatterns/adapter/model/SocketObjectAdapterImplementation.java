package com.designpatterns.adapter.model;

import com.designpatterns.adapter.interfaces.SocketAdapter;

public class SocketObjectAdapterImplementation implements SocketAdapter{
	
	private Socket socket = new Socket();
	@Override
	public Volts get120Volts() {
		return socket.getVolt();
	}

	@Override
	public Volts get12Volts() {
		// TODO Auto-generated method stub
		return convertVolt(socket.getVolt(),10);
	}

	@Override
	public Volts get3Volts() {
		return convertVolt(socket.getVolt(),40);
	}

	@Override
	public Volts get1Volt() {
		return convertVolt(socket.getVolt(),120);
	}
	
	private Volts convertVolt(Volts v, int i) {
		return new Volts(v.getVolts()/i);
	}

}

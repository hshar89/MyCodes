package com.designpatterns.adapter.model;

public class Socket {
	
	public Volts getVolt() {
		return new Volts(120);
	}
}

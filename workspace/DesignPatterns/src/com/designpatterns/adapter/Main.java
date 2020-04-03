package com.designpatterns.adapter;

import com.designpatterns.adapter.interfaces.SocketAdapter;
import com.designpatterns.adapter.model.SocketAdapterImplementation;
import com.designpatterns.adapter.model.SocketObjectAdapterImplementation;
import com.designpatterns.adapter.model.Volts;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testingObjectAdapter();
		testingClassAdapter();
	}
	private static void testingClassAdapter() {
		SocketAdapter socketAdapter = new SocketAdapterImplementation();
		Volts v3 = getVolt(socketAdapter,3);
		Volts v12 = getVolt(socketAdapter,12);
		Volts v120 = getVolt(socketAdapter,120);
		Volts v1 = getVolt(socketAdapter,1);
		
		System.out.println("V3 volts is using Class adapter "+v3.getVolts());
		System.out.println("V12 volts is using Class adapter "+v12.getVolts());
		System.out.println("V120 volts is using Class adapter "+v120.getVolts());
		
	}
	private static void testingObjectAdapter() {
		SocketAdapter socketAdapter = new SocketObjectAdapterImplementation();
		Volts v3 = getVolt(socketAdapter,3);
		Volts v12 = getVolt(socketAdapter,12);
		Volts v120 = getVolt(socketAdapter,120);
		Volts v1 = getVolt(socketAdapter,1);
		
		System.out.println("V3 volts is using Object adapter "+v3.getVolts());
		System.out.println("V12 volts is using Object adapter "+v12.getVolts());
		System.out.println("V120 volts is using Object adapter "+v120.getVolts());
		
	}
	private static Volts getVolt(SocketAdapter socketAdapter, int i) {
		switch(i) {
		case 3:
			return socketAdapter.get3Volts();
		case 12: 
			return socketAdapter.get12Volts();
		case 1:
			return socketAdapter.get1Volt();
		case 120:
			return socketAdapter.get120Volts();
		}
		return socketAdapter.get120Volts();
	}

}

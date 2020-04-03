package com.designpatterns.adapter.interfaces;

import com.designpatterns.adapter.model.Volts;

public interface SocketAdapter {
	
	 Volts get120Volts();
	 Volts get12Volts();
	 Volts get3Volts();
	 Volts get1Volt();
}

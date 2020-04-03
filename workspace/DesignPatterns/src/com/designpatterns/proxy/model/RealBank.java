package com.designpatterns.proxy.model;

import com.designpatterns.proxy.interfaces.Bank;

public class RealBank implements Bank {

	@Override
	public void withdrawMoney(String clientName) throws Exception {
		System.out.println("Withdrawing from atm...");

	}

}

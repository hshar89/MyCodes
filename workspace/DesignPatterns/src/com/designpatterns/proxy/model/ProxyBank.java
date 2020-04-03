package com.designpatterns.proxy.model;

import java.util.ArrayList;
import java.util.List;

import com.designpatterns.proxy.interfaces.Bank;

public class ProxyBank implements Bank {
	
	private RealBank real = new RealBank();
	
	private static List<String> bannedClients;
	static {
		bannedClients = new ArrayList<>();
		bannedClients.add("bank1");
		bannedClients.add("bank2");
		bannedClients.add("bank3");
	}
	@Override
	public void withdrawMoney(String clientName) throws Exception {
			if(bannedClients.contains(clientName)) {
				throw new Exception("Access Denied! You are not authorized");
			}
			real.withdrawMoney(clientName);
	}

}

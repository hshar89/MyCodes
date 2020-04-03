package com.designpatterns.proxy;

import com.designpatterns.proxy.interfaces.Bank;
import com.designpatterns.proxy.model.ProxyBank;

public class Main {

	public static void main(String[] args) {
		Bank bank = new ProxyBank();
		try {
			bank.withdrawMoney("icici");
			bank.withdrawMoney("bank1");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

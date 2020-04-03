package com.designpatterns.chainofresponsibility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.designpatterns.chainofresponsibility.interfaces.CEOPurchasePower;
import com.designpatterns.chainofresponsibility.interfaces.DirectorPurchasePower;
import com.designpatterns.chainofresponsibility.interfaces.ManagerPurchasePower;
import com.designpatterns.chainofresponsibility.interfaces.PurchasePower;
import com.designpatterns.chainofresponsibility.interfaces.PurchaseRequest;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		PurchasePower ceo = new CEOPurchasePower();
		PurchasePower director = new DirectorPurchasePower();
		PurchasePower manager = new ManagerPurchasePower();
		
		ceo.setSuccessor(null);
		director.setSuccessor(ceo);
		manager.setSuccessor(director);
		while(true) {
		System.out.println("Enter the amount to check who should approve");
		System.out.println(">>");
		double d = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
		manager.processRequest(new PurchaseRequest(d,"By Staff"));
		
		}
		
	}
}

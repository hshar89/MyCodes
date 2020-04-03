package com.designpatterns.iterator.model;

import com.designpatterns.iterator.interfaces.GeekyIterator;

public class Seller {
	
	private GeekyStoreCatalouge gsc;

	public Seller(GeekyStoreCatalouge gsc) {
		this.gsc = gsc;
	}
	
	public void printCatalouge() {
		GeekyIterator it = gsc.createIterator();
		System.out.println("Printing catalouge ...");
		printCatalouge(it);
	}
	private void printCatalouge(GeekyIterator it) {
		while(it.hasNext()) {
			Product pro = (Product)it.next();
			System.out.print(pro.getName()+" ");
			System.out.print(pro.getDescription()+" ");
			System.out.println(pro.getPrice());
		}
	}
}

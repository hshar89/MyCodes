package com.designpatterns.iterator.model;

import com.designpatterns.iterator.interfaces.Catalouge;
import com.designpatterns.iterator.interfaces.DevIterator;
import com.designpatterns.iterator.interfaces.Iterator;

public class DevStoreCatalouge implements Catalouge{
	
	private static final int MAX_ITEMS = 4;
	
	private int numberOfProducts = 0;
	
	Product[] catalouge;
	public DevStoreCatalouge() {
		catalouge = new Product[MAX_ITEMS];
		addItem("C++ is not dead","T-shirt",23.0);
		addItem("Java Rocks","Silky mouse pad",34.45);
		addItem("Java design pattern","Book - A must",139.99);
		addItem("Web development cookbook","The best webdev book",89.2);
	}
	private void addItem(String name, String description, double price) {
		Product product = new Product(name,description,price);
		if(numberOfProducts>=MAX_ITEMS) {
			System.out.println("Catalouge is full- can't add products");
		}
		else {
			catalouge[numberOfProducts++] = product;		
		}
	}
	public Product[] getCatalouge() {
		return catalouge;
	}
	public Iterator createIterator() {
		return new DevIterator(catalouge);
	}

}

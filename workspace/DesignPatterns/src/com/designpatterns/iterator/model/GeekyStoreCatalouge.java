package com.designpatterns.iterator.model;

import java.util.ArrayList;

import com.designpatterns.iterator.interfaces.Catalouge;
import com.designpatterns.iterator.interfaces.GeekyIterator;

public class GeekyStoreCatalouge implements Catalouge{
	
	private ArrayList<Product> catalouge;
	
	public GeekyStoreCatalouge() {
		catalouge = new ArrayList<>();
		addItem("C++ is not dead","T-shirt",23.0);
		addItem("Java Rocks","Silky mouse pad",34.45);
		addItem("Java design pattern","Book - A must",139.99);
		addItem("Web development cookbook","The best webdev book",89.2);
	}
	private void addItem(String name, String description, double price) {
		Product product = new Product(name,description,price);
		catalouge.add(product);
	}
	public ArrayList<Product> getCatalouge() {
		return catalouge;
	}
	public GeekyIterator createIterator() {
		return new GeekyIterator(catalouge);
	}
}

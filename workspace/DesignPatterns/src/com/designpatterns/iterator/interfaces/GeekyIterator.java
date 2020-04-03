package com.designpatterns.iterator.interfaces;

import java.util.ArrayList;

import com.designpatterns.iterator.model.Product;

public class GeekyIterator implements Iterator {
	
	private ArrayList<Product> catalouge;
	int position = 0;
	
	@Override
	public boolean hasNext() {
		if(position>=catalouge.size() || catalouge.get(position)==null) {
			return false;
		}
		return true;
	}

	public GeekyIterator(ArrayList<Product> catalouge) {
		this.catalouge = catalouge;
	}

	@Override
	public Object next() {
		Product pro = catalouge.get(position++);
		return pro;
	}

}

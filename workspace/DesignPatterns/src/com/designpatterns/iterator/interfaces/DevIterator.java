package com.designpatterns.iterator.interfaces;

import com.designpatterns.iterator.model.Product;

public class DevIterator implements Iterator{
	
	private Product[] catalouge;
	int position = 0;
	public DevIterator(Product[] catalouge) {
		this.catalouge = catalouge;
	}

	@Override
	public boolean hasNext() {
		if(position>=catalouge.length || catalouge[position]==null) {
			return false;
		}
		return true;
	}

	@Override
	public Object next() {
		return catalouge[position++];
	}

}

package com.designpatterns.strategy.model;

public class Product {
	private String utcCode;
	private int price;
    
    public Product(String utcCode, int price) {
    	this.price = price;
    	this.utcCode = utcCode;
    }
	public String getUtcCode() {
		return utcCode;
	}

	public void setUtcCode(String utcCode) {
		this.utcCode = utcCode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}

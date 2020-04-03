package com.designpatterns.facade.model;

public class Memory {
	
	public void load(long position, byte[] data) {
		System.out.println("added item to memory..."+position);
	}
}

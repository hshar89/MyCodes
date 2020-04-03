package com.designpatterns.bridge.model;

public class Make implements Workshop {

	@Override
	public void make() {
		System.out.println("Making...");

	}

}

package com.designpatterns.singleton;

public class MyClass {
	
	public String name;
	private volatile static MyClass instance;
	private MyClass() {}
	public static MyClass getInstance() {
	if(instance == null) {
		synchronized(MyClass.class) {
			if(instance ==null) {
		 instance = new MyClass();
			}
		}
	}
		return instance;
	}
}

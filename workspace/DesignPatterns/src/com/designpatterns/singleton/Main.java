package com.designpatterns.singleton;

public class Main {

	public static void main(String[] args) {
		Person person = Person.getInstance();
		MyClass instance = MyClass.getInstance();
		instance.name = "Jeetega Bhai Jeetga";
		MyClass instance2 = MyClass.getInstance();
		System.out.println(instance);
		System.out.println(instance2);
		System.out.println("Object person: "+person);

	}

}

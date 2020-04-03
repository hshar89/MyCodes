package com.designpatterns.prototype;

import com.designpatterns.prototype.interfaces.Cat;
import com.designpatterns.prototype.interfaces.Person;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		Person p1 = new Person("bonni",21);
		System.out.println("Person 1: "+p1);
		Person p2 = (Person)p1.clone();
		System.out.println("Person 2 "+p2);
		
		Cat c1 = new Cat("meow",2);
		System.out.println(c1);
		Cat c2 = (Cat) c1.clone();
		System.out.println(c2);
	}

}

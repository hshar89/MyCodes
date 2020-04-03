package com.designpatterns.visitor;

import com.designpatterns.visitor.interfaces.Visitor;
import com.designpatterns.visitor.model.Jacket;
import com.designpatterns.visitor.model.Shirt;
import com.designpatterns.visitor.model.TaxVisitor;
import com.designpatterns.visitor.model.Tshirt;

public class Main {

	public static void main(String[] args) {
		
		Visitor visit = new TaxVisitor();
		Jacket jacket = new Jacket(45.99);
		Tshirt tshit = new Tshirt(34.90);
		Shirt shirt = new Shirt(23.45);
		
		System.out.println(jacket.accept(visit));
		System.out.println(tshit.accept(visit));
		
	}

}

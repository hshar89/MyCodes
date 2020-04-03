package com.designpatterns.visitor.interfaces;

public interface Visitable {
	
	public double accept(Visitor visitor);
	
}

package com.designpatterns.visitor.interfaces;

import com.designpatterns.visitor.model.Jacket;
import com.designpatterns.visitor.model.Shirt;
import com.designpatterns.visitor.model.Tshirt;

public interface Visitor {
	public double visitor(Shirt shirtItem);
	public double visitor(Tshirt tshirtItem);
	public double visitor(Jacket jacketItem);
}

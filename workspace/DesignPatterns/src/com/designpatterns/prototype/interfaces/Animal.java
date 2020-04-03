package com.designpatterns.prototype.interfaces;

public interface Animal extends Cloneable{
	Animal clone()throws CloneNotSupportedException;
}

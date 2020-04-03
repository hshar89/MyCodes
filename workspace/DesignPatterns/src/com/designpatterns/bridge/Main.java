package com.designpatterns.bridge;

import com.designpatterns.bridge.model.Assemble;
import com.designpatterns.bridge.model.Bike;
import com.designpatterns.bridge.model.Car;
import com.designpatterns.bridge.model.Make;
import com.designpatterns.bridge.model.Vehicle;

public class Main {

	public static void main(String[] args) {
		Vehicle bmw = new Car(new Make(),new Assemble());
		bmw.manufacture();
		Vehicle duke = new Bike(new Make(),new Assemble());
		duke.manufacture();
	}

}

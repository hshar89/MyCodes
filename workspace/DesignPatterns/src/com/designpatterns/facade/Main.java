package com.designpatterns.facade;

import com.designpatterns.facade.model.CPU;
import com.designpatterns.facade.model.ComputerFacade;
import com.designpatterns.facade.model.HardDrive;
import com.designpatterns.facade.model.Memory;

public class Main {

	public static void main(String[] args) {
		CPU cpu = new CPU();
		Memory memory = new Memory();
		HardDrive hd =new HardDrive();
		ComputerFacade cf = new ComputerFacade(cpu,memory,hd);
		cf.start();

	}

}

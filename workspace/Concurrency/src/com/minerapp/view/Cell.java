package com.minerapp.view;

import java.awt.GridLayout;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JPanel;

import com.minerapp.constants.State;

public class Cell extends JPanel{
   
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Lock lock;
	private State state;
	private boolean hasbomb;
	
	public Cell(int id) {
		initVariables(id);
		setLayout(new GridLayout());
	}

	private void initVariables(int id2) {
		
		this.id = id;
		this.lock = new ReentrantLock();
		this.state = State.EMPTY;
		this.hasbomb = false;
		
	}
	
	public void lock() {
		try {
			lock.tryLock(10,TimeUnit.HOURS);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void unlock() {
		lock.unlock();
	}
	
	@Override
	public String toString() {
		return ""+this.id+"-"+state.toString()+"-"+hasbomb;
	}
}

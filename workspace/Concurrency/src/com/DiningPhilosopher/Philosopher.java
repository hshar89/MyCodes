package com.DiningPhilosopher;

import java.util.Random;

public class Philosopher implements Runnable{

	 private int id;
	 private Chopstick left;
	 private Chopstick right;
	 private Random random;
	 private int eatingCounter;
	 private volatile boolean isFull = false;
	 
	 public Philosopher(int id,Chopstick left, Chopstick right) {
		 this.id = id;
		 this.left = left;
		 this.right = right;
		 random = new Random();
	 }

	@Override
	public void run() {
		try {
		while(!isFull) {
			
			think();
			if(left.pickup(this, State.LEFT)) {
				if(right.pickup(this, State.RIGHT)) {
					eat();
					right.putDown(this, State.RIGHT);
				}
				left.putDown(this, State.RIGHT);
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}
    private void think() throws InterruptedException{
    	System.out.println(this+" is Thinking...");
    	Thread.sleep(random.nextInt(1000));
    }
    private void eat() throws InterruptedException{
    	System.out.println(this+" is eating...");
    	this.eatingCounter++;
    	Thread.sleep(random.nextInt(1000));
    }
    public int getCounter() {
    	return this.eatingCounter;
    }
	@Override
	public String toString() {
		return "Philosopher [id=" + id + "]";
	}
}

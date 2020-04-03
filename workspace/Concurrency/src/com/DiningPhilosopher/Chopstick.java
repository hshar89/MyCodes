package com.DiningPhilosopher;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    
	private int id;
    private Lock lock;
    
    public Chopstick(int id) {
    	this.id = id;
    	this.lock = new ReentrantLock();
    }
    
    public boolean pickup(Philosopher philosopher, State state) throws InterruptedException{
    	//With reentrant lock we can wait for a lock to free up for particular time
    	if(lock.tryLock(10,TimeUnit.MILLISECONDS)) {
    		System.out.println(philosopher+" picked up "+state.toString()+" "+this);
    		return true;
    	}
    	return false;
    }
    
    public void putDown(Philosopher philosopher, State state) {
    	lock.unlock();
    	System.out.println(philosopher+" put down "+this);
    }
	@Override
	public String toString() {
		return "Chopstick [id=" + id + "]";
	}
}

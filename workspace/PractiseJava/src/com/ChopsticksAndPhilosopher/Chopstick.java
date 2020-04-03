package com.ChopsticksAndPhilosopher;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
  int id;
  Lock lock;
  public Chopstick(int id) {
	  this.id = id;
	  this.lock = new ReentrantLock();
  }
  public boolean pickup(Philosopher p, State state) throws InterruptedException {
	  if(lock.tryLock(10,TimeUnit.MILLISECONDS)) {
		  System.out.println(p+" picked up "+state.toString()+" "+this);
		  return true;
	  }
	  return false;
  }
  public void unlock() {
	  lock.unlock();
  }
  @Override
	public String toString() {
		return "Chopstick [id=" + id + "]";
	}
}

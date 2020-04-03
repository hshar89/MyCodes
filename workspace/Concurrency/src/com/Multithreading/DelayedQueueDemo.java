package com.Multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class DelayedWorker implements Delayed{
    private long duration;
    private String message;
    public DelayedWorker(long duration, String message) {
    	this.duration = System.currentTimeMillis()+duration;
    	this.message = message;
    }
	@Override
	public int compareTo(Delayed o) {
		if(this.duration<((DelayedWorker)o).getDuration()){
			return -1;
		}else if(this.duration<((DelayedWorker)o).getDuration()) {
			return 1;
		}
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		
		return unit.convert(duration-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return this.message;
	}
	
}
public class DelayedQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      BlockingQueue<DelayedWorker> queue = new DelayQueue<>();
      try {
    	  queue.put(new DelayedWorker(1000,"This is the first Message"));
    	  queue.put(new DelayedWorker(10000,"This is the second Message"));
    	  queue.put(new DelayedWorker(4000,"This is the third Message"));
      }catch(InterruptedException e) {
    	  e.printStackTrace();
      }
      
      while(!queue.isEmpty()) {
    	  try {
    		  System.out.println(queue.take());
    	  }catch(InterruptedException e) {
    		  e.printStackTrace();
    	  }
      }
	}

}

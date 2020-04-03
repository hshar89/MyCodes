package com.Multithreading;

import java.util.ArrayList;
import java.util.List;

class processor2{
	
	private List<Integer> list = new ArrayList<>();
	private final int LIMIT = 5;
	private final int BOTTOM = 0;
	private final Object lock = new Object();
	private int value = 0;
	
	public void producer() throws InterruptedException{
		synchronized(lock) {
			while(true) {
				if(list.size() == LIMIT) {
					System.out.println("waiting for removing item from the list...");
					lock.wait();
				}else {
					System.out.println("adding "+value);
					list.add(value);
					value++;
					//Even if we called the notify method but there is 
					//some code below notify then method will continue to execute
					//and the lock is still there with the current thread
					//Only after wait is called that the lock gets release and the other thread starts
					lock.notify();
				}
			}
		}
	}
	public void consumer() throws InterruptedException{
		
		synchronized(lock) {
			while(true) {
				if(list.size()==BOTTOM) {
					System.out.println("waiting for adding item to the list...");
					lock.wait();
				}else {
					System.out.println("Removed: "+list.remove(--value));
					lock.notify();
				}
				Thread.sleep(500);
			}
		}
	}
}
public class App7 {
	static processor2 p = new processor2(); 
	public static void main(String[] args) {
		
     Thread t1 = new Thread(new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
	    		p.producer();
	    	}catch(InterruptedException e) {
	    		e.printStackTrace();
	    	}
		}
     });
     Thread t2 = new Thread(new Runnable() {
    	 @Override
 		public void run() {
 			// TODO Auto-generated method stub
 			try {
 	    		p.consumer();
 	    	}catch(InterruptedException e) {
 	    		e.printStackTrace();
 	    	}
 		} 
     });
     t1.start();
     t2.start();
     
     try {
		t1.join();
	    t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}

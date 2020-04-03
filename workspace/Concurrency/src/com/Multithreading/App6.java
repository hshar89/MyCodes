package com.Multithreading;
class processor{
	public void producer() throws InterruptedException{
		synchronized(this) {
			System.out.println("We are in producer...");
			wait();
			System.out.println("Again producer method...");
		}
	}
	public void consumer() throws InterruptedException{
		Thread.sleep(1000);
		synchronized(this) {
			System.out.println("Consumer method....");
			notify();
			//The other thread waits till this 10000 elapses even though notify was called
			Thread.sleep(10000);
		}
	}
}
public class App6 {
	
	static processor p = new processor(); 
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

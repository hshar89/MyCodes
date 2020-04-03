package Test1;

import java.util.concurrent.TimeUnit;

public class StopThread {
   private static volatile boolean stopThread;
   private static int nextSerialNumber = 1;
   
   public static synchronized int generateNextSerialNumber() {
	   return nextSerialNumber++;
   }
   public static synchronized void requestStop() {
	   stopThread = true;
   }
   public static synchronized boolean doStop() {
	   return stopThread;
   }
	public static void main(String[] args) throws InterruptedException {
		
		/*Thread backGround = new Thread(new Runnable() {

			@Override
			public void run() {
				int i =0;
				while(!stopThread) {
					i++;
					System.out.println(i);
				}
				
			}
			
		});
		backGround.start();
		TimeUnit.SECONDS.sleep(1);
		//requestStop();
		stopThread=true;*/
		
		Thread bg1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<20;i++) {
					System.out.println(Thread.currentThread().getName());
				System.out.println(generateNextSerialNumber());
				}
			}
			
		});
		Thread bg2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<20;i++) {
					System.out.println(Thread.currentThread().getName());
				System.out.println(generateNextSerialNumber());
				}
			}
			
		});
		Thread bg3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<20;i++) {
					System.out.println(Thread.currentThread().getName());
				System.out.println(generateNextSerialNumber());
				}
			}
			
		});
		
		bg1.start();
		bg2.start();
		bg3.start();
		
	}

}

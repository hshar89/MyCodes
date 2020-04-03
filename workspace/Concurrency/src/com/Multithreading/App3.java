package com.Multithreading;
class worker implements Runnable{
	private volatile boolean isTerminated = false;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!isTerminated) {
			System.out.println("Hello from worker class");
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean isTerminated() {
		return isTerminated;
	}

	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}
	
}
public class App3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      worker w1 = new worker();
      Thread t1 = new Thread(w1);
      t1.start();
      
      try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      w1.setTerminated(true);
      System.out.println("Finished...");
	}

}

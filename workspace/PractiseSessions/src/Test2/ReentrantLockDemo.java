package Test2;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
	
	private final ReentrantLock lock = new ReentrantLock();
	
	private int count = 0;
	
	public int getCount() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+" gets Count: "+count);
			return count++;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			lock.unlock();
		}
		return 0;
	}
	public static void main(String args[]) {
		final ReentrantLockDemo demo = new ReentrantLockDemo();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				while(demo.getCount()<=6) {
					try {
						Thread.sleep(1000);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
			}
			
		},"Thread 1");
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while(demo.getCount()<=6) {
					try {
						Thread.sleep(1000);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
			}
			
		},"Thread 2");
		t1.start();
		t2.start();
	}
}

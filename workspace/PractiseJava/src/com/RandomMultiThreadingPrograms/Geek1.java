package com.RandomMultiThreadingPrograms;

public class Geek1 implements Runnable{
	
	
	
	@Override
	public void run() {
		synchronized(this) {
			System.out.println(Thread.currentThread().getName()+"...starts");
			try {
				System.out.println(Thread.currentThread().getName()+"..went to wait");
				this.wait();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println(Thread.currentThread().getName()+"..came out of waiting");
		}
	}

}

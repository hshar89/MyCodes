package com.RandomMultiThreadingPrograms;

public class Geek2 implements Runnable{
	
	private Geek1 geek1;
	
	public Geek2(Geek1 geek1) {
		this.geek1 = geek1;
	}
	@Override
	public void run() {
		synchronized(geek1) {
			System.out.println(Thread.currentThread().getName()+"...starts");
			try {
				System.out.println(Thread.currentThread().getName()+"..went to wait");
				this.geek1.wait();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println(Thread.currentThread().getName()+"...came out of wait");
		}
		
	}	

}

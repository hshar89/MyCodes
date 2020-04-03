package com.RandomMultiThreadingPrograms;

public class Geek3 implements Runnable {
	private Geek1 geek1;

	public Geek3(Geek1 geek1) {
		this.geek1 = geek1;
	}

	@Override
	public void run() {
		synchronized (geek1) {
			System.out.println(Thread.currentThread().getName() + "...starts");
				this.geek1.notifyAll();
			System.out.println(Thread.currentThread().getName() + "..notified");
		}

	}
}

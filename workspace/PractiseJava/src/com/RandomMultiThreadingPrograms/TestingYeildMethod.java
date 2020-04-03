package com.RandomMultiThreadingPrograms;

public class TestingYeildMethod implements Runnable{
	
	private static boolean isFinished = false;
	private static int sum = 0; 
	public static void main(String[] args) {
		TestingYeildMethod tym = new TestingYeildMethod();
		Thread t1 = new Thread(tym,"First");
		t1.start();
		for(int i=0;i<1000;i++) {
			sum++;
			Thread.yield();
		}
		isFinished = true;
	}
	@Override
	public void run() {
			while(!isFinished) {
				System.out.println("sum: "+sum);
			}
	}

}

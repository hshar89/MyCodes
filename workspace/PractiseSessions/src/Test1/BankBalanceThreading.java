package Test1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BankBalanceThreading {
	
	private int balance;
	private int count = 0;
	private AtomicInteger ai = new AtomicInteger(0);
	
	public int getCountAtomically() {
		return ai.incrementAndGet();
	}
	public synchronized int getCount() {
		return count++;
	}
	public synchronized int getBalance() {
		return balance;
	}
	public synchronized void setBalance(int x) {
		balance  = x;
		if(balance <0) {
			throw new IllegalStateException("Negative Balance");
		}
	}
	public synchronized void deposit(int x) {
		int b = getBalance();
		for(int i=0;i<100;i++) {
			
		}
		setBalance(b+x);
	}
	public synchronized void withdraw(int x) {
		int b = getBalance();
		for(int i=0;i<1000;i++) {
					
				}
		setBalance(b-x);
	}
	public static void main(String[] args) throws InterruptedException {
		
		BankBalanceThreading b1 = new BankBalanceThreading();
		b1.setBalance(100);
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				b1.deposit(20);
			}
			
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				b1.withdraw(20);
			}
			
		});
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				b1.withdraw(40);
			}
			
		});
		Thread t4 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				b1.deposit(40);
				System.out.println("from thread "+b1.balance);
			}
			
		});
		System.out.println(b1.balance);
		t1.start();
		t3.start();
		t2.start();
		TimeUnit.SECONDS.sleep(1);	
		t4.start();
		System.out.println(b1.balance);
		TimeUnit.SECONDS.sleep(1);
		Thread t5 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<20;i++)
				System.out.println("from thread count "+b1.getCountAtomically());
			}
			
		});
		Thread t6 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<20;i++)
				System.out.println("from thread count "+b1.getCountAtomically());
			}
			
		});
		Thread t7 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<20;i++)
				System.out.println("from thread count "+b1.getCountAtomically());
			}
			
		});
		
		t5.start();
		t6.start();
		t7.start();
		
	}

}

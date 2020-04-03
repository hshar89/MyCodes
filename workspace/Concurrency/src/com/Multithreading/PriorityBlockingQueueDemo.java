package com.Multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class FirstWorker2 implements Runnable{
    private BlockingQueue<String> blockingQueue;
    private BlockingQueue<Person> blockingQueuep;
    public FirstWorker2(BlockingQueue<String> blockingQueue,BlockingQueue<Person> blockingQueuep) {
    	this.blockingQueue = blockingQueue;
    	this.blockingQueuep = blockingQueuep;
    }
	@Override
	public void run() {
		Person p1 = new Person(21,"Mike");
		Person p2 = new Person(24,"Shelly");
		Person p3 = new Person(56,"Amalda");
		Person p4 = new Person(12,"Defnay");
		try {	
		blockingQueue.put("B");
		blockingQueuep.put(p1);
		Thread.sleep(5000);
		blockingQueue.put("G");
		blockingQueue.put("A");
		blockingQueuep.put(p2);
		blockingQueuep.put(p4);
		blockingQueue.put("H");
		Thread.sleep(1000);
	    blockingQueue.put("I");
	    blockingQueuep.put(p3);
		Thread.sleep(1000);
		blockingQueue.put("R");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
class SecondWorker2 implements Runnable{
    private BlockingQueue<String> blockingQueue;
    private BlockingQueue<Person> blockingQueuep;
    public SecondWorker2(BlockingQueue<String> blockingQueue,BlockingQueue<Person> blockingQueuep) {
    	this.blockingQueue = blockingQueue;
    	this.blockingQueuep = blockingQueuep;
    }
	@Override
	public void run() {
		
		try {	
	    Thread.sleep(2000);
		System.out.println(blockingQueue.take());
		System.out.println(blockingQueuep.take());
		Thread.sleep(1000);
		System.out.println(blockingQueue.take());
		Thread.sleep(1000);
		System.out.println(blockingQueue.take());
		System.out.println(blockingQueuep.take());
		Thread.sleep(500);
		System.out.println(blockingQueue.take());
		System.out.println(blockingQueue.take());
		System.out.println(blockingQueuep.take());
		System.out.println(blockingQueuep.take());
		System.out.println(blockingQueue.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
class Person implements Comparable{
	private int age;
	private String name;
	
	public Person(int age, String name) {
		this.age= age;
		this.name = name;
	}

	@Override
	public int compareTo(Object o) {
		return Integer.compare(this.age, ((Person)o).getAge());
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
}
public class PriorityBlockingQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     BlockingQueue<String> blockingQueue = new PriorityBlockingQueue<String>();
     BlockingQueue<Person> blockingQueuep = new PriorityBlockingQueue<Person>();
     new Thread(new FirstWorker2(blockingQueue,blockingQueuep)).start();
     new Thread(new SecondWorker2(blockingQueue,blockingQueuep)).start();
     System.out.println("Done....");
	}

}

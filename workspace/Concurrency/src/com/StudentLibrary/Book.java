package com.StudentLibrary;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
   
	private int id;
	private Lock lock;
	
	public Book(int id) {
		this.id= id;
		this.lock = new ReentrantLock();
	}
	
	public void read(Student stu) throws InterruptedException{
		if(lock.tryLock(100,TimeUnit.MILLISECONDS)){
		//lock.lock();
		System.out.println(stu+" starts reading "+ this);
		Thread.sleep(2000);
		lock.unlock();
		System.out.println(stu+" finished reading this "+ this);
		}
	}
    
	
	@Override
	public String toString() {
		return "Book [id=" + id + "]";
	}
}

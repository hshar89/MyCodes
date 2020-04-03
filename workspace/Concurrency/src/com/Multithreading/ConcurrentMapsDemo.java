package com.Multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class FirstWorker3 implements Runnable{
	private ConcurrentMap<String,Integer> map;
    public FirstWorker3(ConcurrentMap<String,Integer> map) {
    	this.map = map;
    }
    
	@Override
	public void run() {
		try {
		Thread.sleep(2000);
		map.put("B", 1);
		map.put("C", 4);
		map.put("E", 18);
		map.put("R" , 32);
		Thread.sleep(1000);
		map.put("Z" , 199);
		map.put("O" , 78);
		Thread.sleep(3000);
		map.put("W" , 75);
		map.put("S" , 79);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
class SecondWorker3 implements Runnable{
	private ConcurrentMap<String,Integer> map;
    public SecondWorker3(ConcurrentMap<String,Integer> map) {
    	this.map = map;
    }
    
	@Override
	public void run() {
		try {
		Thread.sleep(2000);
		System.out.println(map.get("S"));
		Thread.sleep(1000);
		System.out.println(map.get("O"));
		System.out.println(map.get("B"));
		System.out.println(map.get("C"));
		Thread.sleep(3000);
		System.out.println(map.get("W"));
		System.out.println(map.get("Z"));
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
public class ConcurrentMapsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ConcurrentMap<String,Integer> map = new ConcurrentHashMap<String,Integer>();
        new Thread(new FirstWorker3(map)).start();
        new Thread(new SecondWorker3(map)).start();
        //For making any collection synchronized
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = Collections.synchronizedList(list1);
	}

}

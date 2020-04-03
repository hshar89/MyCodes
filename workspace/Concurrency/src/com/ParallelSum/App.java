package com.ParallelSum;

import java.util.Random;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Random random = new Random();
       int n = 100000000;
       int arr[] = new int[n];
       for(int i=0;i<n;i++) {
    	   arr[i] += random.nextInt(100);
       }
       SequentialSum ss = new SequentialSum();
       long startTime = System.currentTimeMillis();
       System.out.println(ss.sum(arr));
       long endTime = System.currentTimeMillis();
       System.out.println("Sequential time takes "+(endTime-startTime)+" ms");
       
       ParallelSum ps = new ParallelSum(Runtime.getRuntime().availableProcessors());
       startTime = System.currentTimeMillis();
       System.out.println(ps.sum(arr));
       endTime = System.currentTimeMillis();
       
       System.out.println("Parallel time takes "+(endTime-startTime)+" ms");
	}

}

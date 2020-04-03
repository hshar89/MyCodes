package com.forkjoin.MergeSort;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class App {

	public static void main(String[] args) {
		
		Random random = new Random();
		int n = 100;
		int arr[] = new int[n];
        for(int i=0;i<n;i++) {
        	arr[i] = random.nextInt(100000);
        }
        
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        long startTime = System.currentTimeMillis();
        ParallelMergeSortTask pmt = new ParallelMergeSortTask(arr);
        pool.invoke(pmt);
        System.out.println("time taken for parallel  merge sort "+(System.currentTimeMillis()-startTime)+"ms");
        //pmt.showResults();
	}

}

package com.forkjoin.maximumFindingAlgo;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class App {

	public static int THRESHOLD = 0;

	public static void main(String[] args) {
		long totalTime = System.currentTimeMillis();
		Random random = new Random();
        int n = 200000000;
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = random.nextInt(100000000);
		}
		THRESHOLD = n/Runtime.getRuntime().availableProcessors();
		
		SequentialMaxFinding smf = new SequentialMaxFinding();
		long startTime = System.currentTimeMillis();
		System.out.println("Maximum from sequential "+smf.sequentialMaxFinding(arr));
		System.out.println("Time take "+(System.currentTimeMillis()-startTime)+"ms");
		
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		ParallelMaxFinding pmf =new ParallelMaxFinding(0,n-1,arr);
		startTime = System.currentTimeMillis();
		System.out.println("Maximum from parallel "+pool.invoke(pmf));
		System.out.println("Time taken "+(System.currentTimeMillis()-startTime)+"ms");
		
		System.out.println("\nTotal Time for main method "+(System.currentTimeMillis()-totalTime)+"ms");
	}

}

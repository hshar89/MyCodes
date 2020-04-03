package com.mergeSort.sequential;

import java.util.Random;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numOfThreads = Runtime.getRuntime().availableProcessors();
		
		System.out.println("NumOfThreads## "+numOfThreads);
		
		Random random = new Random();
	     int arr1[] = new int[1000000];
	     int arr2[] = new int[1000000];
	     for(int i=0;i<1000000;i++) {
	    	 arr1[i] = random.nextInt(1000000);
	     }
	     for(int i=0;i<1000000;i++) {
	    	 arr2[i] = random.nextInt(1000000);
	     }
	     
		ParallelMergeSort pms = new ParallelMergeSort(arr1);
		
		long startTime = System.currentTimeMillis();
		pms.parallerMergeSort(0, arr1.length-1,numOfThreads);
		long endTime = System.currentTimeMillis();
		//pms.showResults();
		System.out.println();
		System.out.println("Time taken for parallel merge sort of 100 items "+ (endTime-startTime));
		
		ParallelMergeSort pms2 = new ParallelMergeSort(arr2);
		startTime = System.currentTimeMillis();
		pms2.mergeSort(0, arr2.length-1);
		endTime = System.currentTimeMillis();
		//pms.showResults();
		System.out.println();
		System.out.println("Time taken for sequential merge sort 100 items" + (endTime-startTime));
		
	}

}

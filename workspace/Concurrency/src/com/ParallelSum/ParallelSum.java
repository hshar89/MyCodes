package com.ParallelSum;

public class ParallelSum {
   private ParallelSumWorker sums[];
   private int numOfThreads;
   
   public ParallelSum(int numOfThreads) {
	   this.numOfThreads = numOfThreads;
	   this.sums = new ParallelSumWorker[numOfThreads];
   }
   
   public int sum(int nums[]) {
	   int steps = (int) Math.ceil(nums.length*1.0/numOfThreads);
	   for(int i=0;i<numOfThreads;i++) {
		   sums[i] = new ParallelSumWorker(nums,i*steps,(i+1)*steps);
		   sums[i].start();
	   }
	   
	   try {
		   for(ParallelSumWorker pw: sums) {
			   pw.join();
		   }
	   }catch(InterruptedException e) {
		   e.printStackTrace();
	   }
	   int total = 0;
	   for(ParallelSumWorker pw: sums) {
		   total+=pw.getPartialSum();
	   }
	   return total;
   }
}

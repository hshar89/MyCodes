package com.ParallelSum;

public class SequentialSum {
   public int sum(int[] num) {
	   int total = 0;
	   for(int i=0;i<num.length;i++) {
		   total+=num[i];
	   }
	   return total;
   }
}

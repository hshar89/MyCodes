package com.forkjoin.maximumFindingAlgo;

import java.util.concurrent.RecursiveTask;

public class ParallelMaxFinding extends RecursiveTask<Integer>{
	
    private int[] nums;
	int low;
	int high;
	public ParallelMaxFinding(int low, int high, int nums[]) {
		this.nums = nums;
		this.low = low;
		this.high = high;
	}

	@Override
	protected Integer compute() {
		
		if(high-low<App.THRESHOLD) {
			return sequentialMaxFinding();
		}else {
			int middle = (low+high)/2;
			ParallelMaxFinding pmf1 = new ParallelMaxFinding(low,middle,nums);
			ParallelMaxFinding pmf2 = new ParallelMaxFinding(middle+1,high,nums);
			
			invokeAll(pmf1,pmf2);
			
			return Math.max(pmf1.join(), pmf2.join());
		}
	}
     
	private int sequentialMaxFinding() {
		int max = nums[low];
		
		for(int i=low+1;i<=high;i++) {
			if(nums[i]>max) {
				max = nums[i];
			}
		}
		return max;
	}
}

package com.mergeSort.sequential;

public class ParallelMergeSort {
	private int nums[];
    private int tempArray[];
    
    public ParallelMergeSort(int[] nums) {
    	this.nums = nums;
    	tempArray = new int[nums.length];
    }
    
    public void showResults() {
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+" ");
		}
	}
	public void parallerMergeSort(int low, int high, int numOfThreads) {
		//Create as many threads as number of cores/proccessors 
		//to maintain paraller processing
		if(numOfThreads<=1) {
			mergeSort(low,high);
		}else {
			int middle = (low+high)/2;
			
			Thread leftSorter = mergeSortParallel(low,middle,numOfThreads);
			Thread rightSorter = mergeSortParallel(middle+1,high,numOfThreads);
			
			leftSorter.start();
			rightSorter.start();
			
			try {
				leftSorter.join();
				rightSorter.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			merge(low,middle,high);
		}
		
	}
	 public void mergeSort(int low, int high) {
	    	if(low>=high) {
	    		return;
	    	}
	    	int middle = (low+high)/2;
	    	mergeSort(low,middle);
	    	mergeSort(middle+1,high);
	    	merge(low,middle,high);
	    }
		private void merge(int low, int middle, int high) {
			for(int i=low;i<=high;i++) {
				tempArray[i] = nums[i];
			}
			int i=low;
			int j=middle+1;
			int k= low;
			
			while((i<=middle)&&(j<=high)) {
				if(tempArray[i]<=tempArray[j]) {
					nums[k] = tempArray[i];
					i++;
				}else {
					nums[k] = tempArray[j];
					j++;
				}
				k++;
			}
			while(i<=middle) {
				nums[k++]= tempArray[i++];
			}
			while(j<=high) {
				nums[k++]= tempArray[j++];
			}
		}
	private Thread mergeSortParallel(int low, int high, int numOfThreads) {
		return new Thread(new Runnable() {
			@Override
			public void run() {
				parallerMergeSort(low,high,numOfThreads/2);
			}
		});
	}

}

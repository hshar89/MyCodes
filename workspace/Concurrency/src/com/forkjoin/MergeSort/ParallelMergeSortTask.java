package com.forkjoin.MergeSort;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSortTask extends RecursiveAction {
   
	private int arr[];
	public ParallelMergeSortTask(int nums[]) {
		this.arr = nums;
	}
	
	private void mergeSort(int nums[]) {
		
		if(nums.length<=1) {
			return;
		}
		int middle = (nums.length/2);
		int left[] = Arrays.copyOfRange(nums, 0,middle);
		int right[] = Arrays.copyOfRange(nums, middle, nums.length);
		
		mergeSort(left);
		mergeSort(right);
		merge(left,right,nums);
	}
	private void merge(int[] left, int[] right, int[] nums) {
		
		int i=0;
		int j = 0;
		int k =0;
		while(i<left.length && j<right.length) {
			if(left[i]<=right[j]) {
				nums[k++] = left[i++];
				
			}else {
				nums[k++] = right[j++];
			}
		}
		while(i<left.length) {
			nums[k++] = left[i++];
		}
		while(j<right.length) {
			nums[k++] = right[j++];
		}
	}
	@Override
	protected void compute() {
		
		if(arr.length<=10) {
			mergeSort(arr);
			return;
		}
		int middle = arr.length/2;
		
		int left[] = Arrays.copyOfRange(arr, 0, middle);
		int right[] = Arrays.copyOfRange(arr, middle, arr.length);
		
		ParallelMergeSortTask leftTask  = new ParallelMergeSortTask(left);
		ParallelMergeSortTask rightTask  = new ParallelMergeSortTask(right);
		
		invokeAll(leftTask,rightTask);
		merge(left,right,arr);		
	}
	public void showResults() {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
     
}

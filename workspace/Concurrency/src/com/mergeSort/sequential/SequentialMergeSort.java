package com.mergeSort.sequential;

import java.util.Random;

public class SequentialMergeSort {
    private int nums[];
    private int tempArray[];
    
    public SequentialMergeSort(int[] nums) {
    	this.nums = nums;
    	this.tempArray = new int[nums.length];
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
	public void showResults() {
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+" ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
     int arr[] = new int[100];
     for(int i=0;i<100;i++) {
    	 arr[i] = random.nextInt(1000) - 500;
     }
     SequentialMergeSort sms = new SequentialMergeSort(arr);
     sms.mergeSort(0, arr.length-1);
     sms.showResults();
	}

}

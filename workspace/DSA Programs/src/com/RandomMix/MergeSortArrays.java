package com.RandomMix;

public class MergeSortArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] arr = {7,9,11,2,1,6,4,3,13,3,2,2,1,1,5};
     System.out.println("Before merge sort...");
     printArr(arr,arr.length);
     //mergeSort(arr,0,arr.length-1);
     insertionSortThroughRecursion(arr,0,arr.length-1);
     System.out.println("After merge sort...");
     printArr(arr,arr.length);
	}

	private static void printArr(int[] arr, int n) {
		// TODO Auto-generated method stub
       for(int i=0;i<n;i++) {
    	   System.out.print(arr[i]+" ");
       }
	}
	private static void sumOfTwoNumbersEqualX(int[] arr,int x) {
		
	}
    private static void insertionSortThroughRecursion(int[] arr, int l,int r) {
    	if(r==l) {
    		return;
    	}
    		insertionSortThroughRecursion(arr,l,r-1);
    		int j = r-1,key = arr[r];
    		while(j>=0 && arr[j]>key) {
    		    arr[j+1] = arr[j];
    			j--;
    		}	
    		arr[j+1] = key;
			/*
			 * int j=i-1,key=arr[i]; while(j>=0 && arr[j]>key) { arr[j+1] = arr[j]; j--; }
			 * arr[j+1] = key;
			 */
    	}
	public static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, r);
			merge(arr, l, mid, r);
		}
	}

	private static void merge(int[] arr, int l, int mid, int r) {
		// TODO Auto-generated method stub
		int n1 = mid-l+1;
		int n2 = r-mid;
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];
        for(int i=0;i<n1;i++) {
        	L[i] = arr[l+i];
        }
        for(int i=0;i<n2;i++) {
        	R[i] = arr[mid+i+1];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i=0,j=0;
        for(int k=l;k<=r;k++) {
        	if(L[i]<=R[j]) {
        		arr[k] = L[i++];
        	}else {
        		arr[k] = R[j++];
        	}
        }
	}

}

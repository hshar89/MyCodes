package PractiseJavaPrograms;

import java.util.Arrays;
import static java.lang.System.*;
public class Practise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "898 259 517 134 9 450 14 88 915 533 151 154 669 810 685 430 49 948 314 571 63 194 837 503 334 851 596 597 216 "
				+ "475 92 861 357 356 101 618 364 365 366 627 245 119 782 84 893 789";
		String[] s2 = s1.trim().split("\\s+");
		long com = 2639808309l;
		int[] arr= new int[s2.length];
		for(int i=0;i<s2.length;i++){
			arr[i] = Integer.parseInt(s2[i]);
			//arr2[i] = arr[i];
		}
		
		int k1 = 14;
		  int k2 = 344;
		  //sortArray(arr,arr.length,k1,k2);
		  //normalSort(arr2,arr.length);
		  Arrays.sort(arr);
		  out.println("this is my sort");
		  printArray(arr);
		  int thatPoint = findSum(arr,arr.length,k1,k2);
		  out.println(thatPoint);
		  //System.out.println("ye divide kro "+(3/2));
	}
	static void sortArray(int[] arr,int n,int k1,int k2){
		int sum=0;
	     for(int i=0;i<k2-1;i++){
	        int min_idx = i;
	        for(int j=i+1;j<n;j++){
	            if(arr[min_idx]>arr[j]){
	                min_idx = j;
	            }
	        }
	        int temp = arr[min_idx]; 
           arr[min_idx] = arr[i]; 
           arr[i] = temp; 
           if(i>=k1){
        	   System.out.println("arr i "+i+" "+arr[i]);
        	   sum+=arr[i];
           }
	     }
	     System.out.println(sum);
	 }
	static void normalSort(int[] arr, int n){
		 for(int i=0;i<n-1;i++){
		        int min_idx = i;
		        for(int j=i+1;j<n;j++){
		            if(arr[min_idx]>arr[j]){
		                min_idx = j;
		            }
		        }
		        int temp = arr[min_idx]; 
	           arr[min_idx] = arr[i]; 
	           arr[i] = temp; 
		     }
	}
	 static int findSum(int[] arr, int n,int k1, int k2){
		 if(k2>n){
			 k2=n+1;
		 }
	     int sum=0;
	     for(int i=k1;i<k2-1;i++){
	    	 System.out.println(" arr "+i+" "+arr[i]);
	           sum+=arr[i];  
	     }
	     return sum;
	 }
	 static void printArray(int arr[]) 
   { 
       int n = arr.length; 
       for (int i=0; i<n; ++i) 
           System.out.print(arr[i] + " "); 
       System.out.println(); 
   } 
}

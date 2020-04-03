package PractiseJavaPrograms;

import java.util.ArrayList;

public class PrintFrequencyInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, 3, 3, 2, 5}; 
		int arr1[] = {1}; 
		int arr3[] = {4, 4, 4, 4}; 
		printFrequency(arr,arr.length);
		System.out.println();
		printFrequency(arr1,arr1.length);
		System.out.println();
		printFrequency(arr3,arr3.length);
		
		 int arr4[] = {2, 3, 3, 2, 5}; 
		 System.out.println();
	        int n = arr4.length; 
	        printfrequency2(arr4,n);
	        ArrayList<Integer> leaderList = new ArrayList<Integer>();
	       
	}
	 public static void  printFrequency(int arr[], int n){
	        
	        // Your code here
	        int i=0;
	        while(i<n){
	            if(arr[i]<0){
	                i++;
	                continue;
	            }
	            int elementIndex = arr[i] - 1;
	            if(arr[elementIndex]>0){
	                arr[i] = arr[elementIndex];
	                arr[elementIndex] = -1;
	            }else{
	                arr[elementIndex]--;
	                arr[i] = 0;
	                i++;
	            }
	            
	        }
	        for(int j=0;j<n;j++){
	            System.out.print(Math.abs(arr[j])+" ");
	        }
	    }
	 static void printfrequency2(int arr[], int n)  
	    { 
	        // Subtract 1 from every element so that the elements 
	        // become in range from 0 to n-1 
	        for (int j = 0; j < n; j++) 
	            arr[j] = arr[j] - 1; 
	  
	        // Use every element arr[i] as index and add 'n' to 
	        // element present at arr[i]%n to keep track of count of 
	        // occurrences of arr[i] 
	        for (int i = 0; i < n; i++) 
	            arr[arr[i] % n] = arr[arr[i] % n] + n; 
	  
	        // To print counts, simply print the number of times n 
	        // was added at index corresponding to every element 
	        for (int i = 0; i < n; i++) 
	            System.out.println(i + 1 + "->" + arr[i] / n); 
	    } 

}

package PractiseJavaPrograms;

import java.util.Arrays;

public class FindSmallestMissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0, 10, 2, -10, -20}; 
		int arr3[] = {5, 4, 3, 2, 1}; 
        int arr_size = arr3.length; 
        int missing = findMissing(arr3, arr_size); 
        System.out.println("The smallest positive missing number is "+  
                            missing); 
        int A[] = {0, 10, 2, 130, 1}; 
        System.out.println(solution(A)); 
	}
	static void printArray(int[] arr,int n){
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}
	static int findMissing(int[] arr, int n){
		int shift = segregate(arr,n);
		System.out.println(" \n shift "+shift);
		System.out.println("The segregated array ");
		printArray(arr,n);
		int[] arr2 = new int[n-shift];
		int j =0;
		for(int i =shift;i<n;i++){
			arr2[j] = arr[i];
			j++;
		}
		System.out.println("The new array for positives ");
		printArray(arr2,arr2.length);
		return findSmallestMissingNum(arr2,arr2.length);
	}
   static int segregate(int[] arr, int n){
	   int j=0;
	   for(int i=0;i<n;i++){
		   if(arr[i]<=0){
			   int temp = arr[i];
			   arr[i] = arr[j];
			   arr[j] = temp;
			   j++;
		   }
	   }
	   return j;
   }
   static int findSmallestMissingNum(int[] arr, int l){
	   for(int i=0;i<l;i++){
		   int m = Math.abs(arr[i]);
		   if(m-1<l && arr[m-1]>0){
			   arr[m-1] = -arr[m-1];
		   }
	   }
	   System.out.println("\n after doing negation ");
	   printArray(arr,l);
	   for(int i=0;i<l;i++){
		   if(arr[i]>0){
			   return i+1;
		   }
	   }
	   return l+1;
   }
   //Another approach to do the same
   static int solution(int[] A) {//Our original array 
	   
       int m = Arrays.stream(A).max().getAsInt(); //Storing maximum value 
       if (m < 1) // In case all values in our array are negative 
       { 
           return 1; 
       } 
       if (A.length == 1) { 
 
           //If it contains only one element 
           if (A[0] == 1) { 
               return 2; 
           } else { 
               return 1; 
           } 
       } 
       int i = 0; 
       int[] l = new int[m]; 
       for (i = 0; i < A.length; i++) { 
           if (A[i] > 0) { 
               if (l[A[i] - 1] != 1) //Changing the value status at the index of our list 
               { 
                   l[A[i] - 1] = 1; 
               } 
           } 
       } 
       for (i = 0; i < l.length; i++) //Encountering first 0, i.e, the element with least value 
       { 
           if (l[i] == 0) { 
               return i + 1; 
           } 
       } 
       //In case all values are filled between 1 and m 
       return i+2; 
   } 
}

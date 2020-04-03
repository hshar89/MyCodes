package PractiseJavaPrograms;

import java.util.ArrayList;
import java.util.List;

public class LargestPrimeFactor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] prime = findPrimeLessThanNum(6587688);
		//printArray(prime);
		 findLargestPrimeFactor(15l);
		 
	}
	static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
	 static void findLargestPrimeFactor(long num){
		   
		 long i=2l, largestPrime = 2l;

		 while(num>1){
		         while(num%i ==0){
		             num = num/i;
		             largestPrime = i;
		         }
		          i++;
		         if(i*i>num){
		             largestPrime = num;
		             break;
		         }
		        
		     }
		     System.out.println(largestPrime);
		 }
}

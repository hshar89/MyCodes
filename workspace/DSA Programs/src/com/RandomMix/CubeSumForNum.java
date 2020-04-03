package PractiseJavaPrograms;

import java.util.ArrayList;
import java.util.List;

public class CubeSumForNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=9;
		 int[] arr=  getSetOfIntegersForCubes(num);
		   printArray(arr);
		   int count=0;
		   if(num ==1){
			   System.out.println(1);
		   }
		   outer:
		   for(int i=0;i<arr.length;i++){
		       int j=0;
		       int a=arr[i]*arr[i]*arr[i];
		       inner:
		       while(j<arr.length && a!=0){
		           int b=arr[j]*arr[j]*arr[j];
		           if((a + b)==num){
		               count++;
		           }
		           if((a+b)>num){
		               break inner;
		           }
		           j++;
		       }
		   }
		   System.out.println(count);
	}
	 static int[] getSetOfIntegersForCubes(int num){
	     int i=0;
	     int[] arr = new int[num+1];
	     while(i<arr.length){
	        if(i*i*i>num){
	            break;
	        } 
	        arr[i] = i;
	        i++;
	     }
	     return arr;
	 }
	 static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 

}

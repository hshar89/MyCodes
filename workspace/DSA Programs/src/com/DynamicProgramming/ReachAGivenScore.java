package com.DynamicProgramming;

public class ReachAGivenScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		waysToReachScore(350);
	}
    public static void waysToReachScore(int n) {
    	long ways[] = new long[n+1];
	     if(n==1 || n==2){
	         System.out.println(0);
	         return;
	     }
	     ways[0] = 1;
	     ways[1] = 0;
	     ways[2] = 0;
	     ways[3] = 1;
	     int arr[] = {3,5,10};
	     for(int j=0;j<3;j++){
	     for(int i=4;i<=n;i++){
	          if(i>=arr[j]){
	        ways[i] += ways[i-arr[j]];  
	        }
	     }
	 }
	 System.out.println(ways[n]);
    }
}

package com.DynamicProgramming;

public class SubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int arr[] = {479,758,315,472,730,101,460,619,510,612,8};
     System.out.println("find subset sum Top down: "+findEqualSumSubsetTopDown(arr,arr.length));
     System.out.println("find subset sum Bottom Up: "+findEqualSumSubsetBottomUp(arr,arr.length));
	}

	private static boolean findEqualSumSubsetBottomUp(int[] arr, int n) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=0;i<n;i++) {
			sum+=arr[i];
		}
		if(sum%2==1) {
			return false;
		}
 		return findEqualSumBottomUp(arr,n,sum/2);
	}

	private static boolean findEqualSumBottomUp(int[] arr, int n, int sum) {
		// TODO Auto-generated method stub
		// The value of subset[i][j] will be 
        // true if there is a subset of  
        // set[0..j-1] with sum equal to i 
        boolean subset[][] =  
                     new boolean[sum+1][n+1]; 
      
        // If sum is 0, then answer is true 
        for (int i = 0; i <= n; i++) 
            subset[0][i] = true; 
      
        // If sum is not 0 and set is empty, 
        // then answer is false 
        for (int i = 1; i <= sum; i++) 
            subset[i][0] = false; 
      
        // Fill the subset table in botton 
        // up manner 
        for (int i = 1; i <= sum; i++) 
        { 
            for (int j = 1; j <= n; j++) 
            { 
                subset[i][j] = subset[i][j-1]; 
                if (i >= arr[j-1]) 
                subset[i][j] = subset[i][j] ||  
                     subset[i - arr[j-1]][j-1]; 
            } 
        } 
      
         // uncomment this code to print table 
        /*for (int i = 0; i <= sum; i++) 
        { 
        for (int j = 0; j <= n; j++) 
            System.out.print (subset[i][j]+" "); 
        } */
      
        return subset[sum][n];
	}

	private static boolean findEqualSumSubsetTopDown(int[] arr, int n) {
		int sum=0;
		for(int i=0;i<n;i++) {
			sum+=arr[i];
		}
		if(sum%2==1) {
			return false;
		}
		boolean dp[][] = new boolean[n+1][sum+1];
		return findEqualSumTopDown(arr,n,dp,sum/2);
	}

	private static boolean findEqualSumTopDown(int[] arr, int n, boolean[][] dp, int sum) {
		if(n==0 && sum!=0) {
			return false;
		}
		if(sum<0) {
			return false;
		}
		if(sum==0) {
			return true;
		}
		if(dp[n-1][sum]) {
			return true;
		}
		dp[n-1][sum] = findEqualSumTopDown(arr,n-1,dp,sum)||findEqualSumTopDown(arr,n-1,dp,sum-arr[n-1]);
		return dp[n-1][sum];
	}

}

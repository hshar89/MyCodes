package com.DynamicProgramming;

public class OptimumGameStrategy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr3[] = { 20, 30, 2, 2, 2, 10 }; 
		System.out.println("Max amount earned: "+findMaxAmount(arr3,arr3.length));
	}
	public static int findMaxAmount(int arr[], int n) {
		int dp[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=i,k=0;j<n;j++,k++) {
				int x = ((k+1)<=(j-1))?dp[k+1][j-1]:0;
				int y = ((k+2)<=(j))?dp[k+2][j]:0;
				int z = ((k)<=(j-2))?dp[k][j-2]:0;
				dp[k][j] = Math.max(arr[k]+Math.min(x,y),arr[j]+Math.min(x,z));
			}
		}
		return dp[0][n-1];
	}

}

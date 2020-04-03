package com.DynamicProgramming;

import java.math.BigInteger;

public class MinCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int mat[][] = {{31,100,65,12,18},
    		  {10,13,47,157,6},
    		  {100,113,174,11,33},
    		  {88,124,41,20,140},
    		  {99,32,111,41,20}};
      int n =5;
      int m=5;
      System.out.println("Min cost using recursion: "+findMinCost(mat,n-1,m-1));
      System.out.println("Min cost using dynamic programming: "+findMinCostDp(mat,n));
      System.out.println(Math.pow(9, 20));
      String ab = "09778";
      BigInteger bg = new BigInteger((long)(ab.charAt(0)-'0'));
	}

	private static int findMinCost(int[][] mat, int n, int m) {
		// TODO Auto-generated method stub
		if(n<0||m<0) {
			return Integer.MAX_VALUE;
		}
		if(n==0&&m==0) {
			return mat[n][m];
		}
		return mat[n][m]+Math.min(Math.min(findMinCost(mat,n-1,m-1),findMinCost(mat,n-1,m)), findMinCost(mat,n,m-1));
	}
    private static int findMinCostDp(int mat[][],int n) {
    	int dp[][] = new int[n][n];
    	dp[0][0] = mat[0][0];
    	for(int i=1;i<n;i++) {
    		dp[i][0] = dp[i-1][0]+mat[i][0];
    	}
    	for(int i=1;i<n;i++) {
    		dp[0][i] = dp[0][i-1]+mat[0][i];
    	}
    	for(int i=1;i<n;i++) {
    		for(int j=1;j<n;j++) {
    			dp[i][j] = mat[i][j]+Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]),dp[i][j-1]);
    		}
    	}
    	return dp[n-1][n-1];
    }
}

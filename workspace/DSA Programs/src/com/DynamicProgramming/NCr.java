package com.DynamicProgramming;

public class NCr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int n = 50;
      int k = 30;
      System.out.println("Using Matrix: "+ncrUsingMatrix(n,k));
      System.out.println("Using Space optimized version: "+ncrUsingMatrix(n,k));
	}
    public static long ncrUsingMatrix(int n, int k) {
    	long dp[][] = new long[n+1][k+1];
    	dp[0][0] = 0;
    	for(int i=0;i<=n;i++) {
    		for(int j=0;j<=Math.min(i, k);j++) {
    			if(j==0 || i==j) {
    				dp[i][j] = 1;
    			}else {
    				dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
    			}
    		}
    	}
    	return dp[n][k];
    }
    public static long ncrSpaceOptimized(int n, int k) {
    	long dp[] = new long[k+1];
    	dp[0] =1;
    	for(int i=0;i<=n;i++) {
    		for(int j=Math.min(i, k);j>0;j--) {
    			dp[j] = dp[j]+dp[j-1];
    		}
    	}
    	return dp[k];
    }
} 

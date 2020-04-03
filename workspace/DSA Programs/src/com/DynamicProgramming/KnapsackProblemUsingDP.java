package com.DynamicProgramming;

public class KnapsackProblemUsingDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[] = {60, 100, 120}; 
	    int wt[] = {10, 20, 30}; 
	    int  W = 50; 
	    System.out.println("Max value for given knapsack: "+findMaxValue(W,wt,val,val.length));
	}
    public static int findMaxValue(int W,int wt[], int val[], int n) {
    	int dp[][] = new int[n+1][W+1];
    	for(int i=0;i<=n;i++) {
    		dp[i][0] = 0;
    	}
    	for(int i=0;i<=W;i++) {
    		dp[0][i] = 0;
    	}
    	for(int i=1;i<=n;i++) {
    		for(int j=1;j<=W;j++) {
    			if(wt[i-1]>j) {
    				dp[i][j] = dp[i-1][j];
    			}else {
    				dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i-1][j-wt[i-1]]);
    			}
    		}
    	}
    	return dp[n][W];
    }
}

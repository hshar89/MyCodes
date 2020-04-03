package com.DynamicProgramming;

public class CountWaysToNthStair {
    public static long countwaysUtil(int n, int m) {
    	if(n<=1) {
    		return n;
    	}
    	long res = 0;
    	for(int i=1;i<=n && i<=m;i++) {
    		res+=countwaysUtil(n-i,m);
    	}
    	return res;
    }
    public static long countways(int n, int m) {
    	return countwaysUtil(n+1,m);
    }
    public static long countWaysDynamic(int n, int m) {
    	long dp[] = new long[n+1];
    	dp[0] =1;
    	dp[1] =1;
    	for(int i=2;i<=n;i++) {
    		dp[i] = 0;
    		for(int j=1;j<=i && j<=m;j++) {
    			dp[i]+= dp[i-j];
    		}
    	}
    	return dp[n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println("count ways ### "+countWaysDynamic(4,2));
	}

}

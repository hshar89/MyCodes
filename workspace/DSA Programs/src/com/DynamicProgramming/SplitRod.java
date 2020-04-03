package com.DynamicProgramming;

public class SplitRod {
    private static int splitRodRecursion(int n, int a, int b, int c) {
    	if(n<0) {
    		return -1;
    	}
    	if(n==0) {
    		return 0;
    	}
    	int res = Math.max(Math.max(splitRodRecursion(n-a,a,b,c), splitRodRecursion(n-b,a,b,c)), splitRodRecursion(n-c,a,b,c));
    	if(res==-1) {
    		return res;
    	}
    	return res+1;
    }
    private static int splitRodMemoization(int n, int a, int b, int c,int memo[]) {
    	if(n<0) {
    		return -1;
    	}
    	if(memo[n]!=-1) {
    		return memo[n];
    	}
    	if(n==0) {
    		memo[n]  = 0;
    		return memo[n];
    	}
    	memo[n] = Math.max(Math.max(splitRodMemoization(n-a,a,b,c,memo), splitRodMemoization(n-b,a,b,c,memo)), splitRodMemoization(n-c,a,b,c,memo));
    	if(memo[n]==-1) {
    		return -1;
    	}
    	return memo[n]+1;
    }
    private static int splitRodTabulation(int n, int a, int b, int c) {
    	int dp[] = new int[n+1];
    	for(int i=1;i<=n;i++) {
    		dp[i] = -1;
    		if(i-a>=0) {
    			dp[i] = Math.max(dp[i-a], dp[i]);
    		}
    		if(i-b>=0) {
    			dp[i] = Math.max(dp[i-b],dp[i]);
    		}
    		if(i-c>=0) {
    			dp[i] = Math.max(dp[i], dp[i-c]);
    		}
    		dp[i]+=1;
    	}
    	return dp[n]-1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int n = 805;
       int a = 2;
       int b = 5;
       int c = 7;
       int memo[] = new int[n+1];
       for(int i=0;i<=n;i++) {
    	   memo[i] = -1;
       }
       //System.out.println("Maximum rod pieces through recursion: "+splitRodRecursion(n,a,b,c));
       System.out.println("Maximum rod pieces through Memoization: "+splitRodMemoization(n,a,b,c,memo));
       System.out.println("Maximum rod pieces through Tabulation: "+splitRodTabulation(n,a,b,c));
	}

}

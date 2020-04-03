package com.DynamicProgramming;

public class LargestCommonSubsequence {
	private static int lengthOfCommonSubsequenceMemoization(String a, String b, int n, int m, int memo[][]) {
		if (memo[n][m] != -1) {
			return memo[n][m];
		}
		if (n == 0 || m == 0) {
			memo[n][m] = 0;
			return memo[n][m];
		}
		if (a.charAt(n - 1) == b.charAt(m - 1)) {
			memo[n][m] = 1 + lengthOfCommonSubsequenceMemoization(a, b, n - 1, m - 1, memo);
			return memo[n][m];
		}
		memo[n][m] = Math.max(lengthOfCommonSubsequenceMemoization(a, b, n - 1, m, memo),
				lengthOfCommonSubsequenceMemoization(a, b, n, m - 1, memo));
		return memo[n][m];
	}

	private static int lengthOfCommonSubsequenceRecursion(String a, String b, int n, int m) {
		//System.out.println("entering");
		if (n == 0 || m == 0) {
			return 0;
		}
		if (a.charAt(n - 1) == b.charAt(m - 1)) {
		return 1 + lengthOfCommonSubsequenceRecursion(a, b, n - 1, m - 1);
		}
	return Math.max(lengthOfCommonSubsequenceRecursion(a, b, n - 1, m),
				lengthOfCommonSubsequenceRecursion(a, b, n, m - 1));
	}
    private static int lengthOfCommonSubsequenceTabulation(String a, String b, int n, int m) {
    	int dp[][] = new int[n+1][m+1];
    	for(int i=0;i<=n;i++) {
    		for(int j=0;j<=m;j++) {
    			if(i==0 || j==0) {
    				dp[i][j] = 0;
    			}else if(a.charAt(i-1)==b.charAt(j-1)) {
    				dp[i][j] = 1+dp[i-1][j-1];
    			}else {
    				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    			}
    		}
    	}
    	return dp[n][m];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "Thequickbrownfoxjumpedoveralazydog";
		String b = "Masiveamountsofcarbonisbeingreleasedintotheatmosphere";
		a ="saturday";
		b="sunday";
		int n = a.length();
		int m = b.length();
		int memo[][] = new int[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				memo[i][j] = -1;
			}
		}
		System.out.println("length of common subsequence: "
				+ lengthOfCommonSubsequenceMemoization(a, b, a.length(), b.length(), memo));
		System.out.println("length of common subsequence: "
				+ lengthOfCommonSubsequenceTabulation(a, b, n, m));
	}

}

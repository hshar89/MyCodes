package com.DynamicProgramming;

//To find out how many operations are required to convert string s1 
//to string s2. Operations allowed are insert, replace, delete
public class EditDistanceInString {
	private static int edRecursion(String a, String b, int n, int m) {
		if (n == 0) {
			return m;
		}
		if (m == 0) {
			return n;
		}
		if (a.charAt(n - 1) == b.charAt(m - 1)) {
			return edRecursion(a, b, n - 1, m - 1);
		}
		// insert - other string length reduces
		// delete - first string length reduces
		// replace - both string become equal at that character, so reduce both
		return 1 + Math.min(Math.min(edRecursion(a, b, n, m - 1), edRecursion(a, b, n - 1, m)),
				edRecursion(a, b, n - 1, m - 1));
	}

	private static int edMemiozation(String a, String b, int n, int m, int memo[][]) {
		if (n == 0) {
			memo[n][m] = m;
			return m;
		}
		if (m == 0) {
			memo[n][m] = n;
			return n;
		}
		if(memo[n][m] != -1) {
			return memo[n][m];
		}
		if (a.charAt(n - 1) == b.charAt(m - 1)) {
			memo[n][m] =  edMemiozation(a, b, n - 1, m - 1,memo);
			return memo[n][m];
		}
		// insert - other string length reduces
		// delete - first string length reduces
		// replace - both string become equal at that character, so reduce both
		memo[n][m] = 1 + Math.min(Math.min(edMemiozation(a, b, n, m - 1, memo), edMemiozation(a, b, n - 1, m, memo)),
				edMemiozation(a, b, n - 1, m - 1, memo));
		return memo[n][m];
	}
    private static int edTabulation(String a, String b, int n, int m) {
    	int dp[][] = new int [n+1][m+1];
    	for(int i=0;i<=n;i++) {
    		for(int j=0;j<=m;j++) {
    			if(i==0) {
    				dp[i][j] = j;
    			}else if(j==0) {
    				dp[i][j] = i;
    			}else if(a.charAt(i-1) == b.charAt(j-1)) {
    				dp[i][j] = dp[i-1][j-1];
    			}else {
    				dp[i][j] = 1+Math.min(Math.min(dp[i][j-1], dp[i-1][j]),dp[i-1][j-1]);
    			}
    			
    		}
    	}
    	return dp[n][m];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "Sunday";
		String b = "Saturday";
		int n = a.length();
		int m = b.length();
		int memo[][] = new int[n+1][m+1];
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				memo[i][j] = -1;
			}
		}
		System.out.println("length through recursion: " + edRecursion(a, b, n, m));
		System.out.println("length through memoization: " + edMemiozation(a, b, n, m,memo));
		System.out.println("length through memoization: " + edTabulation(a, b, n, m));
	}

}

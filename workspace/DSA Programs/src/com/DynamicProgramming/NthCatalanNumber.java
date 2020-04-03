package com.DynamicProgramming;

import java.math.BigInteger;

public class NthCatalanNumber {
	 static long binomialCoeff(int n, int k) { 
	        long res = 1; 
	  
	        // Since C(n, k) = C(n, n-k)  
	        if (k > n - k) { 
	            k = n - k; 
	        } 
	  
	        // Calculate value of [n*(n-1)*---*(n-k+1)] / [k*(k-1)*---*1]  
	        for (int i = 0; i < k; ++i) { 
	            res = (res*(n - i)); 
	            res /= (k-i);//(i + 1); 
	        } 
	  
	        return res; 
	    } 
	// A Binomial coefficient based function to find nth catalan  
	// number in O(n) time  
	    static long catalan(int n) { 
	        // Calculate value of 2nCn  
	        long c = binomialCoeff(2 * n, n); 
	  
	        // return 2nCn/(n+1)  
	        return c / (n + 1); 
	    } 
	  
	private static long getConstant1(int n) {
		long num1 = 4 * n * n + 6 * n + 2;
		return num1;
	}

	private static long getConstant2(int n) {
		long num2 = n * n + 3 * n + 2;
		return num2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 87;
		BigInteger result[] = new BigInteger[n + 1];
		result[0] = new BigInteger("1");
		result[1] = new BigInteger("1");
		result[2] = new BigInteger("2");
		for (int i = 3; i <= n; i++) {
			result[i] = result[i - 1].multiply(BigInteger.valueOf(getConstant1(i - 1)))
					.divide(BigInteger.valueOf(getConstant2(i - 1)));
		}
		long start = System.currentTimeMillis();
		/*System.out.println(result[n].toString());
		System.out.print("time taken1 "+(System.currentTimeMillis()-start));
		start = System.currentTimeMillis();
		System.out.println("\nnth catalan from geeks for geeks "+catalan(n));
		System.out.print("time taken2 "+(System.currentTimeMillis()-start));*/
		System.out.println((895909447%1000000007));
		System.out.println("\nncr "+binomialCoeff(100,34));
	}

}

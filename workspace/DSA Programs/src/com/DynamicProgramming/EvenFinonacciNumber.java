package com.DynamicProgramming;

import java.math.BigInteger;

public class EvenFinonacciNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int n = 100;
	}
	private static BigInteger getFinoacciSumOfEvens(int n){
		BigInteger dp[] = new BigInteger[n+1];
        dp[0] = new BigInteger("0");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("1");
        BigInteger two = new BigInteger("2");
         BigInteger sum = new BigInteger("0");
         for(int i=3;i<=n;i++){
             dp[i] = dp[i-1].add(dp[i-2]);
             if(dp[i].mod(two).equals(BigInteger.ZERO)){
                 sum = sum.add(dp[i]);
                 //System.out.println("sum "+BigInteger.valueOf(dp[i]));
             }
         }
         System.out.println("sum "+sum);
        return sum;
    }
}

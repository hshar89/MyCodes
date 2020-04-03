package com.MathsForProgramming;

public class EuclidsAlgoForGCD {
	 private int x,y,d;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 16;
		int m = 7;
		System.out.println("GCD: " + findGreatestCommonDivisor(n, m));
		System.out.println("GCD Recursive: " + GCDRecursive(n, m));
		
		EuclidsAlgoForGCD eagcd = new EuclidsAlgoForGCD();
		extendedEucledian(n, m,eagcd);
		System.out.println("Extended Euclidean coeficients:");
		System.out.println("x: " + eagcd.x + " " + "y: " + eagcd.y);
		System.out.println("GCD of a and b: " + eagcd.d);
		if (GCDRecursive(n, m) == 1) {
			System.out.println("Finding multiplicative inverse:");
			multiplicativeInverse(n, m,eagcd);
			System.out.println(eagcd.x);
		}

	}

	private static void multiplicativeInverse(int n, int m,EuclidsAlgoForGCD eagcd) {
		// TODO Auto-generated method stub
		extendedEucledian(n, m,eagcd);
		 eagcd.x = (eagcd.x % m + m) % m;

	}

	// The time complexity of the extended Euclidean algorithm is O(log(max(a,b)))
	private static void extendedEucledian(int a, int b,EuclidsAlgoForGCD eagcd) {
		if (b == 0) {
			eagcd.y = 0;
			eagcd.x = 1;
			eagcd.d = a;
		} else {
			extendedEucledian(b, a % b, eagcd);
			int temp = eagcd.x;
			eagcd.x = eagcd.y;
			eagcd.y = temp - (a / b) * eagcd.y;
		}

	}

	// TIme complexity is O(log(max(a,b)))
	private static int findGreatestCommonDivisor(int i, int j) {
		// TODO Auto-generated method stub
		int divisor = i;
		int dividend = j;
		int remainder = 0;
		while (divisor > 0) {
			remainder = dividend % divisor;
			dividend = divisor;
			divisor = remainder;
		}
		return dividend;
	}

	private static int GCDRecursive(int A, int B) {
		if (B == 0)
			return A;
		else
			return GCDRecursive(B, A % B);
	}

}

package com.Backtracking;

class Res {
	static String max = "";
}

public class MaxNumberOfKSwaps {
	// static String max="";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ab[] = { '1', '2', '3', '4', '5', '6', '7' };
		// String abS = String.valueOf(ab);
		int k = 4;
		Res r = new Res();
		r.max = String.valueOf(ab);
		findMaximumNum(ab, k, r);
		System.out.println("max num " + r.max);
	}

	static void swap(char[] ar, int i, int j) {
		char temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}

	static boolean compareAndReplace(char ar[], String maxSoFar) {
		// String beforeSwap = String.valueOf(ar);
		String afterSwap = String.valueOf(ar);
		if (afterSwap.compareTo(maxSoFar) > 0) {
			return true;
		}
		return false;
	}

	static void findMaximumNum(char ar[], int k, Res r) {
		// add your code here
		if (k <= 0) {
			return;
		}

		for (int i = 0; i < ar.length - 1; i++) {
			for (int j = i + 1; j < ar.length; j++) {
				if (ar[i] < ar[j]) {
					swap(ar, i, j);
					if (compareAndReplace(ar, r.max)) {
						r.max = String.valueOf(ar);
					}
					findMaximumNum(ar, k - 1, r);
					swap(ar, i, j);
				}
			}
		}
	}

	static void findMaximumNum2(char ar[], int k, Res r) {
		// add your code here
		if (k <= 0) {
			for (int i = r.max.length(); i < ar.length; i++) {
				r.max += ar[i];
			}
			return;
		}
		int maxI = r.max.length();
		int intialIndex = maxI;
		for (int i = maxI + 1; i < ar.length; i++) {
			if (ar[maxI] < ar[i]) {
				maxI = i;
			}
		}
		char temp = ar[maxI];
		ar[maxI] = ar[intialIndex];
		ar[intialIndex] = temp;
		r.max += temp;
		findMaximumNum(ar, k - 1, r);
	}

}

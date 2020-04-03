package com.RandomMix;

public class KadaneAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ab = "-1 -4 -5 -2 -1";
		String arrS[] = ab.split("\\s");
		int[] arr2 = new int[arrS.length];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = Integer.parseInt(arrS[i]);
		}
		int arr[] = { 10, -3, -4, 7, 6, 5, -4, -1 };
		int arr3[] = {511, -824, 584,568,-309,526};
		System.out.println("max sum " + kadanePart2(arr2, arr2.length));
		System.out.println("Kadane with dp: "+kadaneWithDp(arr3,arr3.length));

	}

	static int kadanePart2(int[] a, int n) {

		// Your code here
		int maxK = kadane(a, n);
		int max_value = 0;
		for (int i = 0; i < n; i++) {
			max_value += a[i];
			a[i] = -a[i];
		}

		max_value = max_value + kadane(a, n);
		if (max_value == 0) {
			return maxK;
		}
		return maxK > max_value ? maxK : max_value;
	}

	static int kadane(int[] arr, int n) {
		int sumM = arr[0], sumg = arr[0];
		for (int i = 1; i < n; i++) {
			sumM = Math.max(arr[i], sumM + arr[i]);
			if (sumM > sumg) {
				sumg = sumM;
			}
		}
		return sumg;
	}
    static int kadaneWithDp(int arr[], int n) {
    	int sum=0;
    	int dp[] = new int[n];
    	dp[0] = arr[0];
    	for(int i=1;i<n;i++) {
    		dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
    		sum = Math.max(sum, dp[i]);
    	}
    	return sum;
    }
	static int circularSubarraySum(int a[], int n) {

		// Your code here
		int sumsg = Integer.MIN_VALUE;
		for (int j = 0; j < n; j++) {
			int sumg = a[j], maxc = a[j];
			int i = j + 1;
			// System.out.println("j "+j);
			while (i != j && i != n) {
				// System.out.println("i "+i);
				maxc = Math.max(a[i], maxc + a[i]);
				if (maxc > sumg) {
					sumg = maxc;
				}
				i++;
				if (i == n) {
					i = 0;
				}
			}
			if (sumg > sumsg) {
				sumsg = sumg;
			}
		}
		return sumsg;
	}
}

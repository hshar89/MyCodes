//This is LIS(Longest Increasing Subsequence)
#include <bits/stdc++.h>
using namespace std;

int longestSubsequence(int n, int arr[]){
		int lis[n];
		lis[0] = 1;
		for(int i=1;i<n;i++){ 
		lis[i] = 1;
		for(int j=0;j<i;j++){
		if(arr[j]<arr[i] && lis[i]<lis[j]+1){
		 lis[i] = lis[j]+1;
		    }
		   }
		 }
	return *max_element(lis,lis+n);	 
}
int callLISRescursion(int arr[], int n){
	int max = 1;
	longestSubsequenceRecursion(n,arr,&max);
	return max;
}
int longestSubsequenceRecursion(int n, int arr[], int *max_ref){
	if(n==1){
		return 1;
	}
	int res, max_ending_here = 1;
	for(int i=1;i<n;i++){
		res = longestSubsequenceRecursion(i,arr,max_ref);
		if(arr[i-1]<arr[n-1] && res+1>max_ending_here){
			max_ending_here = res+1;
		}
	}
	if(*max_ref < max_ending_here){
		*max_ref = max_ending_here;
	}
	return max_ending_here;
}
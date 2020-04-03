#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define MAX 1001
int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t-->0){
	    int n;
	    cin>>n;
	    int deliveryDistancearr[n];
	    int fuelarr[n];
	    int dp[MAX]={0};
	    int temp;
	    int maximum = INT_MIN;
	    for(int i=0;i<n;i++){
	        cin>>temp;
	        deliveryDistancearr[i] = 2*temp;
	        maximum = max(maximum,deliveryDistancearr[i]);
	    }
	     for(int i=0;i<=maximum;i++){
	        dp[i] = INT_MAX;
	    }
	    for(int i=0;i<n;i++){
	        cin>>temp;
	        fuelarr[i] = temp;
	    }
	    dp[0] =0;
	    for(int i=1;i<=maximum;i++){
	        for(int j=0;j<n;j++){
	            if(i>=fuelarr[j] && dp[i-fuelarr[j]]!=INT_MAX && (1+dp[i-fuelarr[j]])<dp[i]){
	                dp[i] = 1+dp[i-fuelarr[j]];
	            }
	        }
	   }
	int tripCount=0;
	for(int i=0;i<n;i++){
	    tripCount+=dp[deliveryDistancearr[i]];
	}
	cout<<tripCount<<endl;
	}
	return 0;
}

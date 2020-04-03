#include<bits/stdc++.h>
using namespace std;
int findMaxAmount(int arr[], int n, int dp[]){
    if(n<=0){
        return 0;
    }
    if(dp[n]){
        return dp[n];
    }
    for(int i=0;i<n;i++){
        dp[n] = max(dp[n],arr[i]+findMaxAmount(arr,n-i-1,dp));
    }
    return dp[n];
}

int main(){
    int arr[]={3,5,8,9,10,17,17,20};
    int n = sizeof(arr)/sizeof(arr[0]);
    int dp[n+1];
    memset(dp,0,sizeof(dp));
    cout<<findMaxAmount(arr,n,dp);
}
#include<bits/stdc++.h>
using namespace std;
int GolombNumber(int n, int dp[]){
    if(n==1){
        return 1;
    }
    if(dp[n]){
        return dp[n];
    }
    dp[n] = 1+GolombNumber(n-GolombNumber(GolombNumber(n-1,dp),dp),dp);
    return dp[n];
}
int GolombNumberTabulation(int n){
    int dp[n+1];
    dp[1] = 1;
    for(int i=2;i<=n;i++){
        dp[i] = 1+dp[i-dp[dp[i-1]]];
    }
    return dp[n];
}
int main(){
    int n = 20;
    int dp[n+1];
    memset(dp,0,sizeof(dp));
    dp[1] = 1;
    cout<<GolombNumber(n,dp);
    cout<<endl;
    cout<<GolombNumberTabulation(n);
}
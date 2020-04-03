#include<bits/stdc++.h>
using namespace std;
int countNaive(int n, int k){
    if(n==0||k==0||k>n){
        return 0;
    }
    if(k==1 || k==n){
        return 1;
    }
    return k*countNaive(n-1,k)+countNaive(n-1,k-1);
}
int countUsingDP(int n, int k){
    int dp[n+1][k+1];
    for(int i=0;i<=n;i++){
        dp[i][0] = 0;
    }
    for(int i=0;i<=k;i++){
        dp[0][k] = 0;
    }
    for(int i=1;i<=n;i++){
        for(int j=1;j<=min(i,k);j++){
            if(j==1 || j==i){
                dp[i][j] =1;
            }else{
                dp[i][j] = j*dp[i-1][j]+dp[i-1][j-1];
            }
        }
    }
    return dp[n][k];
}
int main(){
    cout<<countNaive(3,2);
    cout<<endl;
    cout<<countUsingDP(5,2)<<endl;
}
#include<bits/stdc++.h>
using namespace std;
#define M1 20
#define M2 100
//Find ways to sum upto N 
int find(int n,int dp[]){
    if(n==0){
        return 1;
    }
    if(n<0){
        return 0;
    }
    if(dp[n]!=-1){
        return dp[n];
    }
    int res = 0;
    for(int i=1;i<=n;i++){
        res+=find(n-i,dp);
    }
    return dp[n] = res;
}
int m;
int dp2[M1][M2];
int findMNumbers(int n, int j){
    if(n<0){
        return 0;
    }
    if(n==0 && j==m){
        return 1;
    }
    if(dp2[j][n]){
        return dp2[j][n];
    }
    int res=0;
    for(int i=1;i<=n;i++){
        res+=findMNumbers(n-i,j+1);
    }
    return dp2[j][n] = res;
}
int binomialCoeff(int n, int k){

    int C[n+1][k+1];
    for(int i=0;i<=n;i++){
        C[i][0] = 1;
    }
    for(int i=0;i<=k;i++){
        C[0][i] = 0;
    }
    for(int i=0;i<=n;i++){
        for(int j=0;j<=k;j++){
            if(j==0 || j==i){
                C[i][j] = 1;
            }else{
            C[i][j] = C[i-1][j-1]+C[i-1][j];
            }
        }
    }
    return C[n][k];
}
int waysToRepresentNasSumOfKNums(int n, int m){
    return binomialCoeff(n-1,m-1);
}
int main(){

    int n = 6;
    int dp[n+1];
    memset(dp,-1,sizeof(dp));
    cout<<find(n,dp)<<"\n";
    m = 4;
    n = 7;
    for(int i=0;i<=m;i++){
        for(int j=0;j<=n;j++){
            dp2[i][j] = 0;
        }
    }
    cout<<findMNumbers(n,0)<<"\n";
    cout<<waysToRepresentNasSumOfKNums(n,m)<<"\n";
}
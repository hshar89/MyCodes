#include<bits/stdc++.h>
using namespace std;
int LCS(string a, string b, int n, int m){
    int dp[n+1][m+1];
    for(int i=0;i<=n;i++){
        for(int j=0;j<=m;j++){
            if(i==0 || j==0){
                dp[i][j] = 0;
            }else if(a[i-1]==b[j-1]){
                dp[i][j] = 1+dp[i-1][j-1];
            }else{
                dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
            }
        }
    }
    return dp[n][m];
}
int LCSSpaceOptimized(string a, string b, int m, int n){
    int dp[2][n+1];
    bool bin;
    for(int i=0;i<=m;i++){
        bin = i&1;
        for(int j=0;j<=n;j++){
            if(i==0 || j==0){
                dp[bin][j] = 0;
            }else if(a[i-1]==b[j-1]){
                dp[bin][j] = 1+dp[1-bin][j-1];
            }else{
                dp[bin][j] = max(dp[1-bin][j],dp[bin][j-1]);
            }
        }
    }
    cout<<"checking the matrix\n";
    for(int i=0;i<2;i++){
        for(int j=0;j<=n;j++){
            cout<<dp[i][j]<<" ";
        }
        cout<<endl;
    }
    return dp[bin][n];
}
int main(){
    string a = "AGGTABRETYBB";
    string b = "GXTXAYB";
    cout<<LCS(a,b,a.length(),b.length())<<endl;
    cout<<LCSSpaceOptimized(a,b,a.length(),b.length())<<"\n";
}
#include<bits/stdc++.h>
using namespace std;
int bellNumber(int n){
    int dp[n+1][n+1];
    dp[0][0] = 1;
    for(int i=1;i<=n;i++){
        dp[i][0] = dp[i-1][i-1];
        for(int j=1;j<=i;j++){
                dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
        }
    }
    return dp[n][0];
}
int main(){
    for (int n=0; n<=5; n++) 
      cout << "Bell Number " << n << " is " 
           << bellNumber(n) << endl; 

    return 0;
}
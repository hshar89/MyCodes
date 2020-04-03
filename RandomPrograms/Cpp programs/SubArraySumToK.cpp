#include<bits/stdc++.h>
using namespace std;
bool isPossible(int arr[], int n, int sum){
    int dp[2][sum+1];
    for(int i=0;i<=n;i++){
        for(int j=0;j<=sum;j++){
            if(j==0){
                dp[i%2][j] = 1;
            }else if(i==0){
                dp[i%2][j] = 0;
            }else if(arr[i-1]<=j){
                dp[i%2][j] = dp[(i+1)%2][j] || dp[(i+1)%2][j-arr[i-1]];
            }else{
                dp[i%2][j] = dp[(i+1)%2][j];
            }
        }
    }
    return dp[1][sum];
}
int main(){
    int arr[]={2,5,9,34,7,8,30};
    int n = sizeof(arr)/sizeof(arr[0]);
    int sum = 203;
    if(isPossible(arr,n,sum)){
        cout<<"Yes sub array exit with given sum\n";
    }else{
        cout<<"No\n";
    }
    return 0;
}
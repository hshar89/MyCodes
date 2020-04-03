#include<bits/stdc++.h>
using namespace std;
//This is an Ologn Algorithm to find maximum subarray sum
//A better approach is using kadane's algo
int findMaxSubArraySum(int arr[],int n){
    if(n==1){
        return arr[0];
    }
    int m = n/2;
    int left_MSS = findMaxSubArraySum(arr,m);
    int right_MSS = findMaxSubArraySum(arr+m,n-m);
    int sum=0;
    int left = INT_MIN;
    int right = INT_MIN;

    for(int i=m;i<n;i++){
        sum+=arr[i];
        left = max(left,sum);
    }
    sum = 0;
    for(int i=m-1;i>=0;i--){
        sum+=arr[i];
        right = max(right,sum);
    }
    return max(left_MSS,max(left_MSS,left+right));
}
int main(){
    int arr[]={1,-3,2,-5,7,6,-1,-4,11,-23};
    int n = sizeof(arr)/sizeof(arr[0]);
    cout<<findMaxSubArraySum(arr,n);
}
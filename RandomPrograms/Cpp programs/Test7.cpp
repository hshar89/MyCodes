#include<bits/stdc++.h>
using namespace std;
int findSmallestNum(int arr[], int n, int s){
    int maxi=INT_MIN;
    for(int i=0;i<n;i++){
        maxi = max(maxi,arr[i]);
    }
    int low = 1,high = maxi+1;
    int res = high;
    while(low<=high){
        int mid = (low+high)/2;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        sum/=mid;
        if(sum>s){
            low = mid+1;
        }else{
            res = min(res,mid);
            high = mid-1;
        }
    }
    return res;
}
int fib1(int n){
    if(n==0 || n==1){
        return n;
    }
    return fib1(n-1)+fib1(n-2);
}
long long int fib2(int n){
    long long int result = 0;
    long long int a = 0;
    long long int b = 1;
    for(int i=1;i<=n;i++){
        result = a+b;
        a = b;
        b = result;
    }
    return result;
}
int main(){
    int arr[]={4,9,35,19,32,124,21,56};
    int n = 8;
    int s = 58;
    cout<<findSmallestNum(arr,n,s)<<"\n";
    int arr2[]= {10, 7, 8, 10, 12, 19};
    n= sizeof(arr2)/sizeof(arr2[0]);
    s = 27;
    cout<<findSmallestNum(arr2,n,s)<<"\n";
    cout<<(1<<0)<<"\n";
    cout<<fib2(50)<<"\n";
}
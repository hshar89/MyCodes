#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MAX 1000
ll gcd(ll a, ll b){
    while(b>0){
        int rem = a%b;
        a = b;
        b = rem;
    }
    return a;
}
ll findLCM(int arr[], int n){
    ll ans = arr[0];
    for(int i=1;i<n;i++){
        ans = (ans*arr[i])/gcd(ans,arr[i]);
    }
    return ans;
}
int main(){
    cout<<"entered"<<"\n";
    int arr[] = {4,99,2,44,8,20};
    cout<<findLCM(arr,6)<<"\n";
    return 0;
}
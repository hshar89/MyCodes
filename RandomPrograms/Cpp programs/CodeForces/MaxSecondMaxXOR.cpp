#include <iostream>
#include <stack>
#include <bits/stdc++.h>
using namespace std;

int main(){
    int t;
    cin>>t;
    while(t-->0){
    int n;
    cin>>n;
    long long arr[n];
    int temp;
    for(int i=0;i<n;i++){
        cin>>temp;
        arr[i] = temp;
    }
    long long luckyNumber = INT_MIN;
    stack<int> st;
    st.push(0);
    for(int i=1;i<n;i++){
     while(!st.empty() && arr[st.top()]<arr[i]){
         luckyNumber = max(luckyNumber,(arr[st.top()]^arr[i]));
         st.pop();
     }
     if(!st.empty()){
     luckyNumber = max(luckyNumber,arr[st.top()]^arr[i]);
     }
     st.push(i);
    }
    cout<<luckyNumber<<endl;
    }
}
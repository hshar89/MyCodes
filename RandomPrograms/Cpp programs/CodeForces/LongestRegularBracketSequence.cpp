#include <iostream>
#include <stack>
#include <bits/stdc++.h>
using namespace std;

int main(){
    while(true){
      string s;
      cin>>s;
      if(s.find('#')!=string::npos){
          break;
      }
      stack<int> st;
      int n= s.length();
      int count =1;
      int maxlength = 0;
      int i=0;
      int arr[n];
      memset(arr,0,sizeof(arr));
      while(i<n){
          if(s[i]==')' && !st.empty()){
              arr[st.top()] = 1;
              st.pop();
              arr[i] = 1;
          }else if(s[i]=='('){
              st.push(i);
          }
          i++;
      }
      i = 0;
      while(i<n){
          if(arr[i]  == 1){
              int len = 0;
              while(i<n && arr[i]){
                  len++;
                  i++;
              }
              if(len == maxlength){
                  count++;
              }
              if(len>maxlength){
                  maxlength = len;
                  count = 1;
              }
          }
          i++;
      }
      cout<<maxlength<<" "<<count<<endl;
    }
}
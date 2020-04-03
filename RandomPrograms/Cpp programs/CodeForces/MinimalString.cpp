#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main(){
    int t;
    cin>>t;
    while(t-->0){
      string s;
      cin>>s;
      stack<int> st;
      int n = s.length();
      int arr[n];
      arr[n-1] = (s[n-1]-'a');
      for(int i=n-2;i>=0;i--){
              arr[i] = min(arr[i+1],s[i]-'a');
      }
      vector<int> ans;
      for(int i=0;i<n;i++){
          int curr = s[i]-'a';
          while(!st.empty() && st.top()<=arr[i]){
              ans.push_back(st.top());
              st.pop();
          }
          if(st.empty() || (!st.empty() && st.top()>arr[i])){
              st.push(curr);
          }
      }
      while(!st.empty()){
          ans.push_back(st.top());
          st.pop();
      }
      for(int el: ans){
          cout<<char(el+'a');
      }
      cout<<endl;
    }
}
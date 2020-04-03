#include <iostream>
#include <bits/stdc++.h>
#include <cstdlib> 
using namespace std;

int main() {
	//code
	int t;
	cin>>t;
	while(t-->0){
	    string str;
	    cin>>str;
	    int n = str.length();
	    char ab[n+1];
	    strcpy(ab,str.c_str());
	    int i,j;
	    
	   for(i=n-1;i>0;i--){
	      if(ab[i-1]<ab[i]){
	          break;
	      }
	   }
	    if(i==0){
	        cout<<"not possible"<<endl;
	    }else{
	        int smallest = i;
	        for(int j=i+1;j<n;j++){
	            if(ab[j]>ab[i-1]&& ab[j]<ab[smallest]){
	                smallest = j;
	            }
	        }
	        swap(ab[smallest],ab[i-1]);
	        sort(ab+i,ab+n);
	        cout<<ab<<endl;
	    }
	}
	return 0;
}
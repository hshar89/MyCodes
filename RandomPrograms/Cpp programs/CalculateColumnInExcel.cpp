#include <iostream>
#include <bits/stdc++.h>
#define MAX 50
using namespace std;

void calculateColumn(long long n){
    char str[MAX];
    int j=0;
    while(n>0){
        int rem = n%26;
        if(rem ==0){
            str[j++]='Z';
            n = (n/26)-1;
        }else{
            str[j++] = (rem-1)+'A';
            n=n/26;
        }
    }
    str[j] = '\0';
    reverse(str, str + strlen(str));
    cout<<str;
   // return convertToString(str,size);
}
int main() {
	//code
	int t;
	cin>>t;
	//static string abc="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	while(t-->0){
	    long long n;
	    cin>>n;
	    calculateColumn(n);
	    cout<<endl;
	}
	return 0;
}
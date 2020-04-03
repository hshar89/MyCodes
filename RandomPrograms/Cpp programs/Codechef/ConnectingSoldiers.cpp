#include <iostream>
#include <bits/stdc++.h>
using namespace std;
void findUsedLength(int l,int r, int &usedlen, bool arr[], int n){
    if(l<=r){
        //cout<<"l: "<<l<<" ";
        //cout<<"r: "<<r<<" ";
    int mid  = (l+r)/2;
    if(arr[mid]){
        return;
    }
    arr[mid] = true;
    //cout<<"mid: "<<mid<<" ";
    int i = mid-1;
    int j = mid+1;
    while(i>=l){
        if(arr[i]){
            break;
        }
        i--;
    }
    while(j<=r){
        if(arr[j]){
            break;
        }
        j++;
    }
    //cout<<"i: "<<i<<" ";
    //cout<<"j: "<<j<<" ";
    int len=0;
    len+=(i<=0)?mid-0:mid-i;
    len+=(j>n)?(n+1)-mid:j-mid;
    //cout<<"len: "<<len<<" ";
    usedlen+=len;
    //cout<<"usedlen: "<<usedlen<<" ";
    findUsedLength(mid+1,r,usedlen,arr,n);
    findUsedLength(l,mid-1,usedlen,arr,n);
    }
}
int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t-->0){
	    int n,m;
	    cin>>n>>m;
	    int maxlengthpossible = ((n+1)*(n+2)/2)-1;
	    if(m>=maxlengthpossible){
	        cout<<(m-maxlengthpossible)<<endl;
	        continue;
	    }
	    int usedlen = 0;
	    bool arr[n+1];
	    memset(arr,0,sizeof(arr));
	    findUsedLength(1,n,usedlen,arr,n);
	    //cout<<"usedlen: "<<usedlen<<" ";
	    int minLength = m-usedlen;
	    if(minLength>=0){
	        cout<<0<<endl;
	    }else{
	        cout<<"-1"<<endl;
	    }
	}
	return 0;
}

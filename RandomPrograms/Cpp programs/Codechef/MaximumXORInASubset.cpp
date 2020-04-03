#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define MAX_BIT 32
#define MAX 1001
//For finding the maximum subset XOR value in a given array
int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t-->0){
	    int n,k;
	    scanf("%d%d",&n,&k);
	    int arr[n];
	    int hash[MAX];
	    memset(hash,0,sizeof(hash));
	    int dp[n];
	    int temp;
	    int maxXor = 0;
	    int l=0;
	    for(int i=0;i<n;i++){
	        scanf("%i",&temp);
	        if(hash[temp]==0){
	        arr[l++] = temp;
	        hash[temp] = 1;
	        }
	    }
	    n=l;
	    int max_ele;
	    int maxIndex;
	    int index = 0;
	    for(int i=MAX_BIT-1;i>=0;i--){
	        max_ele = INT_MIN;
	        maxIndex = index;
	        for(int j=index;j<n;j++){
	            if((arr[j]&(1<<i))!=0 && arr[j]>max_ele){
	                max_ele = arr[j];
	                maxIndex = j;
	            }
	        }
	        if(max_ele==INT_MIN){
	            continue;
	        }
	        swap(arr[index],arr[maxIndex]);
	        maxIndex = index;
	        
	        for(int j=0;j<n;j++){
	            if(j!=maxIndex && (arr[j]&(1<<i))!=0){
	                arr[j] = max_ele^arr[j];
	            }
	        }
	        index++;
	    }
	    for(int i=0;i<n;i++){
	        maxXor = maxXor^arr[i];
	    }
	    cout<<maxXor<<"\n";
	}
	return 0;
}

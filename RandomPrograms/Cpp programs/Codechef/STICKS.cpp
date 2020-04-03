#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define MAX 1001
int main() {
	// your code goes here
	ios_base::sync_with_stdio(false); 
    cin.tie(NULL);
    int t;
    cin>>t;
    while(t-->0){
        int n;
        cin>>n;
        //cout<<"n: "<<n<<" ";
        int count[1001];
        memset(count,0,sizeof(count));
        int arr[n];
        int temp;
        for(int i=0;i<n;i++){
            cin>>arr[i];
            count[arr[i]]++;
        }

        for(int i=1;i<MAX;i++){
            count[i]+=count[i-1];
        }
        int maximum=0, secondmax = 0;
        int output[n];
        for(int i=0;i<n;i++){
            output[count[arr[i]]-1]=arr[i];
            count[arr[i]]--;
        }
        /*for(int i=0;i<n;i++){
            cout<<arr[i]<<" ";
        }*/
        int i=n-1;
       while(i>0){
            if(output[i]==output[i-1]){
                if(maximum==0){
                    maximum = output[i];
                }else if(secondmax ==0){
                    secondmax = output[i];
                }
                i=i-2;
            }else{
                i--;
            }
        }
        
        if(maximum==0 || secondmax == 0){
            cout<<"-1"<<"\n";
            continue;
        }
        cout<<(maximum*secondmax)<<"\n";
    }
	return 0;
}

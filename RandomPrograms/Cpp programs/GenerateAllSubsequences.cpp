#include<bits/stdc++.h>
using namespace std;
void find(int arr[], int l, int s){
  for(int i=0;i<(pow(2,l));i++){
     int sum =0;
     for(int j=0;j<l;j++){
         if((i>>j)&1){
             sum+=arr[j];
         }
          // if the sum is equal to given sum print yes
        if (sum == s) {
            cout << "YES" << endl;
            return;
     }
  }
  }
    // else print no
    cout << "NO" << endl;
}
void findAllSubsequences(int arr[] , int n){
    int power = (int)pow(2,n);
    for(int i=1;i<power;i++){
        cout<<"counter: "<<i<<" ";
        for(int j=0;j<n;j++){
            if(i & (1<<j)){
                cout<<arr[j]<<" ";
            }
        }
        cout<<"\n";
    }
}
int main(){
  int sum = 5;
  int arr[] = {-1,2,4,121};
  int l = sizeof(arr)/sizeof(int);
  find(arr,l,sum);
  int arr2[] = {1,2,3,4,5};
  l = sizeof(arr2)/sizeof(int);
  findAllSubsequences(arr2,l);
}
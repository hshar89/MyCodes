#include<bits/stdc++.h>
using namespace std;
int subCount(int arr[], int n,int k){
    int sum=0;
    int mod[k];
    memset(mod,0,sizeof(mod));
    // Traverse original array and compute cumulative 
    // sum take remainder of this current cumulative 
    // sum and increase count by 1 for this remainder 
    // in mod[] array 
    for(int i=0;i<n;i++){
      sum+=arr[i];
      // as the sum can be negative, taking modulo twice 
      mod[((sum%k)+k)%k]++;
    }
    int result = 0;
    // Traverse mod[] 
    for(int i=0;i<k;i++){
       // If there are more than one prefix subarrays 
        // with a particular mod value. 
      if(mod[i]>1){
        result += (mod[i]*(mod[i]-1))/2;
      }
    }
    // add the elements which are divisible by k itself 
    // i.e., the elements whose sum = 0 
    result+=mod[0];
    return result;
}
int main(){
   int arr[] = { 4, 5, 0, -2, -3, 1 }; 
    int k = 5; 
    int n = sizeof(arr) / sizeof(arr[0]); 
    cout << subCount(arr, n, k) << endl; 
    int arr1[] = { 4, 5, 0, -12, -23, 1 }; 
    int k1 = 5; 
    int n1 = sizeof(arr1) / sizeof(arr1[0]); 
    cout << subCount(arr1, n1, k1) << endl; 
}
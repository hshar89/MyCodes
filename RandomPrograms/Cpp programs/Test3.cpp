#include<iostream>
#include<algorithm>
#include<utility>
#include<time.h>
#include<random>
#include<string.h>
using namespace std;
int lengthOfLongestIncreasingSubsequence(int arr[], int n){
    int dp[n];
    int maximum=0;
    dp[0] = 1;
    for(int i=1;i<n;i++){
        dp[i] = 1;
        for(int j=0;j<i;j++){
          if(arr[j]<arr[i]){
              dp[i] = max(dp[j]+1,dp[i]);
          }
        }
        maximum = max(maximum,dp[i]);
    }
    return maximum;
}
void generateRandomNumbersRand(int n){
   srand(time(0));
    for(int i=0;i<n;i++){
        cout<<rand()<<" ";
    }
}
int generateRandomNumbersInGivenRange(int l, int h){
  random_device dev;
  mt19937 rng(dev());
  uniform_int_distribution<mt19937::result_type> dist6(l,h);
  return dist6(rng);
}
void assignRandomNumbersToArray(int arr[], int n){
    for(int i=0;i<n;i++){
      arr[i] = generateRandomNumbersInGivenRange(-10,200);
  }
}
void printArray(int arr[], int n){
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
}
int binarySearchForCeil(int arr[], int t[], int l, int h,int x){
    int mid;
    int end = h;
    while(l<=h){
        mid = (l+h)/2;
        if(mid<end && arr[t[mid]]<x && arr[t[mid+1]]>=x){
            return mid+1;
        }else if(arr[t[mid]]<x){
            l = mid+1;
        }else{
            h= mid-1;
        }
    }
    return -1;
}
int binarySearchCeil(int arr[], int l, int h,int x){
    if(l<=h){
    if(l==h && arr[l]>x){
        return l;
    }
    int mid = (l+h)/2;
    if(arr[mid]<=x){
        return binarySearchCeil(arr,mid+1,h,x);
    }
    if(arr[mid]>x){
        return binarySearchCeil(arr,l,mid-1,x);
    }
    }
    return -1;
}
int LISinLogNTime(int arr[], int n){
    int t[n];
    int r[n];
    memset(r,-1,sizeof(r));
    t[0] = 0;
    int len = 0;
    //int j=0;
    for(int i=1;i<n;i++){
        //cout<<"i: "<<i<<" ";
        //cout<<"j "<<j<<" ";
        if(arr[t[0]]>arr[i]){
            t[0] = i;
        }else if(arr[i]>arr[t[len]]){
           t[++len] = i;
           //cout<<"len: "<<len<<" ";
           r[t[len]] = t[len-1];
       }else{
           int ceil = binarySearchForCeil(arr,t,0,len,arr[i]);
           cout<<"ceil: "<<ceil<<"\n";
           t[ceil] = i;
           r[t[ceil]] = t[ceil-1];
       }
      // cout<<"\n";
    }
    return len+1;
}
int main(){
    int n = 30;
   //generateRandomNumbersRand(n);
   //cout<<endl;
   int arr[n];
   assignRandomNumbersToArray(arr,n);
   printArray(arr,n);
   cout<<endl;
   cout<<lengthOfLongestIncreasingSubsequence(arr,n);
   cout<<endl;
   //sort(arr,arr+n);
   //printArray(arr,n);
   //cout<<endl;
   //cout<<binarySearchCeil(arr,0,n-1,400);
   //int arr2[] = {3,4,-1,5,8,2,3,12,7,9,10};
   cout<<LISinLogNTime(arr,n);
}
#include<bits/stdc++.h>
using namespace std;
struct node{
    int val,pos;
    bool operator <(const node& n1)const{
        return val<n1.val;
    }
};
int getSum(int bt[], int index){
    int sum = 0;
    while(index>0){
        sum+=bt[index];
        index-=(index)&(-index);
    }
    return sum;
}
void updateTree(int bt[], int index, int val, int n){
    while(index<=n){
        bt[index]+=val;
        index+=(index)&(-index);
    }
}
int main(){
    int arr[] = {-1, 8, 0, -8, 9, 4, -8, -7, -4, -8};
    int n = sizeof(arr)/sizeof(arr[0]);
    node tmparr[n];
    for(int i=0;i<n;i++){
        tmparr[i].val = arr[i];
        tmparr[i].pos = i;
    }  
    sort(tmparr,tmparr+n);
    for(int i=0;i<n;i++){
        arr[tmparr[i].pos] = i+1;
    }
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
    int bt[n+1];
    for(int i=0;i<=n;i++){
        bt[i] = 0;
    }
    int count =0 ;
    for(int i=n-1;i>=0;i--){
        count+=getSum(bt,arr[i]-1);
        updateTree(bt,arr[i],1,n);
    }
    cout<<"\ncount: "<<count<<" ";
}
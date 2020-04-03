#include<bits/stdc++.h>
using namespace std;
#define M 1000
int tree[4*M] ={0};
int lazy[4*M]= {0};
int createTree(int ss, int se,int arr[], int si){
    if(ss == se){
        tree[si] = arr[ss];
        return tree[si];
    }
    int mid = ss+se>>1;
    tree[si] = max(createTree(ss,mid,arr,2*si+1),createTree(mid+1,se,arr,2*si+2));
    return tree[si];
}
void updateTree(int ss, int se, int x, int y, int diff,int si){
    if(lazy[si]!=0){
        tree[si] += lazy[si];
        if(ss!=se){
            lazy[2*si+1] += lazy[si];
            lazy[2*si+2] += lazy[si];
        }
        lazy[si] = 0;
    }
    if(x>se || y<ss){
        return;
    }
    if(x<=ss && y>=se){
       tree[si] += diff;
       if(ss!=se){
           lazy[2*si+1] += diff;
           lazy[2*si+2] += diff;
       } 
     return;
    }
    int mid = ss+se>>1;
    updateTree(ss,mid,x,y,diff,2*si+1);
    updateTree(mid+1,se,x,y,diff,2*si+2);
    tree[si] = max(tree[2*si+1],tree[2*si+2]);
}
int getMax(int ss, int se, int x, int y, int si){
    if(lazy[si]!=0){
        tree[si] += lazy[si];
        if(ss!=se){
            lazy[2*si+1] += lazy[si];
            lazy[2*si+2] +=lazy[si];
        }
        lazy[si] = 0;
    }
    if(x>se || y<ss){
        return INT_MIN;
    }
    if(x<=ss && y>=se){
        return tree[si];
    }
    int mid = ss+se>>1;
    return max(getMax(ss,mid,x,y,2*si+1),getMax(mid+1,se,x,y,2*si+2));
}
int main(){
    int arr[] = {3,-2,1,9,-4,-6,-7,6,13};
    int n = sizeof(arr)/sizeof(arr[0]);
    createTree(0,n-1,arr,0);
    cout<<"maximum between 2-5 "<<getMax(0,n-1,2,5,0)<<"\n";
    updateTree(0,n-1,1,5,12,0);
    cout<<"maximum after update 1-5 "<<getMax(0,n-1,1,5,0)<<"\n";

}
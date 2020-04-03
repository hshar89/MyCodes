#include<bits/stdc++.h>
using namespace std;
#define M 1000
int tree[4*M];
int lazy[4*M];
int createTree(int ss, int se, int arr[], int si){
  if(ss == se){
      tree[si] = arr[ss];
      return arr[ss]; 
  }
  int mid = ss+se>>1;
  tree[si] = createTree(ss,mid,arr,2*si+1)+createTree(mid+1,se,arr,2*si+2);
  return tree[si];
}
int getSum(int ss, int se, int x, int y, int si){
   if(lazy[si]){
       tree[si] += (se-ss+1)*lazy[si];
       if(ss!=se){
           tree[2*si+1] += lazy[si];
           tree[2*si+2] +=lazy[si];
       }
       lazy[si]=0;
   }
   if(x>se || y<ss){
       return 0;
   }
   if(x<=ss && y>=se){
       return tree[si];
   }
    int mid = ss+se>>1;
    return getSum(ss,mid,x,y,2*si+1)+getSum(mid+1,se,x,y,2*si+2);
}
void updateRange(int ss, int se, int x, int y,int si, int diff){
    if(lazy[si]){
        tree[si] += (se-ss+1)*lazy[si];
        if(ss !=se ){
            lazy[2*si+1] += lazy[si];
            lazy[2*si+2] +=lazy[si];
        }
        lazy[si] = 0;
    }
    if(x>se || y<ss){
        return;
    }
    if(x<=ss && y>=se){
        tree[si] += (se-ss+1)*diff;
        if(ss!=se){
            lazy[2*si+1] +=diff;
            lazy[2*si+2] +=diff;
        }
        return;
    }
    int mid = ss+se>>1;
    updateRange(ss,mid,x,y,2*si+1,diff);
    updateRange(mid+1,se,x,y,2*si+2,diff);
    tree[si] = tree[2*si+1]+tree[2*si+2];
}
int main(){
    int arr[] = {1,3,-4,9,11,6};
    int n = sizeof(arr)/sizeof(arr[0]);
    createTree(0,n-1,arr,0);
     // Print sum of values in array from index 1 to 3 
    printf("Sum of values in given range = %d\n", 
           getSum(0,n-1, 0, 2,0)); 
  
    // Add 10 to all nodes at indexes from 1 to 5. 
    updateRange(0,n-1, 0, 4, 0,10); 
  
    // Find sum after the value is updated 
    printf("Updated sum of values in given range = %d\n", 
            getSum( 0,n-1, 0, 2,0)); 
}
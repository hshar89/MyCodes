#include<bits/stdc++.h>
using namespace std;
/* A recursive function to get the sum of values in given range  
    of the array. The following are parameters for this function.  
  
    st --> Pointer to segment tree  
    si --> Index of current node in the segment tree. Initially  
            0 is passed as root is always at index 0  
    ss & se --> Starting and ending indexes of the segment represented  
                by current node, i.e., st[si]  
    qs & qe --> Starting and ending indexes of query range */
int getSumUtil(int *st, int ss, int se, int qs, int qe, int si){

    if(qs<=ss && qe>=se){
        return st[si];
    }
    if(se<qs || ss>qe){
        return 0;
    }
    int mid = ss + (se-ss)/2;
    return getSumUtil(st,ss,mid,qs,qe,2*si+1)+getSumUtil(st,mid+1,se,qs,qe,2*si+2);
}
int getSum(int *st, int n, int qs, int qe){
    if(qs<0 || qe>n-1 || qs>qe){
        cout<<"Invalid Input\n";
        return -1;
    }
   
   return getSumUtil(st,0,n-1,qs,qe,0);
}
// A recursive function that constructs Segment Tree for array[ss..se].  
// si is index of current node in segment tree st  
int constructStUtil(int arr[], int ss, int se, int *st, int si){
    if(ss ==se){
        st[si] = arr[ss];
        return arr[ss];
    }
    int mid = ss+(se-ss)/2;
    st[si] = constructStUtil(arr,ss,mid,st,si*2+1)+constructStUtil(arr,mid+1,se,st,si*2+2);

    return st[si];
}
/* Function to construct segment tree from given array. This function  
allocates memory for segment tree and calls constructSTUtil() to  
fill the allocated memory */
int* constructSt(int arr[], int n){
 
 //Height of the segment tree
 int x = (int) ceil((log2(n)));
 //maximum size of segment tree
 int max_size = 2*(int)pow(2,x)-1;
 int *st = new int[max_size];

 constructStUtil(arr,0,n-1,st,0);

 return st;
}
void updateValueUtil(int *st, int ss, int se, int i, int diff, int si){
    if(i<ss || i>se){
        return;
    }
    st[si] = st[si]+diff;
    if(se!=ss){
        int mid = ss +(se-ss)/2;
        updateValueUtil(st,ss,mid,i,diff,2*si+1);
        updateValueUtil(st,mid+1,se,i,diff,2*si+2);
    }
}
void updateValue(int arr[], int *st, int n, int i, int new_val){
    if(i<0 || i>n-1){
        cout<<"Invalid Input\n";
        return;
    }
    int diff = new_val - arr[i];
    arr[i] = new_val;
    updateValueUtil(st,0,n-1,i,diff,0);
}
int main(){
    int arr[] = {1,3,4,5,7,9,11};
    int n = sizeof(arr)/sizeof(arr[0]);
    int *st = constructSt(arr,n);
    // Print sum of values in array from index 1 to 3  
    cout<<"Sum of values in given range = "<<getSum(st, n, 1, 3)<<endl;  
  
    // Update: set arr[1] = 10 and update corresponding  
    // segment tree nodes  
    updateValue(arr, st, n, 1, 10);  
  
    // Find sum after the value is updated  
    cout<<"Updated sum of values in given range = "
            <<getSum(st, n, 1, 3)<<endl;  
    int max_size = 2*(int)pow(2,(int)ceil(log2(n)))-1;
    for(int i=0;i<max_size;i++){
        cout<<st[i]<<"\n";
    }
    return 0;  
}
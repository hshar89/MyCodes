#include<bits/stdc++.h>
using namespace std;
void updateBitTree(int *bitTree, int n, int index,int value){
    index = index+1;
    while(index<=n){
        bitTree[index] += value;
        index += index &(-index);
    }

}
int* constructTree(int arr[], int n){
    int *bitTree = new int[n+1];
    for(int i=0;i<=n;i++){
      bitTree[i] = 0;
    }
 for(int i=0;i<n;i++){
     updateBitTree(bitTree,n,i,arr[i]);
 }
 return bitTree;
}
int getSum(int *bitTree, int index){
    
    index = index+1;
    int result = 0;
    while(index>0){
        result += bitTree[index];
        index -= (index)&(-index);
    }
    return result;
}
int main(){
    int freq[] = {2,1,1,3,2,3,4,5,6,7,8,9};
    int n = sizeof(freq)/sizeof(freq[0]);
    int *bitTree = constructTree(freq,n);

    cout << "Sum of elements in arr[0..5] is "
        << getSum(bitTree, 5); 
    cout<<"\nsum in range 2 - 8 "<<(getSum(bitTree,8) - getSum(bitTree,1));
    // Let use test the update operation 
    freq[3] += 6; 
    updateBitTree(bitTree, n, 3, 6); //Update BIT for above change in arr[] 
  
    cout << "\nSum of elements in arr[0..5] after update is "
        << getSum(bitTree, 5); 
        return 0;
}
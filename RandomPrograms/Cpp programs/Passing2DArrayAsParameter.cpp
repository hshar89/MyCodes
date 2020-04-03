#include<iostream>
using namespace std;
void printArr(int *arr, int m, int n){
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            cout<<*((arr+i*n)+j)<<" ";
        }
        cout<<endl;
    }
}
int main(){
    int m=3,n=2;
    int counter = 0;
    int arr[m][n];
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            arr[i][j] = ++counter; 
        }
    }
    printArr(&arr[0][0], m,n);

    int *p = new int(25);
    cout<<*p<<" ";
}
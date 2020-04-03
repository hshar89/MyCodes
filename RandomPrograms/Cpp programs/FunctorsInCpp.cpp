#include<bits/stdc++.h>
using namespace std;
int increment1(int x){
 return x+1;
}
class increment{
    int num;
    public:
    increment(int num_):num(num_){}
    int operator()(int num_add)const{
        return num+num_add;
    }
};
int main(){
    int arr[6] = {4,2,9,53,13,1};
    int n = sizeof(arr)/sizeof(n);

    transform(arr,arr+n,arr,increment1);
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
    cout<<"\n";
    int num_add = 5;
    transform(arr,arr+n,arr,increment(num_add));

    for (int i=0; i<n; i++) 
        cout << arr[i] << " ";
}
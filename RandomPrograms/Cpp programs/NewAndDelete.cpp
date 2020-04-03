#include<iostream>
using namespace std;
int main(){
    int *p = NULL;

    p = new int;
    if(!p){
        cout<<"Allocation failed!!\n";
    }else{
        *p = 29;
        cout<<"Value of p: "<<*p<<endl;
    }
    float *r = new float(29.9);
    cout << "Value of r: " << *r << endl;
    
    int n = 5;
    int *q = new int[n];
    for(int i=0;i<n;i++){
        q[i] = i+1;
    }
    cout<<"Value store in a block of memory: "<<endl;
    for (int i = 0; i < n; i++)
            cout << q[i] << " ";
    cout<<endl;
    delete p;
    delete r;
    delete[] q;
    return 0;

}
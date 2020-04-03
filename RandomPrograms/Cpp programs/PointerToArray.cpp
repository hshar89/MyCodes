#include<iostream>
using namespace std;
int main(){
    int *p;
    // Pointer to an array of 5 integers
    int (*ptr)[5];
    int arr[5]={1,2,3,4,5};
    // Points to 0th element of the arr.
    p = &arr[0];

    // Points to the whole array arr.
    ptr = &arr;
    cout<<"p: "<<p<<" ptr "<<ptr<<endl;
    cout<<"*p: "<<*p<<endl;
    cout<<"*ptr: "<<*ptr<<endl;
    p++;
    ptr++;
    cout<<"p: "<<p<<" ptr: "<<ptr<<endl;

    printf("sizeof(p) = %lu, sizeof(*p) = %lu\n",
                          sizeof(p), sizeof(*p));
    printf("sizeof(ptr) = %lu, sizeof(*ptr) = %lu\n", 
                        sizeof(ptr), sizeof(*ptr));
    return 0;

}
#include<iostream>
using namespace std;
void increase(void *data, int ptrSize){
    if(ptrSize==sizeof(char)){
        char *ptrchar;
        ptrchar = (char*)data;
        (*ptrchar)++;
        cout<<"data points to a char"<<*ptrchar<<"\n";
    }else if(ptrSize == sizeof(int)){
        int *ptrint;
        ptrint = (int*) data;
        (*ptrint)++;
        cout<<"data points to int"<<*ptrint<<"\n";
    }
}
int main(){
    char c='x';
    int i=10;
    increase(&c,sizeof(char));
    cout << "The new value of c is: " << c <<"\n";
    increase(&i,sizeof(i));
    cout << "The new value of i is: " << i <<"\n";
}
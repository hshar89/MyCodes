#include<bits/stdc++.h>
#define MAX 100000
using namespace std;
int power(int a, int b){
    int res=1;
    while(b>0){
        if(b & 1){
            res=(res*a)%MAX;
        }
        a = (a*a)%MAX;
        b=b>>1;
    }
    return res;
}
int main(){
    int a = 8;
    int b = 12;
    cout<<power(a,b)<<"\n";
}
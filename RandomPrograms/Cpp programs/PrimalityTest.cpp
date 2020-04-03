#include<bits/stdc++.h>
using namespace std;
/*Recursive function to calculate gcd of 2 numbers*/
int gcd(int a, int b) 
{ 
    if(a < b) 
        return gcd(b, a); 
    else if(a%b == 0) 
        return b; 
    else return gcd(b, a%b);   
} 
int power(int a, int b,int p){
    int res =1;
    a = a%p;
    while(b>0){
        if(b&1){
            res = (res*a)%p;
        }
        b>>=1;
        a = (a*a)%p;
    }
    return res;
}
bool isPrimeFermat(int n, int k){
    if(n==4 || n<=1){
        return false;
    }
    if(n<=3){
        return true;
    }
    while(k-->0){
        int a = 2+rand()%(n-4);
        if(gcd(n,a)!=1){
            return false;
        }
        if(power(a,n-1,n)!=1){
            return false;
        }
    }
    return true;
}
int main(){
    int k = 5; 
    isPrimeFermat(11, k)?  cout << " true\n": cout << " false\n"; 
    isPrimeFermat(1000000007, k)?  cout << " true\n": cout << " false\n"; 
    return 0; 
}
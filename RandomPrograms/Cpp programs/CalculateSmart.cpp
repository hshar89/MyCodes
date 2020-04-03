#include<bits/stdc++.h>
using namespace std;
typedef long long int ll;
#define M 1000000007
ll multiplyBigNumbers(ll a, ll b){
    ll res= 0;
    while(b){
        if(b%1){
            res = (res+a)%M;
        }
        a = (a*2)%M;
        b>>=1;
    }
    return res;
}
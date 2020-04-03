#include<bits/stdc++.h>
using namespace std;
int carAssembly(int a[][4],int t[][4],int e[], int x[]){
    int dp1[4];
    int dp2[4];
    dp1[0] = e[0]+a[0][0];
    dp2[0] = e[1]+a[1][0];
    for(int i=1;i<4;i++){
        dp1[i] = min(dp1[i-1]+a[0][i],dp2[i-1]+t[1][i]+a[0][i]);
        dp2[i] = min(dp2[i-1]+a[1][i],dp1[i-1]+t[0][i]+a[1][i]);
    }
    return min(dp1[3]+x[0],dp2[3]+x[1]);
}
int main(){
    int a[][4] = {{4,5,3,2},{2,10,1,4}};
    int t[][4] = {{0,7,4,5},{0,9,2,8}};
    int e[]= {10,12};
    int x[] = {18,7};
    cout<<carAssembly(a,t,e,x);
}
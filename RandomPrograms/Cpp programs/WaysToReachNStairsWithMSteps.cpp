#include<bits/stdc++.h>
using namespace std;
int countWaysRecursive(int n, int m){
    if(n<=1){
        return n;
    }
    int res = 0;
    for(int i=1;i<=m && i<=n;i++){
        res+=countWaysRecursive(n-i,m);
    }
    return res;
}
int waysUsingdp(int n, int m){
    int res[n];
    res[0] = 1;
    res[1] = 1;
    for(int i =2;i<n;i++){
        res[i] = 0;
        for(int j=1;j<=min(m,i);j++){
            res[i] +=res[i-j];
        }
    }
    return res[n-1];
}
int main(){
    int n = 4;
    int m = 2;
    cout<<countWaysRecursive(n+1,m)<<"\n";
    cout<<waysUsingdp(n+1,m)<<"\n";
}
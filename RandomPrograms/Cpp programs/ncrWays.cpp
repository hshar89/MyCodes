#include<bits/stdc++.h>
using namespace std;
#define ll long long int
ll fact(int n){
   ll res =1 ;
   for(int i=2;i<=n;i++){
       res*=i;
   }
   return res;
}
ll noviceNcR(int n, int r){
    return fact(n)/fact(n-r)/fact(r);
}
ll binomialCoefficient(int n ,int r){
    if(r==0 || r==n){
        return 1;
    }
    return binomialCoefficient(n-1,r-1)+binomialCoefficient(n-1,r);
}
ll dpBinomialCoefficient(int n, int r){
    ll C[n+1][r+1];
    int i,j;
    for( i=0;i<=n;i++){
        for(j = 0;j<=min(r,i);j++){
            if(j==0 || j==i){
                C[i][j]= 1;
            }else{
                C[i][j] = C[i-1][j-1]+C[i-1][j];
            }

        }
    }
    return C[n][r];
}
ll dpBinomialCoefficientSpaceOptimized(int n, int r){
    ll C[r+1];
    memset(C,0,sizeof(C));
    C[0]= 1;
    for(int i=0;i<=n;i++){
        for(int j=min(i,r);j>0;j--){
            C[j] = C[j]+C[j-1];
        }
    }
    return C[r];
}
ll fastestNcR(int n, int r){
    if(r>n-r){
        r = n-r;
    }
    ll res  = 1;
    for(int i=0;i<r;i++){
        res *=(n-i);
        res/=(i+1);
    }
    return res;
}
int main(){
    int n = 10,r=5;
    cout<<noviceNcR(n,r);
    cout<<endl;
    cout<<binomialCoefficient(n,r);
    cout<<endl;
    cout<<dpBinomialCoefficient(n+20,r+2);
    cout<<endl;
    cout<<dpBinomialCoefficientSpaceOptimized(n+20,r+2);
    cout<<endl;
    cout<<fastestNcR(n+20,r+2);
    cout<<endl;
}
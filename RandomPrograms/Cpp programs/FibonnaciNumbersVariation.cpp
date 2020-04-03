#include<bits/stdc++.h>
using namespace std;
typedef long long int ll;
int fibUsingRecursion(int n){
  if(n==0 || n==1){
      return n;
  }
 return fibUsingRecursion(n-1)+fibUsingRecursion(n-2);
}
int fibusingDP(int n, int dp[]){
 if(dp[n]!=-1){
     return dp[n];
 }
 if(n==0 || n==1){
     dp[n] = n;
     return dp[n];
 }
 dp[n] = fibusingDP(n-1,dp)+fibusingDP(n-2,dp);
 return dp[n];
}
int fibSpaceOptimum(int n){
    int a=0,b=1,c,i;
    if(n==0){
        return a;
    }
    for(int i=2;i<=n;i++){
        c=a+b;
        a=b;
        b=c;
    }
    return b;
}
void multiply(int F[2][2], int M[2][2]){
    int x = F[0][0]*M[0][0] + F[0][1]*M[1][0];
    int y = F[0][0]*M[0][1] + F[0][1]*M[1][1];
    int z = F[1][0]*M[0][0] + F[1][1]*M[1][0];
    int w = F[1][0]*M[0][1] + F[1][1]*M[1][1];

    F[0][0] = x;
    F[0][1] = y;
    F[1][0] = z;
    F[1][1] = w;
}
void power(int F[2][2], int n){
    int i;
    int M[2][2]= {{1,1},{1,0}};
    for(int i=2;i<=n;i++){
        multiply(F,M);
    }
}
int fibByMatrixMultiply(int n){
 int F[2][2] = {{1,1},{1,0}};
 if(n==0){
     return n;
 }
 power(F,n-1);
 return F[0][0];
}
void powerFast(int F[2][2], int n){
    if(n==0 || n==1){
        return;
    }
    int M[2][2] = {{1,1},{1,0}};

    powerFast(F,n/2);
    multiply(F,F);
    if(n%2!=0){
        multiply(F,M);
    }
}
int fibMultiplyFastVersion(int n){
    int F[2][2] = {{1,1},{1,0}};
    if(n==0){
        return n;
    }
    powerFast(F,n-1);
    return F[0][0];
}
int fastFib(int n, int f[]){
    if(n==0){
        return 0;
    }
    if(n==1 || n==2){
        return (f[n] = 1);
    }
    if(f[n]){
        return f[n];
    }
    int k = (n&1)?(n+1)/2:n/2;
    f[n] = (n&1)?(fastFib(k,f)*fastFib(k,f)+fastFib(k-1,f)*fastFib(k-1,f)):
             (2*fastFib(k-1,f)+fastFib(k,f))*fastFib(k,f);
    return f[n];
}
ll fibusingFormula(int n){
    double phi = (1+sqrt(5))/2;
    ll result = round(pow(phi,n)/sqrt(5));
    return result;
}
int main(){
  int n = 40;
  int dp[n+1];
  memset(dp,-1,sizeof(dp));
  cout<<fibUsingRecursion(12)<<"\n";
  cout<<fibusingDP(n,dp)<<"\n";
  cout<<fibSpaceOptimum(n)<<"\n";
  cout<<fibByMatrixMultiply(n)<<"\n";
  cout<<fibMultiplyFastVersion(n)<<"\n";
  memset(dp,0,sizeof(dp));
  cout<<fastFib(n,dp)<<"\n";
  cout<<fibusingFormula(40)<<"\n";
}
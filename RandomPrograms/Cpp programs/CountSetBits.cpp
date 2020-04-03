#include<bits/stdc++.h>
using namespace std;
typedef unsigned int ui;
#define B2(n) n, n+1, n+1, n+2
#define B4(n) B2(n) , B2(n+1), B2(n+1), B2(n+2)
#define B6(n) B4(n) , B4(n+1), B4(n+1), B4(n+2)
unsigned int lookupTable256[256] = {B6(0),B6(1),B6(1),B6(2)};


int countBits(int n){
    unsigned int count = 0;
    while(n){
        n = (n&(n-1));
        count++;
    }
    return count;
}
int countSetBitsRecursive(int n){
    if(n==0){
        return 0;
    }
    return ((n%2==0?0:1)+countSetBitsRecursive(n/2));
}
int countSetBitsNaive(int n){
    int count=0;
    int  i =0;
    while(n){
      if(n&(1<<i)){
          count++;
      }
      n>>=1;
    }
    return count;
}
int countSetBitsUsinglookupTable(int n){
   int count = lookupTable256[n&0xff]+
             lookupTable256[(n>>8)&0xff]+
             lookupTable256[(n>>16)&0xff]+
             lookupTable256[(n>>24)&0xff];
    return count;
}
int countSetBitsTillN(int n){
    int i=0;
    int ans = 0;
    while((1<<i)<=n){
        int count = 1<<i;
        bool k=0;
        for(int j=0;j<=n;j++){
            ans+=k;
            if(count ==1){
              k=!k;
              count = (1<<i);
            }else{
                count--;
            }  
        }
        i++;
    }
    return ans;
}
ui swapBits(ui n, ui p1, ui p2, ui x){
   ui set1 = (x>>p1)&((1U<<n)-1);
   ui set2 = (x>>p2)&((1U<<n)-1);
   ui Xor = (set1^set2);
   Xor = (Xor<<p1)|(Xor<<p2);
   return (x^Xor);
}
int main(){
   int n = 25535;
   //cout<<(n>>1)<<" "<<(1>>0);
   cout<<countSetBitsNaive(n)<<"\n";
   cout<<countBits(n)<<"\n";
   cout<<countSetBitsRecursive(n)<<"\n";
   for(int i=0;i<256;i++){
       lookupTable256[i] = (i&1)+lookupTable256[i/2];
   }
   cout<<countSetBitsUsinglookupTable(n)<<"\n";
   cout<<countSetBitsTillN(21)<<"\n";
   cout<<swapBits(2,0,3,28)<<"\n";
}
#include<bits/stdc++.h>
using namespace std;
int ncrModpWithDP(int n, int r, int p){
    int C[r+1];
    memset(C,0,sizeof(C));
    C[0]= 1;
    for(int i=1;i<=n;i++){
        for(int j = min(i,r);j>0;j--){
            C[j] = (C[j]+C[j-1])%p;
        }
    }
    return C[r];
}
/**(588 choose 277) % 5 = ?
                Representation of 588 in base of 5 = 4323
                Representation of 277 in base of 5 = 2102
                Now your answer reduces to = ((4 choose 2)(3 choose 1)(2 choose 0)(3 choose 2)) % 5
                                         = (6 * 3 * 1 * 3) % 5
                                         = 54 % 5
                                         = 4**/
int ncrModpWithLucas(int n,int r,int p){
    if(r==0){
        return 1;
    }
    int ni = n%p,ri=r%p;
    return (ncrModpWithLucas(n/p,r/p,p)*ncrModpWithLucas(ni,ri,p))%p;
}
int power(int x, int y, int p) 
{ 
    int res = 1;      // Initialize result 
  
    x = x % p;  // Update x if it is more than or 
                // equal to p 
  
    while (y > 0) 
    { 
        // If y is odd, multiply x with result 
        if (y & 1) 
            res = (res*x) % p; 
  
        // y must be even now 
        y = y>>1; // y = y/2 
        x = (x*x) % p; 
    } 
    return res; 
} 
  
// Returns n^(-1) mod p 
int modInverse(int n, int p) 
{ 
    return power(n, p-2, p); 
} 
// Returns nCr % p using Fermat's little 
// theorem. 
int nCrModPFermat(int n, int r, int p) 
{ 
   // Base case 
   if (r==0) 
      return 1; 
  
    // Fill factorial array so that we 
    // can find all factorial of r, n 
    // and n-r 
    int fac[n+1]; 
    fac[0] = 1; 
    for (int i=1 ; i<=n; i++) 
        fac[i] = fac[i-1]*i%p; 
  
    return (fac[n]* modInverse(fac[r], p) % p * 
            modInverse(fac[n-r], p) % p) % p; 
} 
int main(){
  int n = 1009,r=902, p=1000000007;
  cout<<ncrModpWithDP(n,r,p);
  cout<<endl;
  //cout<<ncrModpWithLucas(n,r,p);
  cout<<endl;
  cout<<nCrModPFermat(n,r,p);
}
#include<iostream>
#include<stdio.h>
using namespace std;
inline int inp()
{
    int noRead=0;
    char p=getchar();
    for(;p<33;)
    {
     p=getchar();
    };
    while(p>32)
    {
     noRead = (noRead << 3) + (noRead << 1) + (p - '0');
     p=getchar();
    }
    return noRead;
};
int main()
{
 int t;
 //scanf("%d",&t);
 t=inp();
 while(t--)
 {
  int k[501],dp[1001]={0},h[501];
  int ans=0,n,i,j,min,max=0;
  //scanf("%d",&n);
  n=inp();
  for(i=0;i<n;i++)
  {
  // scanf("%d",&h[i]);
   h[i]=inp();
   h[i]=2*h[i];
   if(h[i]>max)
    max=h[i];
  }
  for(i=0;i<n;i++)
  {
   //scanf("%d",&k[i]);
    k[i]=inp();
   dp[k[i]]=1;
  }
  for(i=1;i<=max;i++)
  {
     if(!dp[i])
     {
         min=1000000;
         for(j=1;j<=(i/2);j++)
         {
             if((dp[j]+dp[i-j])<min)
              min=(dp[j]+dp[i-j]);
         }
         dp[i]=min;
     }
  }
  for(i=0;i<n;i++)
  {
   ans+=dp[h[i]];
  }
  printf("%d\n",ans);
 }
  return 0;
}
//This is a copied code. But do make sure to go over the concept
//properly. 
#include <bits/stdc++.h>
using namespace std;
//For reading characters fast
long long read()
{
        long long n=0;
        char c;int f=0;
        //fast method to read character
        c=getchar_unlocked();
        while(c<'0'||c>'9')
        {
        
        if(c=='-')
        f=1;
        	c=getchar_unlocked();
        }
        while(c>='0'&&c<='9')
        {
        	n=n*10+c-'0';
        	c=getchar_unlocked();
        }
        if(!f)
        return n;
        else
        return -n;
}
//Get the absolute value 
long long ab(long long a)
{
	if(a<0)
	return -a;
	else
	return a;
}
     
    int main(void) {
    	long long t,i,j,n;
    	long long arr[10001],maxl[10001],minl[10001],maxr[10001],minr[10001],ans;
    	t=read();
    	while(t--)
    	{
    		n=read();
    		ans=0;
    		for(i=0;i<n;i++)
    		{
    			arr[i]=read();
    		    maxl[i]=maxr[i]=minl[i]=minr[i]=arr[i];
    		}
    		for(i=1;i<n;i++)
    		{   //Finding the max sub array sum from left
    			if(maxl[i-1]>0)
    			maxl[i]+=maxl[i-1];
    			//calculating minimum sub array sum from left
    			if(minl[i-1]<0)
    			minl[i]+=minl[i-1];
    		}
    		for(i=n-2;i>=0;i--)
    		{  
    		   if(maxr[i+1]>0)
    			maxr[i]+=maxr[i+1];
    			if(minr[i+1]<0)
    			minr[i]+=minr[i+1];
    		}
    		
    		for(i=0;i<n-1;i++)
    		{   //maximum diff can happen from either
    		    //minimum left subarray sum with max right subarray sum 
    		    // or vice versa
    			ans=max(ans,ab(maxl[i]-minr[i+1]));
    			ans=max(ans,ab(maxr[i+1]-minl[i]));
    		}
    		printf("%lld\n",ans);
    	}
    	return 0;
    } 
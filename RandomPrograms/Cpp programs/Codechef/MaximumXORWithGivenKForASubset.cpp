#include <iostream>
#include <bits/stdc++.h>
//This program is to find maximum XOR value with a given k from all the subsets of an array
int main()
{
	int t;
	scanf("%d",&t);
	while(t--)
    {
        int n,k,data[1002],i,j,hash[1025];
        scanf("%d %d",&n,&k);
        memset(hash,0,sizeof(hash));
        int x=0,l=0;
		//Hash to prevent duplicate values
        for(i=0;i<n;i++)
        {
            scanf("%d",&x);
            if(hash[x]==0)
            {
                hash[x]=1;
                data[l++]=x;
            }
        }
        n=l;
        for(i=0;i<n;i++)
        {
            for(j=i+1;j<n;j++)
            {   //This code generates all possible subsets.
		//The hash prevents a subset from repeating its XOR value
		//Any new XOR value is stored back in data array and used to form the next subset
                int ans=data[i]^data[j];
                //printf(" ans: %d",ans);
                if(hash[ans]==0)
                {
                    data[n]=ans;
                    hash[ans]=1;
                    n++;
                }
                //printf(" n: %i",n);
            }
        }
        int max=k;
        for(i=0;i<n;i++)
        {   //All combinations of the subsets are XORed with k to find the max
            if((k^data[i])>max)
             {
             max=(k^data[i]);
             }
        }
        printf("%d\n",max);
    }
	return 0;
}
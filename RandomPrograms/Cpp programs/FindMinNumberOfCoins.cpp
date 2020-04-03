//This is a reference solution to find the minimum number of coins in an given array to form the total value
#include <iostream>
#include<bits/stdc++.h>
using namespace std;
long long minimumNumberOfCoins(int coinsp[], int numberOfCoins, int value);
int main(){
    int coins[] = {2,3,5};
    int numberOfCoins = 3;
    cout<<minimumNumberOfCoins(coins,numberOfCoins,45);
}
long long minimumNumberOfCoins(int coins[],int numberOfCoins,int value)
{
    long long minimumNumberOfCoinsRequired[value+1]={0};
    //The above array holds the minimum number of coins for every amount from 0 to value
    
    
    minimumNumberOfCoinsRequired[0]=0;
    //
    
    for(int i=1;i<value+1;i++)
    {
        minimumNumberOfCoinsRequired[i]=INT_MAX;
        //We fill all array with inifinty as intially we need infinite coins to make the value
    }
    
    vector<int> coinsSet;
    
    for(int i=0;i<numberOfCoins;i++)
    {
        coinsSet.push_back(coins[i]);
    }
    
    
    for(auto coin:coinsSet) //Iterating over each coin
    {   
        for(int i=1;i<value+1;i++)
        {   
            if(i>=coin) //No use in checking for values that are smaller than the current coin
            {
                //Your code here
                /*
                The minimum number of coins required to make current i value can be found
                by taking seeeing which is minimum : 
                (current coins required to form i value)
                or
                (1+ coins required to form i-coin value)
                */
                int p,q;
                p=q= minimumNumberOfCoinsRequired[i];
                if(i%coin == 0){
                    p = i/coin;
                }
                if(minimumNumberOfCoinsRequired[i-coin] != INT_MAX){
                q = 1+minimumNumberOfCoinsRequired[i-coin];
                }
                minimumNumberOfCoinsRequired[i] = min((int)minimumNumberOfCoinsRequired[i],min(p,q));
            }
        }
    }
    return minimumNumberOfCoinsRequired[value];
}
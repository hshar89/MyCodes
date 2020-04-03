//This is for finding number of ways that a value can be achieved from a given set of coins
#include <iostream>
using namespace std;
long long numberOfWays(int coins[],int numberOfCoins,int value)
{
    
    long long ways[value+1]={0}; //We declare an array that will contain the number of--
    //ways to make change for all values from 0 to value
    //This is done as we are working from bottom up. So, obviously, we need to make change for smaller values--
    //before we can make change for the given values.
    ways[0]=1; //We can make change for 0 in 1 ways, that is by choosing nothing.
    vector<int> coinsSet;
    
    for(int i=0;i<numberOfCoins;i++)
    {
        coinsSet.push_back(coins[i]);
    }
    
    for(auto coin:coinsSet) //Using a coin, one at a time. Use this if order does not matters 
    {
        for(int i=1;i<value+1;i++)
        {
            if(i>=coin) //Since it makes no sense to create change for value smaller than coin's denomination
            {
               //Write your code here
               //We can make change for i by adding number of ways we previously made change for i-coin
               ways[i] = ways[i] + ways[i-coin];
            }
        }
    }
    
    return ways[value];
}

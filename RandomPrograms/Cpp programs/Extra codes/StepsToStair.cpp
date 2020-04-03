//Count Number of ways to reach nth stair
#include<bits/stdc++.h>
using namespace std
long long countWays(int m){
    // your code here
    long long ways[m+1];
    ways[0] = 0;
    ways[1] = 1;
    ways[2] = 2;
    for(int i=3;i<=m;i++){
	    //The user can come to the nth stair from 
		//n-1th or n-2th stair
        ways[i] = (ways[i-1]+ways[i-2])%mod;
    }
    return ways[m];
}
// A simple recursive program to find n'th fibonacci number 
/*
We can easily find recursive nature in above problem. 
The person can reach n’th stair from either (n-1)’th stair or from (n-2)’th stair. 
Let the total number of ways to reach n’t stair be ‘ways(n)’. 
The value of ‘ways(n)’ can be written as following.*/
int fib(int n) 
{ 
   if (n <= 1) 
      return n; 
   return fib(n-1) + fib(n-2); 
} 
  
// Returns number of ways to reach s'th stair 
int countWays(int s) 
{ 
    return fib(s + 1); 
} 
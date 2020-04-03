#include<bits/stdc++.h>
using namespace std;

// function to find sum of all possible substrings of the given string
long long sumSubstrings(string s){
    
    // your code here
    int n =s.length();
    long long dp[n][n];
    long long sum=0;
	//Stores the first set of characters in matrix
    for(int i=0;i<n;i++){
        dp[0][i] = s[i]-48;
        sum+=dp[0][i];
    }
   for(int i=1;i<n;i++){
       for(int j=0;j<n-i;j++){
		   //computes the next substring from previous
           dp[i][j] = (dp[i-1][j]*10)+(s[j+i]-48);
           sum+=dp[i][j];
       }
   }
   return sum;
}
//Better way to find out sum of digits
/*
Example : num = "1234"
sumofdigit[0] = 1 = 1
sumofdigit[1] = 2 + 12  = 14
sumofdigit[2] = 3 + 23  + 123 = 149
sumofdigit[3] = 4 + 34  + 234 + 1234  = 1506
Result = 1670
*/
// Utility method to covert character digit to 
// integer digit 
int toDigit(char ch) 
{ 
    return (ch - '0'); 
} 
// Returns sum of all substring of num 
int sumOfSubstrings(string num) 
{ 
    int n = num.length(); 
  
    //  allocate memory equal to length of string 
    int sumofdigit[n]; 
  
    //  initialize first value with first digit 
    sumofdigit[0] = toDigit(num[0]); 
    int res = sumofdigit[0]; 
  
    //  loop over all digits of string 
    for (int i=1; i<n; i++) 
    { 
        int numi = toDigit(num[i]); 
  
        // update each sumofdigit from previous value 
        sumofdigit[i] = (i+1) * numi + 
                        10 * sumofdigit[i-1]; 
  
        // add current value to the result 
        res += sumofdigit[i]; 
    } 
  
    return res; 
} 

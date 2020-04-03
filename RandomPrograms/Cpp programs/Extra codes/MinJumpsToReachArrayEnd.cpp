// CPP program to find Minimum  
// CPP program to find Minimum  
// number of jumps to reach end 
#include<bits/stdc++.h> 
using namespace std; 
  
// Returns Minimum number of 
// jumps to reach end 
int minJumps(int arr[], int n) 
{    
    // jumps[0] will hold the result 
    int *jumps = new int[n];  
    int min; 
  
    // Minimum number of jumps needed  
    // to reach last element from last 
    // elements itself is always 0 
    jumps[n-1] = 0; 
  
  
    // Start from the second element,  
    // move from right to left and  
    // construct the jumps[] array where 
    // jumps[i] represents minimum number 
    // of jumps needed to reach  
    // arr[m-1] from arr[i] 
    for (int i = n-2; i >=0; i--) 
    { 
        // If arr[i] is 0 then arr[n-1]  
        // can't be reached from here 
        if (arr[i] == 0) 
            jumps[i] = INT_MAX; 
  
        // If we can direcly reach to  
        // the end point from here then 
        // jumps[i] is 1 
        else if (arr[i] >= n - i - 1) 
            jumps[i] = 1; 
  
        // Otherwise, to find out the minimum 
        // number of jumps needed to reach  
        // arr[n-1], check all the points  
        // reachable from here and jumps[]  
        // value for those points 
        else
        {    
            // initialize min value 
            min = INT_MAX;  
  
            // following loop checks with all 
            // reachable points and takes  
            // the minimum 
            for (int j = i + 1; j < n && j <=  
                             arr[i] + i; j++) 
            { 
                if (min > jumps[j]) 
                    min = jumps[j]; 
            }      
  
            // Handle overflow  
            if (min != INT_MAX) 
            jumps[i] = min + 1; 
            else
            jumps[i] = min; // or INT_MAX 
        } 
    } 
  
    return jumps[0]; 
} 
//Below is an O(n) method to calculate max jumps
// Returns minimum number of jumps to reach arr[n-1] from arr[0] 
int minJumps(int arr[], int n) 
{ 
      
    // The number of jumps needed to reach the starting index is 0 
    if (n <= 1) 
        return 0; 
  
    // Return -1 if not possible to jump 
    if (arr[0] == 0) 
        return -1; 
  
    // initialization 
    int maxReach = arr[0];  // stores all time the maximal reachable index in the array. 
    int step = arr[0];      // stores the number of steps we can still take 
    int jump =1;//stores the number of jumps necessary to reach that maximal reachable position. 
  
    // Start traversing array 
    int i=1; 
    for (i = 1; i < n; i++) 
    { 
        // Check if we have reached the end of the array 
        if (i == n-1) 
            return jump; 
  
        // updating maxReach 
        maxReach = max(maxReach, i+arr[i]); 
  
        // we use a step to get to the current index 
        step--; 
  
        // If no further steps left 
        if (step == 0) 
        { 
            // we must have used a jump 
            jump++; 
  
            // Check if the current index/position or lesser index 
            // is the maximum reach point from the previous indexes 
            if(i >= maxReach) 
                return -1; 
  
            // re-initialize the steps to the amount 
            // of steps to reach maxReach from position i. 
            step = maxReach - i; 
        } 
    } 
  
    return -1; 
} 
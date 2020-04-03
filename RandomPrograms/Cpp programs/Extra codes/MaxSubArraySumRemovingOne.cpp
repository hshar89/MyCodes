// C++ program to get maximum sum subarray removing 
// at-most one element 
#include <bits/stdc++.h> 
using namespace std; 
  
// Method returns maximum sum of all subarray where 
// removing one element is also allowed 
int maxSumSubarrayRemovingOneEle(int arr[], int n) 
{ 
    // Maximum sum subarrays in forward and backward 
    // directions 
    int fw[n], bw[n]; 
  
    // Initialize current max and max so far. 
    int cur_max = arr[0], max_so_far = arr[0]; 
  
    // calculating maximum sum subarrays in forward 
    // direction 
    fw[0] = arr[0]; 
    for (int i = 1; i < n; i++) 
    { 
        cur_max = max(arr[i], cur_max + arr[i]); 
        max_so_far = max(max_so_far, cur_max); 
  
        // storing current maximum till ith, in 
        // forward array 
        fw[i] = cur_max; 
    } 
  
    // calculating maximum sum subarrays in backward 
    // direction 
    cur_max = max_so_far = bw[n-1] = arr[n-1]; 
    for (int i = n-2; i >= 0; i--) 
    { 
        cur_max = max(arr[i], cur_max + arr[i]); 
        max_so_far = max(max_so_far, cur_max); 
  
        // storing current maximum from ith, in 
        // backward array 
        bw[i] = cur_max; 
    } 
  
    /*  Initializing final ans by max_so_far so that, 
        case when no element is removed to get max sum 
        subarray is also handled  */
    int fans = max_so_far; 
  
    //  choosing maximum ignoring ith element 
    for (int i = 1; i < n - 1; i++) 
        fans = max(fans, fw[i - 1] + bw[i + 1]); 
  
    return fans; 
} 
  
//  Driver code to test above methods 
int main() 
{ 
    int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3}; 
    int n = sizeof(arr) / sizeof(arr[0]); 
    cout << maxSumSubarrayRemovingOneEle(arr, n); 
    return 0; 
} 
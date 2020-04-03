//Black and White
#include <iostream>
#include <bits/stdc++.h>
bool isSafe(int row, int col,int m, int n){
    return (row>=0) && (row<m) && (col>=0) && (col<n);
}
unsigned long long solve(int m,int n)
{
    // Your code here
   // vector<vector<int>> v;
    /*for(int i=0;i<m;i++){
        vector<int> temp;
        for(int j=0;j<n;j++){
          temp.push_back(0);  
        }
        v.push_back(temp);
    }*/
    int totalSeats = m*n-1;
    unsigned long long arrangements = 0;
    int R[] = {1,-1,-2,-2,-1,1,2,2};
    int C[] = {-2,-2,-1,1,2,2,1,-1};
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            int unsafeCount = 0;
            for(int k=0;k<8;k++){
            int row = i+R[k];
            int col = j+C[k];
            if(isSafe(row,col,m,n)){
                unsafeCount++;
            }
          }
          arrangements+=(totalSeats-unsafeCount);
        }
    }
    return arrangements;
 }
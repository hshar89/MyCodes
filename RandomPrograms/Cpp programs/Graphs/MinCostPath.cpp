#include <iostream>
#include <bits/stdc++.h>
#define R 51
#define C 51
using namespace std;
struct cell{
   int x,y;
   int distance;
   cell(int x, int y, int distance){
      this->x = x;
	  this->y = y;
	  this->distance = distance;
	  }
};
bool isSafe(int row, int col,int n){
    return (row>=0) &&(row<n)&&(col>=0)&&(col<n);
}
int minCostPath(int cost[R][C], int n){
    int L[] = {-1,0,1,0};
    int R[] = {0,1,0,-1};
	int dp[R][C];
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			dp[i][j] = INT_MAX;
	    }
	}
	dp[0][0] = cost[0][0];
    set<cell> st;
	st.insert(cell(0,0,0));
    while(!st.empty(){
      cell temp = st.begin();
	  st.erase(st.begin());
	  
      for(int k=0;k<4;k++){
                int row = temp.x+L[k];
                int col = temp.y+R[k];
                if(isSafe(row,col,n) && dp[row][col]>dp[temp.x][temp.y]+cost[row][col]){
                    if(dp[row][col]!=INT_MAX){
						set.erase(st.find(cell(row,col,dp[row][col])));
					}
                   dp[row][col] = cost[row][col]+dp[temp.x][temp.y];
		           set.insert(cell(row,col,dp[row][col]));
                }
            }
    }
    return dp[n-1][n-1];
}
int main() {
	//code
	int n = 5;
	 int grid[n][n] = 
    { 
        31, 100, 65, 12, 18, 
        10, 13, 47, 157, 6, 
        100, 113, 174, 11, 33, 
        88, 124, 41, 20, 140, 
        99, 32, 111, 41, 20 
    }; 
  
    cout << minCostPath(grid, n) << endl;
	return 0;
}
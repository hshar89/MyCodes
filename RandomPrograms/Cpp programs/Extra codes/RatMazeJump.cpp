#include <iostream>
int main(){

}
bool isSafe(int row, int col, int (*m)[MAX], int x){
    return (row>=0) && (col>=0) && (row<x) && (col<x) && (m[row][col]>0);
}
bool solveUtil(int x, int row, int col, int (*m)[MAX], int sol[][MAX]){
    if(row == x-1 && col == x-1){
		sol[row][col] = 1;
		return true;
	}
	if(isSafe(row,col,m,x)){
		sol[row][col] = 1;
		for(int i=1;i<m[row][col] && i<x;i++){
			if(solveUtil(x,row,col+i,m,sol)){
				return true;
			}
			if(solveUtil(x,row+i,col,m,sol)){
				return true;
			}
		}
		sol[row][col] = 0;
		return false;
	}
	return false;
}
bool solve(int x,int (*m)[MAX])
{  
    int sol[MAX][MAX];
    for(int i=0;i<x;i++){
        for(int j=0;j<x;j++){
            sol[i][j] = 0;
        }
    }
    // Your code here
           if(solveUtil(x,0,0,m,sol)){
			  sol[x-1][x-1] = 1;
              print(x,sol);	
              return true;			  
		   }else{
			   cout<<"-1"<<endl;
			   return false;
		   }   
    return false;
}
#include <iostream>
using namespace std;
#define MAX 10000
bool isSafe(int x, int y, int b){
    if((y+x-b)<=0){
        return true;
    }
    return false;
}
void findNumberOfSquaresInsideTriangle(int x, int y, int b, int &count, int visited[MAX][MAX]){
    if(x>b-4 || y>b-4){
        return;
    }
    if(visited[x][y]==1){
        return;
    }
    visited[x][y] =1;
    //cout<<"x: "<<x<<" ";
    //cout<<"y: "<<y<<" ";
    if(isSafe(x+2,y+2,b)){
        count++;
    }else{
        return;
    }
    //cout<<"count: "<<count<<" ";
    findNumberOfSquaresInsideTriangle(x+2,y,b,count,visited);
    findNumberOfSquaresInsideTriangle(x,y+2,b,count,visited);
}
int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t-->0){
	    int b;
	    cin>>b;
	    /*if(b<=3){
	        cout<<0<<endl;
	        continue;
	    }*/
	    int visited[MAX][MAX];
	    for(int i=0;i<b;i++){
	        for(int j=0;j<b;j++){
	            visited[i][j] = 0;
	        }
	    }
	    int count = 0;
	    findNumberOfSquaresInsideTriangle(0,0,b,count,visited);
	    cout<<count<<endl;
	}
	return 0;
}

#include<bits/stdc++.h>
using namespace std;
#define V 4
#define INF 999999
/* A utility function to print solution */
void printSolution(int dist[][V])  
{  
    cout<<"The following matrix shows the shortest distances"
            " between every pair of vertices \n";  
    for (int i = 0; i < V; i++)  
    {  
        for (int j = 0; j < V; j++)  
        {  
            if (dist[i][j] == INF)  
                cout<<"INF"<<"     ";  
            else
                cout<<dist[i][j]<<"     ";  
        }  
        cout<<endl;  
    }  
}  
void doFlyodMagic(int graph[V][V]){
    int copy[V][V];
    for(int i=0;i<V;i++){
        for(int j=0;j<V;j++){
            copy[i][j] = graph[i][j];
        }
    }
    for(int k=0;k<V;k++){
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(copy[i][j]>copy[i][k]+copy[k][j]){
                    copy[i][j] = copy[i][k] + copy[k][j];
                }
            }
        }
    }
   // Print the shortest distance matrix  
    printSolution(copy); 
}

int main(){
    int graph[V][V] = {
        {0,3,INF,7},
        {8,0,2,INF},
        {5,INF,0,1},
        {2,INF,INF,0}
    };
    doFlyodMagic(graph);
}
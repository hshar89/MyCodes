#include<bits/stdc++.h>
using namespace std;
#define V 7
void printTransitiveClosure(bool reach[][V]){
    for(int i=0;i<V;i++){
        for(int j=0;j<V;j++){
            cout<<reach[i][j]<<" ";
        }
        cout<<"\n";
    }
}
void transitiveClosure(int graph[][V]){
    bool reach[V][V];
    for(int i=0;i<V;i++){
        for(int j=0;j<V;j++){
            reach[i][j] = graph[i][j];
        }
    }
    for(int k=0;k<V;k++){
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                reach[i][j] = reach[i][j] || (reach[i][k] && reach[k][j]);
            }
        }
    }
    printTransitiveClosure(reach);
}
int main(){
    int graph[V][V] = {
        {1,0,0,0,0,1,1},
        {0,1,1,0,0,1,0},
        {0,0,1,1,1,0,0},
        {0,0,0,1,1,0,0},
        {0,0,0,0,1,0,0},
        {0,0,0,0,0,1,1},
        {0,0,0,0,1,0,0}
    };
    transitiveClosure(graph);
}
#include<bits/stdc++.h>
using namespace std;
#define V 9
int minDistanceEdge(int spt[], int dis[]){
    int min_dis = INT_MAX;
    int index;
    for(int i=0;i<V;i++){
        if(spt[i]== false && dis[i]<min_dis){
            index = i;
            min_dis = dis[i];
        }
    }
    return index;
}
// A utility function to print the constructed distance array 
int printSolution(int dist[]) 
{ 
    printf("Vertex \t\t Distance from Source\n"); 
    for (int i = 0; i < V; i++) 
        printf("%d \t\t %d\n", i, dist[i]); 
} 
void dijkstra(int graph[V][V],int s){
    int dis[V];
    int spt[V];
    for(int i=0;i<V;i++){
        dis[i] = INT_MAX;
        spt[i] = false;
    }
    dis[s] = 0;
    for(int i=0;i<V-1;i++){
        int u = minDistanceEdge(spt,dis);
        spt[u] =true;
        for(int j=0;j<V;j++){
            if(graph[u][j] && dis[j]>dis[u]+graph[u][j]){
                dis[j] = dis[u]+graph[u][j];
            }
        }
    }
    printSolution(dis); 
}
int main(){
    /* Let us create the example graph discussed above */
    int graph[V][V] = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                        { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                        { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                        { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                        { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                        { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                        { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                        { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
  
    dijkstra(graph, 0); 
}
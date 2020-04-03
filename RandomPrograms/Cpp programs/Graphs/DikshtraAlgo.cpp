/*This is a function problem.You only need to complete the function given below*/
/*  Function to implement Dijkstra
*   graph: vector of vectors which represents the graph
*   src: source vertex to start traversing graph with
*   V: number of vertices
*/
int findMinDis(int dis[], int V, bool sprSet[]){
    int minimum = INT_MAX;
    int index = 0;
    for(int i=0;i<V;i++){
        if(sprSet[i]==false && dis[i]<minimum){
            minimum = dis[i];
            index = i;
        }
    }
    return index;
}
void dijkstra(vector<vector<int>> graph, int src, int V)
{
    // Your code here
    //cout<<"V: "<<V;
    bool sprSet[V];
    int dis[V];
    for(int i=0;i<V;i++){
        sprSet[i] = false;
        dis[i] = INT_MAX;
    }
    dis[src] = 0;
    for(int i=0;i<V-1;i++){
        int u = findMinDis(dis,V,sprSet);
        //cout<<"minimum index: "<<u<<" "; 
        sprSet[u] = true;
        for(int j=0;j<V;j++){
            if(j!=u && graph[u][j] && sprSet[j] ==false && dis[u]+graph[u][j]<dis[j]){
                dis[j] = dis[u]+graph[u][j];
            }
        }
    }
    for(int i=0;i<V;i++){
        cout<<dis[i]<<" ";
    }
}
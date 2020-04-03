#include<bits/stdc++.h>
using namespace std;
class Graph{
    int V;
    list<int> *adj;
    int *indegree;
    public:
    Graph(int V){
        this->V = V;
        adj = new list<int>[V];
        indegree = new int[V];
        for(int i=0;i<V;i++){
            indegree[i] = 0;
        }
    }
    void addEdge(int u, int v){
        adj[u].push_back(v);
        indegree[v]++;
    }
    void DFSUtil(int s, bool visited[]);
    bool isSC();
    bool isEulerianCycle();
    Graph getTranspose();
};
Graph Graph::getTranspose(){
    Graph gr(V);
    for(int i=0;i<V;i++){
        for(auto it: adj[i]){
            gr.addEdge(it,i);
        }
    }
    return gr;
}
void Graph::DFSUtil(int s, bool visited[]){
    visited[s] = true;
    for(auto it: adj[s]){
        if(!visited[it]){
            DFSUtil(it,visited);
        }
    }
}
bool Graph::isSC(){
    bool visited[V];
    for(int i=0;i<V;i++){
        visited[i] = false;
    }
    int n;
    for(n = 0;n<V;n++){
        if(adj[n].size()>0){
            break;
        }
    }
    DFSUtil(n,visited);

    for(int i=0;i<V;i++){
        if(visited[i]==false && adj[i].size()>0){
            return false;
        }
    }
    Graph gr = getTranspose();

    for(int i=0;i<V;i++){
        visited[i] = false;
    }
    // Do DFS for reversed graph starting from first vertex. 
    // Staring Vertex must be same starting point of first DFS
    gr.DFSUtil(n,visited);

    // If all vertices are not visited in second DFS, then 
    // return false 
    for (int i = 0; i < V; i++) 
        if (adj[i].size() > 0 && visited[i] == false) 
             return false; 

    return true;

}
bool Graph::isEulerianCycle(){
    if(isSC() == false){
        return false;
    }
    for(int i=0;i<V;i++){
        if(adj[i].size() != indegree[i]){
            return false;
        }
    }
    return true;
}
int main(){
    // Create a graph given in the above diagram 
    Graph g(5); 
    g.addEdge(1, 0); 
    g.addEdge(0, 2); 
    g.addEdge(2, 1); 
    g.addEdge(0, 3); 
    g.addEdge(3, 4); 
    g.addEdge(4, 0); 
  
    if (g.isEulerianCycle()) 
       cout << "Given directed graph is eulerian n"; 
    else
       cout << "Given directed graph is NOT eulerian n"; 
    cout<<(int)'a'<<"\n";
    return 0; 

}
#include<bits/stdc++.h>
using namespace std;
class Graph{
    int V;
    list<int> *adj;
    bool **reach;
    void DFSUtil(int s, int v);
    public:
    Graph(int V){
        this->V = V;
        adj = new list<int>[V];
        reach = new bool *[V];
        for(int i=0;i<V;i++){
            reach[i] = new bool[V];
            memset(reach[i],0,V*sizeof(bool));
        }
    }
    void addEdge(int u, int v);
    void transitiveClosure();
};
void Graph::addEdge(int u, int v){
    adj[u].push_back(v);
}
void Graph::DFSUtil(int s, int v){
    reach[s][v] = true;
    for(auto i = adj[v].begin();i!=adj[v].end();i++){
        if(reach[s][*i] == false){
            DFSUtil(s,*i);
        }
    }
}
void Graph::transitiveClosure(){
    for(int i=0;i<V;i++){
        DFSUtil(i,i);
    }
    for (int i=0; i<V; i++) 
    { 
        for (int j=0; j<V; j++) 
            cout << reach[i][j] << " "; 
        cout << endl; 
    } 
}
int main(){
    Graph g(4);
    g.addEdge(0, 1); 
    g.addEdge(0, 2); 
    g.addEdge(1, 2); 
    g.addEdge(2, 0); 
    g.addEdge(2, 3); 
    g.addEdge(3, 3); 
  
    cout << "Transitive closure matrix is \n"; 
    g.transitiveClosure();    
}
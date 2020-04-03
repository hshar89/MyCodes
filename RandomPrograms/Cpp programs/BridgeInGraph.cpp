#include<bits/stdc++.h>
using namespace std;
class Graph{
    int V;
    list<int> *adj;
    void bridgeDFS(int s, int visited[], int disc[], int low[], int parent[], int &time);
    public:
    Graph(int V){
        this->V = V;
        adj = new list<int>[V];
    }
    void addEdge(int u,int v);
    void bridge();
};
void Graph::bridgeDFS(int s, int visited[], int disc[], int low[], int parent[], int &time){
    visited[s] = true;
    disc[s] = low[s] = ++time;
    for(auto it=adj[s].begin();it!=adj[s].end();it++){
        int v = *it;
        if(!visited[v]){
            parent[v] = s;
            bridgeDFS(v,visited,disc,low,parent,time);

            low[s] = min(low[v],low[s]);

            if(low[v]>disc[s]){
                cout<<s<<" "<<v<<endl;
            }
        }else if(v != parent[s]){
            low[s] = min(low[s],disc[v]);
        }
    }
}
void Graph::bridge(){
    int disc[V];
    int low[V];
    int parent[V];
    int visited[V];
    for(int i=0;i<V;i++){
        disc[i] = low[i] = 0;
        parent[i] = -1;
        visited[i] =0;
    }
    int time = 0;
    for(int i=0;i<V;i++){
        if(!visited[i]){
            bridgeDFS(i,visited,disc,low,parent,time);
        }
    }

}
void Graph::addEdge(int u, int v){
    adj[u].push_back(v);
    adj[v].push_back(u);
}
int main(){
    // Create graphs given in above diagrams 
    cout << "\nBridges in first graph \n"; 
    Graph g1(5); 
    g1.addEdge(1, 0); 
    g1.addEdge(0, 2); 
    g1.addEdge(2, 1); 
    g1.addEdge(0, 3); 
    g1.addEdge(3, 4); 
    g1.bridge(); 
  
    cout << "\nBridges in second graph \n"; 
    Graph g2(4); 
    g2.addEdge(0, 1); 
    g2.addEdge(1, 2); 
    g2.addEdge(2, 3); 
    g2.bridge(); 
  
    cout << "\nBridges in third graph \n"; 
    Graph g3(7); 
    g3.addEdge(0, 1); 
    g3.addEdge(1, 2); 
    g3.addEdge(2, 0); 
    g3.addEdge(1, 3); 
    g3.addEdge(1, 4); 
    g3.addEdge(1, 6); 
    g3.addEdge(3, 5); 
    g3.addEdge(4, 5); 
    g3.bridge(); 
  
    return 0; 
}
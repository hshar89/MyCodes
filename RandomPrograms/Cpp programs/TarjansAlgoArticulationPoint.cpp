#include<bits/stdc++.h>
using namespace std;
class Graph{
    list<int> *adj;
    int V;
    void APUtil(int &time,int v, bool visited[], int disc[], int low[], int parent[], bool ap[]);
    public:
    Graph(int V);
    void addEdge(int u, int v);
    void AP();
};
Graph::Graph(int V){
    this->V = V;
    adj = new list<int>[V];
}
void Graph::addEdge(int u, int v){
    adj[u].push_back(v);
    adj[v].push_back(u);
}
void Graph::APUtil(int &time,int s, bool visited[], int disc[], int low[], int parent[], bool ap[]){
    visited[s] = 1;
    int children = 0;
    disc[s] = low[s] = ++time;
    for(auto i=adj[s].begin();i!=adj[s].end();i++){
        int v = *i;
        if(!visited[v]){
            children++;
            parent[v] = s;
            APUtil(time,v,visited,disc,low,parent,ap);
            low[s] = min(low[s],low[v]);

            if(parent[s] == -1 && children>1){
                ap[s] = true;
            }
            if(parent[s]!=-1 && low[v]>=disc[s]){
                ap[s] = true;
            }
        }else if(parent[s]!=v){
            low[s] = min(low[s],disc[v]);
        }
    }
}
void Graph::AP(){
    bool visited[V];
    int parent[V];
    bool ap[V];
    int disc[V];
    int low[V];
    for(int i=0;i<V;i++){
        parent[i] = -1;
        ap[i] = 0;
        visited[i] = 0;
    }
    int time = 0;
    for(int i=0;i<V;i++){
        if(!visited[i]){
            APUtil(time,i,visited,disc,low,parent,ap);
        }
    }
    for(int i=0;i<V;i++){
        if(ap[i] == true){
            cout<<i<<" ";
        }
    }
}
int main(){

    cout << "\nArticulation points in first graph \n"; 
    Graph g1(5); 
    g1.addEdge(1, 0); 
    g1.addEdge(0, 2); 
    g1.addEdge(2, 1); 
    g1.addEdge(0, 3); 
    g1.addEdge(3, 4); 
    g1.AP(); 
  
    cout << "\nArticulation points in second graph \n"; 
    Graph g2(4); 
    g2.addEdge(0, 1); 
    g2.addEdge(1, 2); 
    g2.addEdge(2, 3); 
    g2.AP(); 
  
    cout << "\nArticulation points in third graph \n"; 
    Graph g3(7); 
    g3.addEdge(0, 1); 
    g3.addEdge(1, 2); 
    g3.addEdge(2, 0); 
    g3.addEdge(1, 3); 
    g3.addEdge(1, 4); 
    g3.addEdge(1, 6); 
    g3.addEdge(3, 5); 
    g3.addEdge(4, 5); 
    g3.AP(); 
  
    return 0; 
}
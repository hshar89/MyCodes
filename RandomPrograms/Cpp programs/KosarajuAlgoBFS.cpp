#include<bits/stdc++.h>
using namespace std;
class Graph{
    int V;
    list<int> *adj;
    void BFSUtil(int s, int visited[]);
    public:
    Graph(int V){
        this->V = V;
        adj = new list<int>[V];
    }
    Graph getTranspose();
    void addEdge(int u, int v);
    bool isSC();
};
void Graph::addEdge(int u, int v){
    adj[u].push_back(v);
}
void Graph::BFSUtil(int s, int visited[]){
    queue<int> q;
    q.push(s);
    visited[s] = true;
    while(!q.empty()){
        int tmp = q.front();
        q.pop();
        for(auto i= adj[tmp].begin();i!=adj[tmp].end();i++){
            if(!visited[*i]){
                visited[*i]= true;
                q.push(*i);
            }
        }
    }
}
Graph Graph::getTranspose(){
    Graph g1(V);
    for(int i=0;i<V;i++){
        for(auto it=adj[i].begin();it!=adj[i].end();it++){
            g1.adj[*it].push_back(i);
        }
    }
    return g1;
}
bool Graph::isSC(){

    int visited[V];
    memset(visited,0,sizeof(visited));
    BFSUtil(0, visited);
    for(int i=0;i<V;i++){
        if(visited[i] == false){
            return false;
        }
    }
    Graph gr = getTranspose();
    memset(visited,0,sizeof(visited));
    gr.BFSUtil(0,visited);
    for(int i=0;i<V;i++){
        if(visited[i] == false){
            return false;
        }
    }
    return true;
}
int main(){
     // Create graphs given in the above diagrams 
    Graph g1(5); 
    g1.addEdge(0, 1); 
    g1.addEdge(1, 2); 
    g1.addEdge(2, 3); 
    g1.addEdge(3, 0); 
    g1.addEdge(2, 4); 
    g1.addEdge(4, 2); 
    g1.isSC()? cout << "Yes\n" : cout << "No\n"; 
  
    Graph g2(4); 
    g2.addEdge(0, 1); 
    g2.addEdge(1, 2); 
    g2.addEdge(2, 3); 
    g2.isSC()? cout << "Yes\n" : cout << "No\n"; 
  
    return 0; 
}
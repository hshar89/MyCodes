#include<bits/stdc++.h>
using namespace std;
#define pr pair<int,int>
class Graph{
    int V;
    list<pr> *adj;
    public:
    Graph(int V){
        this->V= V;
        adj = new list<pr>[V];
    }
    void addEdge(int u, int v, int dist);
    void shortestPath(int src);
};
void Graph::addEdge(int u, int v, int dist){
    adj[u].push_back(make_pair(v,dist));
    adj[v].push_back(make_pair(u,dist));
}
void Graph::shortestPath(int src){
    int dis[V];
    int spt[V];
    priority_queue<pr,vector<pr>,greater<pr>> pq;
    for(int i=0;i<V;i++){
        dis[i] = INT_MAX;
        spt[i] = false;
        pq.push(make_pair(dis[i],i));
    }
    dis[src] = 0;
    pq.push(make_pair(0,src));
   while(!pq.empty()){
       int u = pq.top().second;
       pq.pop();
       spt[u] = true;
       for(auto i= adj[u].begin();i!=adj[u].end();i++){
           int v = (*i).first;
           int weight = (*i).second;
           if(spt[v]==false && dis[v]>dis[u]+weight){
               dis[v] = dis[u]+weight;
                pq.push(make_pair(dis[v],v));
           }
       }
   }
   // Print shortest distances stored in dist[] 
    printf("Vertex Distance from Source\n"); 
    for (int i = 0; i < V; ++i) 
        printf("%d \t\t %d\n", i, dis[i]);
}
int main(){
    // create the graph given in above fugure 
    int V = 9; 
    Graph g(V); 
  
    //  making above shown graph 
    g.addEdge(0, 1, 4); 
    g.addEdge(0, 7, 8); 
    g.addEdge(1, 2, 8); 
    g.addEdge(1, 7, 11); 
    g.addEdge(2, 3, 7); 
    g.addEdge(2, 8, 2); 
    g.addEdge(2, 5, 4); 
    g.addEdge(3, 4, 9); 
    g.addEdge(3, 5, 14); 
    g.addEdge(4, 5, 10); 
    g.addEdge(5, 6, 2); 
    g.addEdge(6, 7, 1); 
    g.addEdge(6, 8, 6); 
    g.addEdge(7, 8, 7); 
  
    g.shortestPath(0); 
  
    return 0; 
}
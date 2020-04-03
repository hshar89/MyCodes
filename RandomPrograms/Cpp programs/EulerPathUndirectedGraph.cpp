#include<bits/stdc++.h>
using namespace std;
class Graph{
    int V;
    list<int> *adj;
    public:
    Graph(int V){
        this->V = V;
        adj = new list<int>[V];
    }
    void addEdge(int v, int u){
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    void dfsUtil(int s, int visited[]);
    bool isConnected();
    int isEulerian();
};
void Graph::dfsUtil(int s, int visited[]){
    visited[s] = true;
    for(auto it: adj[s]){
        if(!visited[it]){
            dfsUtil(it,visited);
        }
    }
}
bool Graph::isConnected(){
    int i;
    for(i=0;i<V;i++){
        if(adj[i].size()!=0){
            break;
        }
    }
    if(i==V){
        return true;
    }
    int visited[V];
    for(int i=0;i<V;i++){
        visited[i] = false;
    }
    dfsUtil(i,visited);

    for(int i=0;i<V;i++){
        if(visited[i] == false && adj[i].size()>0){
            return false;
        }
    }
    return true;
}
/* The function returns one of the following values 
   0 --> If grpah is not Eulerian 
   1 --> If graph has an Euler path (Semi-Eulerian) 
   2 --> If graph has an Euler Circuit (Eulerian)  */
int Graph::isEulerian(){
    if(isConnected()==false){
        return 0;
    }

    int oddCount = 0;
    for(int i=0;i<V;i++){
        if(adj[i].size()&1){
            oddCount++;
        }
    }
    // If count is more than 2, then graph is not Eulerian
    if(oddCount>2){
        return false;
    }
    // If odd count is 2, then semi-eulerian. 
    // If odd count is 0, then eulerian 
    // Note that odd count can never be 1 for undirected graph
    return oddCount?1:2;
}
void test(Graph &g){
    int res = g.isEulerian(); 
    if (res == 0) 
        cout << "graph is not Eulerian\n"; 
    else if (res == 1) 
        cout << "graph has a Euler path\n"; 
    else
        cout << "graph has a Euler cycle\n";
}
int main(){
  
  // Let us create and test graphs shown in above figures 
    Graph g1(5); 
    g1.addEdge(1, 0); 
    g1.addEdge(0, 2); 
    g1.addEdge(2, 1); 
    g1.addEdge(0, 3); 
    g1.addEdge(3, 4); 
    test(g1); 
  
    Graph g2(5); 
    g2.addEdge(1, 0); 
    g2.addEdge(0, 2); 
    g2.addEdge(2, 1); 
    g2.addEdge(0, 3); 
    g2.addEdge(3, 4); 
    g2.addEdge(4, 0); 
    test(g2); 
  
    Graph g3(5); 
    g3.addEdge(1, 0); 
    g3.addEdge(0, 2); 
    g3.addEdge(2, 1); 
    g3.addEdge(0, 3); 
    g3.addEdge(3, 4); 
    g3.addEdge(1, 3); 
    test(g3); 
  
    // Let us create a graph with 3 vertices 
    // connected in the form of cycle 
    Graph g4(3); 
    g4.addEdge(0, 1); 
    g4.addEdge(1, 2); 
    g4.addEdge(2, 0); 
    test(g4); 
  
    // Let us create a graph with all veritces 
    // with zero degree 
    Graph g5(3); 
    test(g5); 
}
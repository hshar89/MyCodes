#include<bits/stdc++.h>
using namespace std;
enum Color{WHITE,GRAY,BLACK};
struct Graph{
    list<int> *adj;
    int N;
    Graph(int size){
        N = size+1;
        adj = new list<int>[N+1];
    }
    void addEdge(int u, int v);
    bool isCyclic();
    bool isCyclicUtil(int s, Color color[]);
};
void Graph::addEdge(int u, int v){
    adj[u].push_back(v);
}
bool Graph::isCyclicUtil(int s, Color color[]){
     color[s] = GRAY;
     for(auto i = adj[s].begin();i!=adj[s].end();i++){
         if(color[*i]==GRAY){
             return true;
         }
         if(color[*i]==WHITE && isCyclicUtil(*i,color)){
             return true;
         }
     }
     color[s] = BLACK;
     return false;
}
bool Graph::isCyclic(){
    Color color[N+1];
    for(int i=1;i<=N;i++){
        color[i] = WHITE;
    }
    for(int i=1;i<=N;i++){
        if(color[i]==WHITE){
            if(isCyclicUtil(i,color)){
                return true;
            }
        }
    }
    return false;
}
int main(){
    Graph g(4);
    g.addEdge(1, 2); 
    g.addEdge(1, 3); 
    g.addEdge(2, 3); 
    g.addEdge(3, 1); 
    g.addEdge(3, 4); 
    //g.addEdge(4, 4); 
  
    if (g.isCyclic()) 
        cout << "Graph contains cycle"; 
    else
        cout << "Graph doesn't contain cycle"; 
  
    return 0;
}


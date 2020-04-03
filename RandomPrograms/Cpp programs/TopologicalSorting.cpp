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
    void addEdge(int u, int v){
        adj[u].push_back(v);
    }
    void topologicalSort();
    void dodfs(int s, int visited[], stack<int> &st);
};
void Graph::dodfs(int s, int visited[], stack<int> &st){
    visited[s] = true;
    for(auto it: adj[s]){
        if(!visited[it]){
            dodfs(it,visited,st);
        }
    }
    st.push(s);
}
void Graph::topologicalSort(){
   
   int visited[V];
   for(int i=0;i<V;i++){
       visited[i] = false;
   }
   stack<int> st;
   for(int i=0;i<V;i++){
       if(!visited[i])
   dodfs(i,visited,st);
   }
   while(!st.empty()){
       cout<<st.top()<<" ";
       st.pop();
   }
}
int main(){

    Graph g(6);
    g.addEdge(5, 2); 
    g.addEdge(5, 0); 
    g.addEdge(4, 0); 
    g.addEdge(4, 1); 
    g.addEdge(2, 3); 
    g.addEdge(3, 1); 
  
    cout << "Following is a Topological Sort of the given graph \n"; 
    g.topologicalSort(); 
    cout<<"Second graph \n";
    Graph g1(6);
    g1.addEdge(4,0);
    g1.addEdge(0,2);
    g1.addEdge(2,5);
    g1.addEdge(1,2);
    g1.addEdge(3,1);
    g1.addEdge(0,3);
    g1.addEdge(4,5);
    g1.topologicalSort();
    cout<<endl;
}
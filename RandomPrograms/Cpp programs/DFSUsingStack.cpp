#include<bits/stdc++.h>
using namespace std;
struct Graph{
    list<int> *adj;
    int N;
    Graph(int size){
        N = size+1;
        adj = new list<int>[N];
    }
    void addEdge(int u, int v);
    void DFS();
};
void Graph::addEdge(int u, int v){
    adj[u].push_back(v);
    adj[v].push_back(u);
}
void DFSUtil(list<int> adj[], int visited[], int s){
    stack<int> st;
    st.push(s);
    //visited[s] = true;
    while(!st.empty()){
        int u = st.top();
        st.pop();
        if(!visited[u]){
            visited[u] = true;
            cout<<u<<" ";
        }
        for(auto it: adj[u]){
            if(!visited[it]){
                st.push(it);
            }
        }
    }
}
void Graph::DFS(){
   int visited[N];
   memset(visited,0,sizeof(visited));
   for(int i=1;i<N;i++){
      if(!visited[i]){
          DFSUtil(adj,visited,i);
      }
   }
}
int main(){
    Graph g(7);
    g.addEdge(1,4);
    g.addEdge(1,5);
    g.addEdge(4,5);
    g.addEdge(4,2);
    g.addEdge(2,5);
    g.addEdge(3,4);
    g.addEdge(6,7);

    g.DFS();
}
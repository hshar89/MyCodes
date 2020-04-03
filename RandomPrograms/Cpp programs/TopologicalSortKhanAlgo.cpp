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
void Graph::topologicalSort(){
    int indegree[V];
    memset(indegree,0,sizeof(indegree));
    for(int i=0;i<V;i++){
        for(auto it: adj[i]){
            indegree[it]++;
        }
    }
    queue<int> q;
    int cnt = 0;
    for(int i=0;i<V;i++){
        if(indegree[i] == 0){
            q.push(i);
        }
    }
    vector<int> top_order;
    while(!q.empty()){
        int top = q.front();
        q.pop();
        top_order.push_back(top);
        for(auto it: adj[top]){
            if(--indegree[it] == 0){
                q.push(it);
            }
        }
        cnt++;
    }
    if(cnt != V){
        cout << "There exists a cycle in the graph\n"; 
        return;
    }
     // Print topological order 
    for (int i=0; i<top_order.size(); i++) 
        cout << top_order[i] << " "; 
    cout<<endl;
}
int main(){
    Graph g(6);
    g.addEdge(5,0);
    g.addEdge(5,2);
    g.addEdge(2,3);
    g.addEdge(3,1);
    g.addEdge(4,1);
    g.addEdge(4,0);
    g.topologicalSort();
}
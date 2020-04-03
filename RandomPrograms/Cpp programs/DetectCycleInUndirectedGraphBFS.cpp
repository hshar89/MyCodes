#include<bits/stdc++.h>
using namespace std;
void addEdge(vector<int> adj[], int u, int v){
    adj[u].push_back(v);
    adj[v].push_back(u);
}
void isCyclicUtil(vector<int> adj[], int s, int n, bool visited[],unordered_set<int> &st){
    visited[s] = true;
    queue<int> q;
    int parent[n+1];
    memset(parent,-1,sizeof(parent));
    q.push(s);
    while(!q.empty()){
        int u = q.front();
        q.pop();
        for(auto it: adj[u]){
            if(!visited[it]){
                visited[it] =true;
                parent[it] = u;
                q.push(it);
            }else if(parent[u]!=it){
                //return true;
                //cout<<"inserting it: "<<it<<" "<<"u: "<<u<<" ";
                st.insert(it);
                st.insert(parent[u]);
            }
        }
    }
}
void containsCycle(vector<int> adj[], int n){
    bool visited[n+1];
    unordered_set<int> s;
    memset(visited,0,sizeof(visited));
    for(int i=1;i<=n;i++){
       if(!visited[i]){
           isCyclicUtil(adj,i,n,visited,s);
       }
    }
    cout<<"\n";
   for(auto i: s){
      cout<<"i: "<<i<<" ";
    }
}
int main(){
    int n = 8;
    vector<int> adj[n+1];
    addEdge(adj,1,2);
    addEdge(adj,2,3);
    addEdge(adj,1,3);
    addEdge(adj,3,4);
    addEdge(adj,5,6);
    addEdge(adj,6,7);
    addEdge(adj,7,8);
    addEdge(adj,6,8);
    cout<<"printing cycle nodes ";
    containsCycle(adj,n);
    cout<<"\ndone ";
}
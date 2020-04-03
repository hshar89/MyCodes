#include<bits/stdc++.h>
using namespace std;
#define M 1000
vector<int> adj[M];
vector<int> cadj[M];
void addEdge(int u, int v){
    adj[u].push_back(v);
}

void doDFS(int visited[], stack<int> &st, int s){
    visited[s] = 1;
    for(int i=0;i<adj[s].size();i++){
        if(!visited[adj[s][i]]){
            doDFS(visited,st,adj[s][i]);
        }
    }
    st.push(s);
}
void doDFSUtil(int visited[], int s){
  visited[s] = 1;
  cout<<s<<" ";
  for(int i=0;i<cadj[s].size();i++){
      if(!visited[cadj[s][i]]){
          doDFSUtil(visited,cadj[s][i]);
      }
  }
}
void reverseGraph(int n){
    for(int i=1;i<=n;i++){
        for(int j=0;j<adj[i].size();j++){
            cadj[adj[i][j]].push_back(i);
        }
    }
}
int main(){
    int n = 11;
    addEdge(2,1);
    addEdge(3,2);
    addEdge(1,3);
    addEdge(3,4);
    addEdge(4,5);
    addEdge(5,6);
    addEdge(6,4);
    addEdge(7,6);
    addEdge(7,9);
    addEdge(9,10);
    addEdge(10,8);
    addEdge(8,7);
    addEdge(8,11);
    int visited[n+1];
    memset(visited,0,sizeof(visited));
    stack<int> st;
    for(int i=1;i<=n;i++){
        if(!visited[i]){
    doDFS(visited,st,i);
        }
    }
    reverseGraph(n);
    memset(visited,0,sizeof(visited));
    while(!st.empty()){
        int temp = st.top();
        st.pop();
        if(!visited[temp]){
            doDFSUtil(visited,temp);
            cout<<"\n";
        }
    }
}
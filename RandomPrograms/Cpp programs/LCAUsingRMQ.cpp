#include<bits/stdc++.h>
using namespace std;
#define M 1000
int level[M] = {0};
vector<int> g[M];
vector<int> e;
vector<int> l;
int h[M];
int st[5*M];
void add_edge(int u, int v){
    g[u].push_back(v);
    g[v].push_back(u);
}
void leveling(int src){

    for(int i=0;i<g[src].size();i++){
        int dest = g[src][i];
        if(!level[dest]){
            level[dest] = level[src]+1;
            leveling(dest);
        }
    }
}
void dfs(int src, int visited[]){
    e.push_back(src);
    visited[src] = 1;
    for(int i=0;i<g[src].size();i++){
        int dest = g[src][i];
        if(!visited[dest]){
            dfs(dest,visited);
            e.push_back(src);
        }
    }
}
void setting_h(int n){
    for(int i=0;i<=n;i++){
        h[i] = -1;
    }
    for(int i=0;i<e.size();i++){
        if(h[e[i]]==-1){
            h[e[i]] = i;
        }
    }
}
void setting_l(){   
   for(int i=0;i<e.size();i++){
       l.push_back(level[e[i]]);
   }
}
void construct_SegmentTree(int ss, int se, int si){
    if(ss>se){
        return;
    }
  if(ss == se){
      st[si] = ss;
      return;
  }
  int mid = ss+se>>1;
  construct_SegmentTree(ss,mid,2*si+1);
  construct_SegmentTree(mid+1,se,2*si+2);
  if(l[st[2*si+1]]<l[st[2*si+2]]){
      st[si] = st[2*si+1];
  }else{
      st[si] = st[2*si+2];
  }
}
int RMQ(int ss, int se, int x, int y, int si){
   if(x>y || x>se || y<ss){
       return -1;
   }
   if(x<=ss && y>=se){
       return st[si];
   }
   int mid = ss+se>>1;
   int left = RMQ(ss,mid,x,y,2*si+1);
   int right = RMQ(mid+1,se,x,y,2*si+2);
   if(left != -1 && right!=-1){
       if(l[left]<l[right]){
           return left;
       }else{
           return right;
       }
   }else if(left!= -1){
       return left;
   }else if(right!=-1){
       return right;
   }
}
int LCA(int x, int y){
    if(h[x]>h[y]){
        swap(x,y);
    }
    return e[RMQ(0,l.size()-1,h[x],h[y],0)];
}
int main(){
    int n =15,q=5;
    add_edge(1, 2); 
    add_edge(1, 3); 
    add_edge(1, 4); 
    add_edge(3, 5); 
    add_edge(4, 6); 
    add_edge(5, 7); 
    add_edge(5, 8); 
    add_edge(5, 9); 
    add_edge(7, 10); 
    add_edge(7, 11); 
    add_edge(7, 12); 
    add_edge(9, 13); 
    add_edge(9, 14); 
    add_edge(12, 15); 
    level[1] = 1;
    leveling(1);

    int visited[n+1];
    memset(visited,0,sizeof(visited));
    dfs(1,visited);
    setting_l();

    setting_h(n);

    construct_SegmentTree(0,e.size()-1,0);
    for(int i=0;i<e.size();i++){
        cout<<e[i]<<" ";
    }
    cout<<"\n";
    for(int i=0;i<l.size();i++){
        cout<<l[i]<<" ";
    }
    cout<<"\n";
    for(int i=1;i<=n;i++){
        cout<<h[i]<<" ";
    }
    cout<<"\n";
    cout << LCA(10, 15) << endl; 
    cout << LCA(11, 14) << endl;
    cout << LCA(8,14) <<"\n";
}
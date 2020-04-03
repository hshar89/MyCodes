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
        adj[v].push_back(u);
    }
    void removeEdge(int u, int v);
    int DFSCount(int s, bool visited[]);
    void printEulerTour();
    void printEulerTourUtil(int s);
    bool isValidNextEdge(int u, int v);
};
bool Graph::isValidNextEdge(int u, int v){
    int count = 0;
    for(auto it : adj[u]){
        if(it != -1){
            count++;
        }
    }
    if(count == 1){
        return true;
    }
    bool visited[V];
    memset(visited,0,sizeof(visited));
    int count1 = DFSCount(u,visited);

    removeEdge(u,v);
    memset(visited,0,sizeof(visited));
    int count2 = DFSCount(u,visited);
    addEdge(u,v);
    return count1 == count2?true:false;
}
int Graph::DFSCount(int s, bool visited[]){
    visited[s] = true;
    int count = 1;
    for(auto it = adj[s].begin();it!=adj[s].end();it++){
        if(*it!= -1 && !visited[*it]){
            count+=DFSCount(*it,visited);
        }
    }
    return count;
}
void Graph::printEulerTour(){
    int u =0;
    for(int i=0;i<V;i++){
        if(adj[i].size()&1){
            u = i;
            break;
        }
    }
    printEulerTourUtil(u);
    cout<<endl;
}
void Graph::removeEdge(int u, int v){
    list<int>::iterator iv = find(adj[u].begin(),adj[u].end(),v);
    *iv = -1;
    list<int>::iterator iu = find(adj[v].begin(),adj[v].end(),u);
    *iu = -1;
}
void Graph::printEulerTourUtil(int s){
    for(auto it=adj[s].begin();it!=adj[s].end();it++){
        int v = *it;
        if(v!=-1 && isValidNextEdge(s,v)){
            cout<<s<<"-"<<v<<" ";
            removeEdge(s,v);
            printEulerTourUtil(v);
        }
    }
}
int main(){
    // Let us first create and test graphs shown in above figure 
  Graph g1(4); 
  g1.addEdge(0, 1); 
  g1.addEdge(0, 2); 
  g1.addEdge(1, 2); 
  g1.addEdge(2, 3); 
  g1.printEulerTour(); 
  
  Graph g2(3); 
  g2.addEdge(0, 1); 
  g2.addEdge(1, 2); 
  g2.addEdge(2, 0); 
  g2.printEulerTour(); 
  
  Graph g3(5); 
  g3.addEdge(1, 0); 
  g3.addEdge(0, 2); 
  g3.addEdge(2, 1); 
  g3.addEdge(0, 3); 
  g3.addEdge(3, 4); 
  g3.addEdge(3, 2); 
  g3.addEdge(3, 1); 
  g3.addEdge(2, 4); 
  g3.printEulerTour(); 
  return 0;
}
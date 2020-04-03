#include<bits/stdc++.h>
using namespace std;
const int MAX = 100000;
vector<int> cycles[MAX];
struct Graph{
    list<int> *adj;
    int N;
    Graph(int size){
        N =size+1;
        adj = new list<int>[size+1];
    }
    void addEdge(int u,int v);
    void dfs_cycle(int s, int p, int color[], int mark[], int parent[], int &cycleNumber);
    void bfs_cycle(int s);
};
void Graph::addEdge(int u, int v){
    adj[u].push_back(v);
    adj[v].push_back(u);
}

void Graph::dfs_cycle(int s, int p, int color[], int mark[], int parent[], int &cycleNumber){
   
   if(color[s] == 2){
       return;
   }
   
   if(color[s] == 1){
       cycleNumber++;
       int cur = p;
       mark[cur] = cycleNumber;

       while(cur!=s){
           cur = parent[cur];
           mark[cur] = cycleNumber;
       }
       return;
   }
   parent[s] = p;
   color[s] = 1;

   for(int v: adj[s]){
       if(v==parent[s]){
           continue;
       }
    dfs_cycle(v,s,color,mark,parent,cycleNumber);
   }
   color[s] = 2;
}
// Function to print the cycles 
void printCycles(int edges, int mark[], int& cyclenumber) 
{ 
  
    // push the edges that into the 
    // cycle adjacency list 
    for (int i = 1; i <= edges; i++) { 
        if (mark[i] != 0) 
            cycles[mark[i]].push_back(i); 
    } 
  
    // print all the vertex with same cycle 
    for (int i = 1; i <= cyclenumber; i++) { 
        // Print the i-th cycle 
        cout << "Cycle Number " << i << ": "; 
        for (int x : cycles[i]) 
            cout << x << " "; 
        cout << endl; 
    } 
} 
int main(){
   int n = 13;
   Graph g(n);
   g.addEdge(1,2);
   g.addEdge(2,3);
   g.addEdge(3,4);
   g.addEdge(4,6);
   g.addEdge(4,7);
   g.addEdge(5,6);
   g.addEdge(3,5);
   g.addEdge(7,8);
   //g.addEdge(6,10);
   g.addEdge(5,9);
   g.addEdge(10,11);
   g.addEdge(11,12);
   g.addEdge(11,13);
   g.addEdge(12,13);

   int color[n+1];
   int parent[n+1];
   int mark[n+1];
   int cycleNumber;
   int edges = 13;
    for(int i=1;i<=n;i++){
        color[i] = 0;
        parent[i] = 0;
        mark[i] = 0;
    }
    for(int i=1;i<=n;i++){
    if(color[i] == 0){
    g.dfs_cycle(i,0,color,mark,parent,cycleNumber);
    }
    }  
   // function to print the cycles 
    printCycles(edges, mark, cycleNumber);
}
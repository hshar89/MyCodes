// A C++ program to find articulation points in an undirected graph 
#include<iostream> 
#include <list> 
#define NIL -1 
using namespace std;

class Graph{
 int V;
 list<int> *adj;
 APUtil(int *time, int s, bool visited[], bool ap[], int desc[],int low[]);
 public:
 Graph(int V);
 void addEdge(int u, int v);
 void AP();
};
Graph::createGraph(int V){
   this->V=V;
   adj = new list<int>[V];
}
void Graph::addEdge(int u, int v){
	adj[u].push_back(v);
	adj[v].push_back(u);
}
void Graph::AP(){
	int time = 0;
	int s = 0;
	bool visites[V];
	bool ap[V];
	int low[V];
	int disc[V];
	int parent[V];
	 // Initialize parent and visited, and ap(articulation point) arrays 
    for (int i = 0; i < V; i++) 
    { 
        parent[i] = -1; 
        visited[i] = false; 
        ap[i] = false; 
    } 
	// Call the recursive helper function to find articulation points 
    // in DFS tree rooted with vertex 'i' 
    for (int i = 0; i < V; i++){ 
        if (visited[i] == false){ 
	APUtil(&time,s,visited,ap,disc,low,parent);
		}
	}
	// Now ap[] contains articulation points, print them 
    for (int i = 0; i < V; i++) 
        if (ap[i] == true) 
            cout << i << " ";
}
void Graph::APUtil(int *time, int s, bool visited[], bool ap[], int disc[], int low[], int parent[]){
	
	visited[s] = true;
	*time = *time+1;
	disc[s] = low[s] = time;
	int children=0;
	list<int>::iterator i;
	for(i=adj.begin();i!=adj.end();i++){
		int v = *i;
		if(!visited[v]){
			children++;
			parent[v] = s;
			APUtil(time,v,visited,ap,disc,low,parent);
            low[s] = min(low[s],low[v]);
			if(parent[s]==-1 && children>1){
				ap[s] = true;
			}
			if(parent[s]!=-1 && low[v]>=disc[s]){
				ap[s] =true;
			}
		}else if(parent[s]!=v){
             low[s] = min(low[s],disc[v]);
        }
	}
}	
/ Driver program to test above function 
int main() 
{ 
    // Create graphs given in above diagrams 
    cout << "\nArticulation points in first graph \n"; 
    Graph g1(5); 
    g1.addEdge(1, 0); 
    g1.addEdge(0, 2); 
    g1.addEdge(2, 1); 
    g1.addEdge(0, 3); 
    g1.addEdge(3, 4); 
    g1.AP(); 
  
    cout << "\nArticulation points in second graph \n"; 
    Graph g2(4); 
    g2.addEdge(0, 1); 
    g2.addEdge(1, 2); 
    g2.addEdge(2, 3); 
    g2.AP(); 
  
    cout << "\nArticulation points in third graph \n"; 
    Graph g3(7); 
    g3.addEdge(0, 1); 
    g3.addEdge(1, 2); 
    g3.addEdge(2, 0); 
    g3.addEdge(1, 3); 
    g3.addEdge(1, 4); 
    g3.addEdge(1, 6); 
    g3.addEdge(3, 5); 
    g3.addEdge(4, 5); 
    g3.AP(); 
  
    return 0; 
} 	
	
#include <bits/stdc++.h>
using namespace std;
#define MAX 300005
struct edge{
	int src,dest;
	edge(int src,int dest){
		this->src = src;
		this->dest = dest;
	}
    //sorting the edges on basis of src and dest
    //Both are required to provide set.find() functionality
	bool operator<(const edge &e1)const{
		if(e1.src == src){
			return dest<e1.dest;
		}
		return src<e1.src;
	}
};
class Graph{
	int V;
	list<int> *adj;
	public:
	Graph(int V){
		this->V = V;
		adj = new list<int>[V];
	}
	void dfs(int s, int &time);
	void addEdge(int u, int v);
	void findAPandBridge();
	int id(int a, int u);
	bool desc(int a, int u);
};
void Graph::addEdge(int u, int v){
	adj[u].push_back(v);
	adj[v].push_back(u);
}
inline int read()
{
	char c;
	int n = 0;
	while ((c = getchar()) < 48)	;
	n += (c - '0');
	while ((c = getchar()) >= 48)
		n = n * 10 + (c - '0');
	return n;
}
//discovery time
int disc[MAX];
//lowest time the vertex can reach
int low[MAX];
//finish time for the vertex
int finish[MAX];
int parent[MAX];
//is articulation point?
bool ap[MAX];
//store bridges
set<edge> st;
void Graph::dfs(int s, int &time){
	disc[s] = low[s] = ++time;
	int children=0;
	for(auto it = adj[s].begin();it!=adj[s].end();it++){
		int v =*it;
		if(disc[v] == -1){
			parent[v] = s;
			dfs(v,time);
			children++;
			
			low[s] = min(low[s],low[v]);
			
			if(low[v]>disc[s]){
				if(s>v){
				st.insert(edge(v,s));
				}else{
				st.insert(edge(s,v));
				}
			}
			if(parent[s] == -1 && children>1){
				ap[s] = true;
			}
			if(parent[s] !=-1 && disc[s]<=low[v]){
				ap[s]= true;
			}
		}else if(v != parent[s]){
			low[s] = min(low[s],disc[v]);
		}
	}
	finish[s] = ++time;
}
void Graph::findAPandBridge(){
	int time = 0;
	for(int i=0;i<V;i++){
		parent[i] = -1;
		disc[i]=low[i] =-1;
		finish[i] = -1;
		ap[i] = false;
	}
	for(int i=0;i<V;i++){
		if(disc[i] == -1){
			dfs(i,time);
		}
	}
}
//check if for the given two vertex the vertex a is an child(not direct necessarily) of vertex v
//this helps in finding whether the bridge is critical for the vertexes a and b
bool Graph::desc(int a, int u){
	return disc[a]>=disc[u] && finish[a]<=finish[u];
}
//to find if the vertex is critical for path between a and b
int Graph::id(int a, int u){
    //if vertex a is one of the childs (not direct necessarily) then check 
    //for upper bound of discovery time in the direct childs of v
	if(desc(a,u)){
        //the lambda function sorts according to discovery time and then find the upper bound
		int p = *prev(upper_bound(adj[u].begin(),adj[u].end(),a,[](int x, int y){return disc[x]<disc[y];}));
        //if the previous of the upper bound has a low time greater than the discovery of the vertex v
        //then this vertex acts as a bridge for the vertex p
		if(low[p]>=disc[u]){
			return p;
		}
		return -1;
	}
	return -1;
}
int main() {
	// your code goes here
	int n,m,u,v,q,t,a,b,g1,g2,c;
	n = read();
	m = read();
	Graph g(n);
	for(int i=0;i<m;i++){
		u= read()-1;
		v = read()-1;
		g.addEdge(u,v);
	}
	int count = 0;
	g.findAPandBridge();
	q = read();
	for(int i=0;i<q;i++){
		t = read();
		if(t == 1){ 
			a = read()-1;
			b = read()-1;
			g1 = read()-1;
			g2 = read()-1;
			if(g1>g2){
				swap(g1,g2);
			}
            //if not a bridge then path exists between a and b
			if(st.find(edge(g1,g2)) != st.end()){
                //just take vertex with greater discovery time
				if(disc[g1]>disc[g2]){
					swap(g1,g2);
				}
                 //if a bridge then look whether this is a bridge for the given vertexes a and b
				if(g.desc(a,g2) == g.desc(b,g2)){
					cout<<"da\n";
				}else{
					cout<<"ne\n";
				}
			}else{
				cout<<"da\n";
			}
		}else{
			a = read()-1;
			b = read()-1;
			c = read()-1;
            //if not in articulation point then path exists between a and b without c
			if(ap[c]){
                //if an articulation point then check below
			 if(g.id(a,c) == g.id(b,c)){
			 	cout<<"da\n";
			 }else{
			 	cout<<"ne\n";
			 }
			}else{
				cout<<"da\n";
			}
		}
	}
	return 0;
}
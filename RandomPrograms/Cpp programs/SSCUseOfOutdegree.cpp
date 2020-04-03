#include <bits/stdc++.h>
using namespace std;
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
class Graph{
	int V;
	list<int> *adj;
	public:
	vector<vector<int>> ssc;
	int *sscindex;
	Graph(int V){
		this->V = V;
		adj = new list<int>[V];
	    sscindex = new int[V];
	}
	void addEdge(int u, int v){
		adj[u].push_back(v);
	}
	void dfs(int s, int disc[], int low[], int stackMem[], int &time, stack<int> &st, int &ssci);
	void findSSCs();
	int dfsCheck(int s, bool visited[]);
};
void Graph::dfs(int s, int disc[], int low[], int stackMem[], int &time, stack<int> &st, int &ssci){
	disc[s] = low[s] = ++time;
	stackMem[s] = true;
	st.push(s);
	for(auto it: adj[s]){
		if(disc[it]==-1){
			dfs(it,disc,low,stackMem,time,st,ssci);
			low[s] = min(low[s],low[it]);
			
		}else if(stackMem[it] == true){
			low[s] = min(low[s],disc[it]);
		}
	}
	if(low[s] == disc[s]){
		while(st.top()!=s){
			int u = st.top();
			st.pop();
			stackMem[u] = false;
			sscindex[u] = ssci;
		}
		int u = st.top();
		st.pop();
		stackMem[u] = false;
		sscindex[u] = ssci;
		ssci++;
	}
}
void Graph::findSSCs(){
	int disc[V];
	int low[V];
	stack<int> st;
	int stackMem[V];
	for(int i=0;i<V;i++){
		disc[i] = low[i] = -1;
		stackMem[i] = false;
	}
	int time=0,ssci=0;
	for(int i=0;i<V;i++){
		if(disc[i] == -1){
			dfs(i,disc,low,stackMem,time,st,ssci);
		}
	}
}
int Graph::dfsCheck(int s, bool visited[]){
	visited[s] = true;
	int ret = 0;
	for(auto i: adj[s]){
		if(!visited[i]){
			ret+=dfsCheck(i,visited);
		}
	}
	return ret+1;
}
int main() {
	// your code goes here
	int n,m,u,v;
	int t = read();
	while(t--){
	n = read();
	m = read();
	Graph g(n);
	Graph revg(n);
	pair<int,int> edges[m];
	for(int i=0;i<m;i++){
		u = read()-1;
		v = read()-1;
		g.addEdge(u,v);
        //create a reverge graph
		revg.addEdge(v,u);
        //add edges for calculating outdegree of components
		edges[i] = make_pair(u,v);
	}
    //find all sccs and index them 
	g.findSSCs();
    //Find outdegrees for each scc component
	int outdegree[n];
	for(int i=0;i<n;i++){
		outdegree[i] = 0;
		cout<<"i: "<<i<<" sscindex "<<g.sscindex[i]<<"\n";
	}
	for(int i=0;i<m;i++){
		//cout<<(edges[i].first+1)<<" "<<(edges[i].second+1)<<" ";
        //find scc index for each vertex in an edge and check if they 
        //belong to same component
		u = g.sscindex[edges[i].first];
		v = g.sscindex[edges[i].second];
		//cout<<"u: "<<u<<" v "<<v<<"\n";
        //If not to same component then increase outdegree for that scc
		if(u != v){
			outdegree[u]++;
		}
	}
	for(int i=0;i<n;i++){
        	cout<<"i: "<<(i+1)<<" sscindex[i] "<<g.sscindex[i]<<"\n";
        	cout<<"outdegree[i]: "<<outdegree[g.sscindex[i]]<<"\n";
        }
	int maxx = INT_MIN;
	for(int i=0;i<n;i++){
        //if the outdegree is zero for a scc then do dfs on a reverse graph 
        //and find count of all components that can be visited
		if(outdegree[g.sscindex[i]] == 0){
			bool visited[n];
			int count = 0;
			memset(visited,0,sizeof(visited));
			outdegree[g.sscindex[i]] = revg.dfsCheck(i,visited);
			//update outdegree according to maximum that a vertex in a component achieves
			maxx = max(maxx,outdegree[g.sscindex[i]]);
		}
	}
	
	for(int i=0;i<n;i++){
	 if(outdegree[g.sscindex[i]] == maxx){
	 	cout<<(i+1)<<" ";
	 }
	}
	cout<<endl;
	}
	return 0;
}
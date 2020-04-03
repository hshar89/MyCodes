#include <bits/stdc++.h>
using namespace std;
#define M 26
class Graph{
	int V;
	list<int> *adj;
	int *indegree;
	public:
	Graph(int V){
		this->V=V;
		adj= new list<int>[V];
		indegree = new int[V];
		for(int i=0;i<V;i++){
			indegree[i] = 0;
		}
	}
	void addEdge(int u, int v){
		adj[u].push_back(v);
		indegree[v]++;
	}
	bool isEulerPath();
	bool isSC();
	void DFSUtil(int s, bool visited[]);
};
void Graph::DFSUtil(int s, bool visited[]){
	visited[s] = true;
	for(auto it: adj[s]){
		if(!visited[it]){
			DFSUtil(it,visited);
		}
	}
}
bool Graph::isSC(){
	bool visited[V];
	for(int i=0;i<V;i++){
		visited[i] == false;
	}
	int n;
	for( n=0;n<V;n++){
		if(adj[n].size()>0){
			break;
		}
	}
	//cout<<"n: "<<(char)(n+'a')<<"\n";
	DFSUtil(n,visited);
	//cout<<"done dfs\n";
	for(int i=0;i<V;i++){
		//cout<<char(i+'a')<<"\n";
		if((visited[i]==false) && (adj[i].size()>0)){
			//cout<<"returning false\n";
			return false;
		}
	}
	return true;
}
bool Graph::isEulerPath(){
	//cout<<"checking connected\n";
	if(isSC() == false){
		//cout<<"returned false\n";
		return false;
	}
	vector<int> vc;
	for(int i=0;i<V;i++){
		if(adj[i].size()!=indegree[i]){
			vc.push_back(i);
		}
	}
	//cout<<"vc size "<<vc.size()<<"\n";
	if(vc.size()==0){
		return true;
	}
	if(vc.size()>2){
		return false;
	}
	//cout<<"first condition\n";
	//cout<<"vc[0]: "<<(char)(vc[0]+'a')<<" "<<(char)(vc[1]+'a')<<"\n";
	if(((indegree[vc[0]]- adj[vc[0]].size()) == -1) &&((indegree[vc[1]] - adj[vc[1]].size())==1)){
		return true;
	}
	cout<<"second condition\n";
	if(((indegree[vc[0]]- adj[vc[0]].size()) == 1) && ((indegree[vc[1]]-adj[vc[1]].size())== -1)){
		return true;
	}
	return false;
}
int main() {
	// your code goes here
		int n;
		string arr[] ={"king","geek","rat"};
        n = 3;
		Graph g(M);
        string tmp;
		for(int i=0;i<n;i++){
			tmp = arr[i];
			g.addEdge(tmp[0]-'a',tmp[tmp.length()-1]-'a');
		}
		if(g.isEulerPath()){
			cout<<"Ordering is possible."<<endl;
		}else{
			cout<<"The door cannot be opened."<<endl;
		}
}
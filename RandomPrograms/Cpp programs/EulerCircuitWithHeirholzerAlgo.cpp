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
    void printEulerCircuit();
};
void Graph::printEulerCircuit(){

    unordered_map<int,int> edges;
    for(int i=0;i<V;i++){
        edges.insert(make_pair(i,adj[i].size()));
    }
    stack<int> cur_path;
    vector<int> res;
    int curr = 0,next;
    cur_path.push(0);
    while(!cur_path.empty()){
        if(edges[curr]){

            next = adj[curr].back();
            adj[curr].pop_back();
            edges[curr]--;
            cur_path.push(curr);
            curr = next;
        }else{
            res.push_back(curr);
            curr= cur_path.top();
            cur_path.pop();
        }
    }

    for(int i=res.size()-1;i>=0;i--){
        cout<<res[i]<<" ";
    }
    cout<<endl;
}
int main(){

    Graph g1(3);
    g1.addEdge(0,1);
    g1.addEdge(1,2);
    g1.addEdge(2,0);
    g1.printEulerCircuit();

    Graph g2(7);
    g2.addEdge(0,1);
    g2.addEdge(0,6);
    g2.addEdge(1,2);
    g2.addEdge(2,0);
    g2.addEdge(2,3);
    g2.addEdge(3,4);
    g2.addEdge(4,2);
    g2.addEdge(4,5);
    g2.addEdge(5,0);
    g2.addEdge(6,4);
    g2.printEulerCircuit();

}
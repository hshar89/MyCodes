#include<bits/stdc++.h>
using namespace std;
class Graph{
    int V;
    list<int> *adj;
    // A Recursive DFS based function used by SCC() 
    void SCCUtil(int &time,int u, int disc[], int low[], 
                 stack<int> &st, bool stackMember[]); 
public: 
    Graph(int V);   // Constructor 
    void addEdge(int v, int w);   // function to add an edge to graph 
    void SCC();    // prints strongly connected components 
};
Graph::Graph(int V) 
{ 
    this->V = V; 
    adj = new list<int>[V]; 
} 
  
void Graph::addEdge(int v, int w) 
{ 
    adj[v].push_back(w); 
} 
void Graph::SCCUtil(int &time, int s, int disc[], int low[], stack<int> &st, bool stackmember[]){
    disc[s] = low[s] = ++time;
    st.push(s);
    stackmember[s] = true;
    for(auto i=adj[s].begin();i!=adj[s].end();i++){
        int v = *i;
        if(disc[v]==-1){
            SCCUtil(time,v,disc,low,st,stackmember);
            low[s] = min(low[s],low[v]);
        }else if(stackmember[v] == true){
            low[s] = min(low[s],disc[v]);
        }
    }
    int w = 0;
    if(low[s] == disc[s]){
        while(st.top() != s){
            w = st.top();
            st.pop();
            cout<<w<<" ";
            stackmember[w] = false;
        }
        w = st.top();
        cout<<w<<"\n";
        st.pop();
        stackmember[w] = false;
    }
}
void Graph::SCC(){
    bool stackmember[V];
    int disc[V];
    int low[V];
    stack<int> st;
    for(int i=0;i<V;i++){
        stackmember[i]  = 0;
        disc[i] = -1;
        low[i] = -1;
    }
    int time = 0;
    for(int i=0;i<V;i++){
        if(disc[i] == -1){
            SCCUtil(time,i,disc,low,st,stackmember);
        }
    }
}

int main() 
{ 
    cout << "\nSCCs in first graph \n"; 
    Graph g1(5); 
    g1.addEdge(1, 0); 
    g1.addEdge(0, 2); 
    g1.addEdge(2, 1); 
    g1.addEdge(0, 3); 
    g1.addEdge(3, 4); 
    g1.SCC(); 
  
    cout << "\nSCCs in second graph \n"; 
    Graph g2(4); 
    g2.addEdge(0, 1); 
    g2.addEdge(1, 2); 
    g2.addEdge(2, 3); 
    g2.SCC(); 
  
    cout << "\nSCCs in third graph \n"; 
    Graph g3(7); 
    g3.addEdge(0, 1); 
    g3.addEdge(1, 2); 
    g3.addEdge(2, 0); 
    g3.addEdge(1, 3); 
    g3.addEdge(1, 4); 
    g3.addEdge(1, 6); 
    g3.addEdge(3, 5); 
    g3.addEdge(4, 5); 
    g3.SCC(); 
  
    cout << "\nSCCs in fourth graph \n"; 
    Graph g4(11); 
    g4.addEdge(0,1);g4.addEdge(0,3); 
    g4.addEdge(1,2);g4.addEdge(1,4); 
    g4.addEdge(2,0);g4.addEdge(2,6); 
    g4.addEdge(3,2); 
    g4.addEdge(4,5);g4.addEdge(4,6); 
    g4.addEdge(5,6);g4.addEdge(5,7);g4.addEdge(5,8);g4.addEdge(5,9); 
    g4.addEdge(6,4); 
    g4.addEdge(7,9); 
    g4.addEdge(8,9); 
    g4.addEdge(9,8); 
    g4.SCC(); 
  
    cout << "\nSCCs in fifth graph \n"; 
    Graph g5(5); 
    g5.addEdge(0,1); 
    g5.addEdge(1,2); 
    g5.addEdge(2,3); 
    g5.addEdge(2,4); 
    g5.addEdge(3,0); 
    g5.addEdge(4,2); 
    g5.SCC(); 
   cout << "\nSCCs in sixth graph \n"; 
    Graph g6(4);
    g6.addEdge(0,1);
    g6.addEdge(1,0);
    g6.addEdge(2,1);
    g6.addEdge(3,2);
    g6.SCC();
    
    cout << "\nSCCs in seventh graph \n"; 
    Graph g7(8);
    g7.addEdge(0,1);
    g7.addEdge(5,3);
    g7.addEdge(7,5);
    g7.addEdge(5,6);
    g7.addEdge(3,6);
    g7.addEdge(1,3);
    g7.addEdge(2,6);
    g7.addEdge(6,0);
    g7.addEdge(2,0);
    g7.addEdge(6,7);
    g7.addEdge(0,2);
    g7.SCC();

    cout << "\nSCCs in eight graph \n";
    Graph g8(5);
    g8.addEdge(2, 0);
    g8.addEdge(2, 1);
    g8.addEdge(3, 2);
    g8.addEdge(4, 3);
    g8.SCC();
    cout<<endl;
   
    cout << "\nSCCs in ninth graph \n";
    Graph g9(4);
    g9.addEdge(0,1);
    g9.addEdge(1,2);
    g9.addEdge(2,0);
    g9.addEdge(2,3);
    g9.addEdge(3,2);
    g9.SCC();
    
    cout << "\nSCCs in tenth graph \n";
    Graph g10(10);
    g10.addEdge(5,0);
    g10.addEdge(7,2);
    g10.addEdge(0,3);
    g10.addEdge(5,4);
    g10.addEdge(1,5);
    g10.addEdge(5,6);
    g10.addEdge(6,7);
    g10.addEdge(1,8);
    g10.addEdge(5,9);
    g10.addEdge(6,0);
    g10.addEdge(0,1);
    g10.addEdge(3,6);
    g10.SCC();

    return 0; 

} 
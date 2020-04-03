#include<bits/stdc++.h>
using namespace std;
class Edge{
    public:
    int src,dest,weight;
};
class Graph{
    public:
    int V,E;
    Edge* edge;
};
class subset{
    public:
    int parent;
    int rank;
};
Graph* createGraph(int V, int E){
    Graph* graph = new Graph();
    graph->V =V;
    graph->edge = new Edge[E];
    graph->E = E;
    return graph;
}
int mycomp(const void* a, const void*b){
    Edge *a1 = (Edge*)a;
    Edge *a2 = (Edge*)b;
    return a1->weight>a2->weight;
}
int find(subset *subs, int a){
    if(subs[a].parent == a){
        return a;
    }
    return find(subs,subs[a].parent);
}
void Union(subset *subs, int a, int b){
    int xroot = find(subs,a);
    int yroot = find(subs,b);

    if(subs[xroot].rank<subs[yroot].rank){
        subs[xroot].parent= yroot;
    }else if(subs[xroot].rank>subs[yroot].rank){
        subs[yroot].parent = xroot;
    }else{
        subs[yroot].parent = xroot;
        subs[xroot].rank++;
    }
}
void KruskalMST(Graph* graph){
    int V = graph->V;
    Edge result[V];
    int e = 0;
    int i = 0;

    qsort(graph->edge,graph->E,sizeof(graph->edge[0]),mycomp);

    subset* subs = new subset[V*sizeof(subset)];

    for(int v=0;v<V;v++){
        subs[v].parent = v;
        subs[v].rank = 0;
    }

    while(e<V-1 && i<graph->E){
        Edge next_edge = graph->edge[i++];
        int x = find(subs,next_edge.src);
        int y = find(subs,next_edge.dest);

        if(x!=y){
            result[e++] = next_edge;
            Union(subs,x,y);
        }
    }
     // print the contents of result[] to display the  
    // built MST  
    cout<<"Following are the edges in the constructed MST\n";  
    for (i = 0; i < e; ++i)  
        cout<<result[i].src<<" -- "<<result[i].dest<<" == "<<result[i].weight<<endl;  
    return; 
    
}
int main(){
    int V = 4;
    int E = 5;
    // add edge 0-1  
    Graph* graph = createGraph(V, E);  
    graph->edge[0].src = 0;  
    graph->edge[0].dest = 1;  
    graph->edge[0].weight = 10;  
  
    // add edge 0-2  
    graph->edge[1].src = 0;  
    graph->edge[1].dest = 2;  
    graph->edge[1].weight = 6;  
  
    // add edge 0-3  
    graph->edge[2].src = 0;  
    graph->edge[2].dest = 3;  
    graph->edge[2].weight = 5;  
  
    // add edge 1-3  
    graph->edge[3].src = 1;  
    graph->edge[3].dest = 3;  
    graph->edge[3].weight = 15;  
  
    // add edge 2-3  
    graph->edge[4].src = 2;  
    graph->edge[4].dest = 3;  
    graph->edge[4].weight = 4;  
  
    KruskalMST(graph);  

    return 0;
}
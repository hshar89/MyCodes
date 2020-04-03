#include<bits/stdc++.h>
using namespace std;
struct edge{
    int src,dest;
};
struct Graph{
    int v;
    int e;
    edge *earr;
};
struct subset{
    int parent;
    int rank;
};
Graph* createGraph(int v, int e){
    Graph* graph = (struct Graph*)malloc(sizeof(struct Graph));
    graph->e = e;
    graph->v = v;
    graph->earr = (struct edge*)malloc(graph->e * sizeof(struct edge));
    return graph;
}
int find(struct subset *arr, int a){
    if(a!=arr[a].parent){
        find(arr,arr[a].parent);
    }
    return arr[a].parent;
}
void Union(int a, int b, struct subset* arr){
    int pa = find(arr,a);
    int pb = find(arr,b);

   if(arr[pa].rank<arr[pb].rank){
       arr[pa].parent = pb;
   }else if(arr[pa].rank>arr[pb].rank){
       arr[pb].parent = pa;
   }else{
       arr[pb].parent = pa;
       arr[pa].rank++;
   }
}

bool isCycle(struct Graph* graph){
    
    int v = graph->v;
    int e = graph->e;
    
    subset* arr= (struct subset*)malloc(sizeof(struct subset)*v);
    for(int i=0;i<v;i++){
        arr[i].parent = i;
        arr[i].rank = 0;
    }
    for(int i=0;i<e;i++){
        int pa = find(arr,graph->earr[i].src);
        int pb = find(arr,graph->earr[i].dest);
        if(pb==pa){
            return true;
        }
        Union(pa,pb,arr);
    }

}


int main(){
    int V = 3, E = 3; 
    struct Graph* graph = createGraph(V, E); 
  
    // add edge 0-1 
    graph->earr[0].src = 0; 
    graph->earr[0].dest = 1; 
  
    // add edge 1-2 
    graph->earr[1].src = 1; 
    graph->earr[1].dest = 2; 
  
    // add edge 0-2 
    graph->earr[2].src = 0; 
    graph->earr[2].dest = 2; 
  
    if (isCycle(graph)) 
        printf( "Graph contains cycle" ); 
    else
        printf( "Graph doesn't contain cycle" ); 
    long long int n1 = (5-9)*(5-9);
    cout<<"\n"<<n1<<"\n";
}
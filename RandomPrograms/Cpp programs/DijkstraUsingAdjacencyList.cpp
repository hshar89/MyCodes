#include<bits/stdc++.h>
using namespace std;
struct adjListNode{
    int dest,w;
    adjListNode *next;
};
struct adjList{
   adjListNode *head; 
};
struct Graph{
    int V;
    adjList *arr;
};
adjListNode* createNode(int dest, int w){
    struct adjListNode* temp = (struct adjListNode*)malloc(sizeof(struct adjListNode));
    temp->dest = dest;
    temp->w = w;
    temp->next = NULL;
    return temp;
}
Graph* createGraph(int V){
    struct Graph* graph = (struct Graph*)malloc(sizeof(struct Graph));
    graph->V = V;
    graph->arr = (struct adjList*)malloc(sizeof(V*sizeof(adjList)));
    for(int i=0;i<V;i++){
        graph->arr[i].head = NULL;
    }
    return graph;
}
void addEdge(Graph  *graph, int src, int dest, int w){
    struct adjListNode *temp = createNode(dest,w);
    temp->next = graph->arr[src].head;
    graph->arr[src].head = temp;

    temp = createNode(src,w);
    temp->next = graph->arr[dest].head;
    graph->arr[dest].head = temp;
}
struct MinHeapNode{
    int v;
    int dist;
};

struct MinHeap{
    int size;
    int capacity;
    int *pos;
    struct MinHeapNode **array;
};
struct MinHeapNode* newMinHeapNode(int dist, int v){
   struct MinHeapNode* minHeapNode = 
           (struct MinHeapNode*) malloc(sizeof(struct MinHeapNode)); 
    minHeapNode->dist = dist;
    minHeapNode->v = v;
    return minHeapNode;
}
struct MinHeap* createMinHeap(int capacity){
    struct MinHeap* minheap = (struct MinHeap*)malloc(sizeof(struct MinHeap));
    minheap->size = 0;
    minheap->capacity = capacity;
    minheap->pos = (int*)malloc(capacity*sizeof(int));
    minheap->array = (struct MinHeapNode**)malloc(capacity*sizeof(struct MinHeapNode*));
    return minheap;
}
void swapMinHeapNode(MinHeapNode** a, MinHeapNode **b){
    MinHeapNode *t = *a;
    *a = *b;
    *b = t;
}
void minHeapify(MinHeap* minheap, int idx){
    int smallest,right,left;
    smallest = idx;
    left = 2*idx+1;
    right = 2*idx+2;
    if(left<minheap->size && minheap->array[left]->dist <minheap->array[smallest]->dist){
        smallest = left;
    }
    if(right<minheap->size && minheap->array[right]->dist<minheap->array[smallest]->dist){
        smallest = right;
    }
    if(smallest != idx){
        MinHeapNode *n1 = minheap->array[idx];
        MinHeapNode* n2 = minheap->array[smallest];
        minheap->pos[n1->v] = smallest;
        minheap->pos[n2->v] = idx;
        swapMinHeapNode(&n1,&n2);
        minHeapify(minheap,smallest);
    }
}
int isEmpty(MinHeap* minheap){
    return minheap->size == 0;

}
MinHeapNode* extractMin(MinHeap* minheap){
    if(isEmpty(minheap)){
        return NULL;
    }
    MinHeapNode* root = minheap->array[0];
    MinHeapNode* last = minheap->array[minheap->size-1];
    minheap->array[0] = last;
    minheap->pos[root->v] = minheap->size-1;
    minheap->pos[last->v] = 0;
    --minheap->size;
    minHeapify(minheap,0);
    return root;
}
void decreaseKey(MinHeap* minheap, int v, int dist){
    int i = minheap->pos[v];
    minheap->array[i]->dist = dist;
    while(i && minheap->array[i]->dist <minheap->array[(i-1)/2]->dist){
        minheap->pos[minheap->array[i]->v] = (i-1)/2;
        minheap->pos[minheap->array[(i-1)/2]->v] = i;
        swapMinHeapNode(&minheap->array[i], &minheap->array[(i-1)/2]);
        i = (i-1)/2;
    }
}
bool isInMinHeap(MinHeap* minheap, int v){
    if(minheap->pos[v] < minheap->size){
        return true;
    }
    return false;
}
// A utility function used to print the solution 
void printArr(int dist[], int n) 
{ 
    printf("Vertex   Distance from Source\n"); 
    for (int i = 0; i < n; ++i) 
        printf("%d \t\t %d\n", i, dist[i]); 
}
void dijkstra(Graph* graph, int src){
    int V = graph->V;
    int dist[V];
    MinHeap* minheap = createMinHeap(V);
    for(int i=0;i<V;i++){
        dist[i] =INT_MAX;
        minheap->array[i] = newMinHeapNode(i,dist[i]);
        minheap->pos[i] = i;
    }
    minheap->array[src] = newMinHeapNode(src,dist[src]);
    minheap->pos[src] = src;
    dist[src] = 0;
    decreaseKey(minheap,src,0);
    minheap->size =V;
    while(!isEmpty(minheap)){
        MinHeapNode* minheapnode = extractMin(minheap);
        int u =minheapnode->v;
        adjListNode* pCrawl = graph->arr[u].head;
        while(pCrawl != NULL){
            int v =pCrawl->dest;
            if(isInMinHeap(minheap,v) && dist[u]!=INT_MAX && pCrawl->w +dist[u]<dist[v]){
                dist[v] =dist[u]+pCrawl->w;
                decreaseKey(minheap,v,dist[v]);
            }
            pCrawl = pCrawl->next;
        }
    }
    // print the calculated shortest distances 
    printArr(dist, V);
}
int main(){
    // create the graph given in above fugure 
    int V = 9; 
    struct Graph* graph = createGraph(V); 
    addEdge(graph, 0, 1, 4); 
    addEdge(graph, 0, 7, 8); 
    addEdge(graph, 1, 2, 8); 
    addEdge(graph, 1, 7, 11); 
    addEdge(graph, 2, 3, 7); 
    addEdge(graph, 2, 8, 2); 
    addEdge(graph, 2, 5, 4); 
    addEdge(graph, 3, 4, 9); 
    addEdge(graph, 3, 5, 14); 
    addEdge(graph, 4, 5, 10); 
    addEdge(graph, 5, 6, 2); 
    addEdge(graph, 6, 7, 1); 
    addEdge(graph, 6, 8, 6); 
    addEdge(graph, 7, 8, 7); 
  
    dijkstra(graph, 0); 
  
    return 0; 
}
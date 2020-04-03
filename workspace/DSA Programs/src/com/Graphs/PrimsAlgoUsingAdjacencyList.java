package com.Graphs;
//Structure to represent a min heap node 
class MinHeapNode{
	int v;
	int key;
	public MinHeapNode(int v, int key) {
		this.v = v;
		this.key = key;
	}
}
//Structure to represent a min heap 
class MinHeap{
	int size;
	int capacity;
	int pos[];
	MinHeapNode array[];
	public MinHeap(int capacity) {
		this.capacity = capacity;
		this.array = new MinHeapNode[capacity];
		this.pos = new int[capacity];
	}
	public boolean isEmpty() {
		if(size==0) {
			return true;
		}
		return false;
	}
	public boolean isPresentInHeap(MinHeap minheap,int idx) {
		if(minheap.pos[idx]<minheap.size) {
			return true;
		}
		return false;
	}
	public MinHeapNode extractMin(MinHeap minheap) {
		if(minheap.isEmpty()) {
			return null;
		}
		MinHeapNode toReturn = minheap.array[0];
		MinHeapNode last = minheap.array[minheap.size-1];
		minheap.array[0] = last;
		minheap.pos[toReturn.v] = minheap.size-1;
		minheap.pos[last.v] = 0;
		minheap.size = minheap.size-1;
		minHeapify(minheap,0);
		return toReturn;
	}
	// A standard function to heapify at given idx 
	// This function also updates position of nodes when they are swapped. 
	// Position is needed for decreaseKey() 
	public void minHeapify(MinHeap minheap, int idx) {
		int smallest=idx;
		int left = 2*idx+1;
		int right = 2*idx+2;
		if(left<minheap.size && minheap.array[left].key<minheap.array[smallest].key) {
			smallest = left;
		}
		if(right<minheap.size && minheap.array[right].key<minheap.array[smallest].key) {
			smallest = right;
		}
		if(smallest!=idx) {
			minheap.pos[minheap.array[idx].v] = smallest;
			minheap.pos[minheap.array[smallest].v] = idx;
			MinHeapNode temp = minheap.array[idx];
			minheap.array[idx] = minheap.array[smallest];
			minheap.array[smallest] = temp;
			minHeapify(minheap,smallest);
		}
	}
	public void decreaseKey(MinHeap minheap,int v, int key) {
		int i = minheap.pos[v];
		minheap.array[i].key = key;
		while(i>0 && minheap.array[(i-1)/2].key>minheap.array[i].key) {
			minheap.pos[minheap.array[i].v] = (i-1)/2;
			minheap.pos[minheap.array[(i-1)/2].v] = i;
			MinHeapNode temp = minheap.array[i];
			minheap.array[i] = minheap.array[(i-1)/2];
			minheap.array[(i-1)/2] = temp;
			i = (i-1)/2;
		}
	}
}
//A structure to represent a node in adjacency list 
class AdjListNode{
	int dest;
	int wt;
	AdjListNode next;
	public AdjListNode(int dest, int wt) {
		this.dest = dest;
		this.wt = wt;
		this.next = null;
	}
}
//A structure to represent an adjacency list 
class AdjList{
	AdjListNode head;
	public AdjList() {
		this.head = null;
	}
}
//A structure to represent a graph. A graph is an array of adjacency lists. 
//Size of array will be V (number of vertices in graph) 
class Graphp{
	int V;
	AdjList array[];
	Graphp(int V){
		this.V = V;
		this.array = new AdjList[V];
		for(int i=0;i<V;i++) {
			this.array[i] = new AdjList();
		}
	}
	// Adds an edge to an undirected graph
	public void addEdge(Graphp graph, int src, int dest, int wt) {
		// Add an edge from src to dest.  A new node is added to the adjacency 
	    // list of src.  The node is added at the begining 
		AdjListNode newNode = new AdjListNode(dest,wt);
		newNode.next = graph.array[src].head;
		graph.array[src].head = newNode;
		// Since graph is undirected, add an edge from dest to src also 
		newNode = new AdjListNode(src,wt);
		newNode.next = graph.array[dest].head;
	    graph.array[dest].head = newNode;
	}
}
public class PrimsAlgoUsingAdjacencyList {
	
private static void primsGraph(Graphp graph) {
		
		int key[] = new int[graph.V];
		int parent[] = new int[graph.V];
		MinHeap minheap = new MinHeap(graph.V);
		for(int i=0;i<graph.V;i++) {
			key[i] = Integer.MAX_VALUE;
			parent[i] = -1;
			minheap.pos[i] = i;
			minheap.array[i] = new MinHeapNode(i,key[i]);
		}
		key[0] = 0;
		minheap.array[0] = new MinHeapNode(0,0);
		minheap.size = graph.V;
		while(!minheap.isEmpty()) {
			//printPosArray(minheap.pos);
			MinHeapNode min = minheap.extractMin(minheap);
			int u = min.v;
			AdjListNode temp = graph.array[u].head;
			while(temp!=null) {
				
				int v = temp.dest;
				if(minheap.isPresentInHeap(minheap, v)&&temp.wt<key[v]) {
					key[v] = temp.wt;
					parent[v] = u;
					minheap.decreaseKey(minheap,v,key[v]);
				}
				temp = temp.next;
			}
		}
		printArr(parent, graph.V); 
	}
	private static void printPosArray(int[] pos) {
	// TODO Auto-generated method stub
	for(int i=0;i<pos.length;i++) {
		System.out.print(pos[i]+" ");
	}
	System.out.println();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Graphp graph = new Graphp(9);
        graph.addEdge(graph, 0, 7, 8);
        graph.addEdge(graph, 0, 1, 4);
        graph.addEdge(graph, 1, 7, 11);
        graph.addEdge(graph, 1, 2, 8);
        graph.addEdge(graph, 2, 5, 4);
        graph.addEdge(graph, 2, 8, 2);
        graph.addEdge(graph, 2, 3, 7);
        graph.addEdge(graph, 3, 5, 14);
        graph.addEdge(graph, 3, 4, 9);
        graph.addEdge(graph, 4, 5, 10);
        graph.addEdge(graph, 5, 6, 2);
        graph.addEdge(graph, 6, 8, 6);
        graph.addEdge(graph, 6, 7, 1);
        graph.addEdge(graph, 7, 8, 7);
        
        primsGraph(graph);
	}

	private static void printArr(int[] parent, int V) {
		// TODO Auto-generated method stub
		for (int o = 1; o < V; o++) {
            System.out.println(parent[o] + " "
                               + "-"
                               + " " + o); 
           } 	 
	}

}


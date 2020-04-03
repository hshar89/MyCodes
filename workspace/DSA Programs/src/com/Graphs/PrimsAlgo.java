package com.Graphs;

public class PrimsAlgo {
	// A utility function to find the vertex with minimum key
	// value, from the set of vertices not yet included in MST
	public static int getMinKey(boolean mst[], int V, int key[]) {
		// Initialize min value
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < V; i++) {
			if (key[i] < min && mst[i] == false) {
				min = key[i];
				index = i;
			}
		}
		return index;
	}

	// Function to construct and print MST for a graph represented
	// using adjacency matrix representation
	public static void createMST(int graph[][], int V) {
		// Array to store constructed MST
		int parent[] = new int[V];
		// Key values used to pick minimum weight edge in cut
		int key[] = new int[V];
		// To represent set of vertices not yet included in MST
		boolean mst[] = new boolean[V];
		// Initialize all keys as INFINITE
		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mst[i] = false;
		}
		key[0] = 0;
		parent[0] = -1;
		// The MST will have V vertices
		for (int count = 0; count < V - 1; count++) {
			// Pick thd minimum key vertex from the set of vertices
			// not yet included in MST
			int u = getMinKey(mst, V, key);
			// Add the picked vertex to the MST Set
			mst[u] = true;
			// Update key value and parent index of the adjacent
			// vertices of the picked vertex. Consider only those
			// vertices which are not yet included in MST
			for (int i = 0; i < V; i++) {
				// graph[u][v] is non zero only for adjacent vertices of m
				// mstSet[v] is false for vertices not yet included in MST
				// Update the key only if graph[u][v] is smaller than key[v]
				if (graph[u][i] != 0 && graph[u][i] < key[i] && mst[i] == false) {
					parent[i] = u;
					key[i] = graph[u][i];
				}
			}
		}
		printGraph(parent, graph, V);

	}

	// A utility function to print the constructed MST stored in
	// parent[]
	private static void printGraph(int[] parent, int[][] graph, int V) {
		// TODO Auto-generated method stub
		System.out.println("Edge \tWeight");
		for (int i = 1; i < V; i++)
			System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 } };
		createMST(graph, graph.length);
	}

}

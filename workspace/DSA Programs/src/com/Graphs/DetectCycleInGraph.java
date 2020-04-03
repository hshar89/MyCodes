package com.Graphs;
import java.util.*; 

public class DetectCycleInGraph {
	    // The main function to check whether a given graph 
	    // contains cycle or not 
	    static int isCycle( Graph graph) 
	    { 
	        // Allocate memory for creating V subsets 
	        int parent[] = new int[graph.V]; 
	  
	        // Initialize all subsets as single element sets 
	        for (int i=0; i<graph.V; ++i) 
	            parent[i]=-1; 
	  
	        // Iterate through all edges of graph, find subset of both 
	        // vertices of every edge, if both subsets are same, then 
	        // there is cycle in graph. 
	        for (int i = 0; i < graph.E; ++i) 
	        { 
	            int x = graph.find(parent, graph.edge[i].src); 
	            int y = graph.find(parent, graph.edge[i].dest); 
	  
	            if (x == y) 
	                return 1; 
	  
	            graph.Union(parent, x, y); 
	        } 
	        return 0; 
	    } 
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 3, E = 3; 
        Graph graph = new Graph(V, E); 
  
        // add edge 0-1 
        graph.edge[0].src = 0; 
        graph.edge[0].dest = 1; 
  
        // add edge 1-2 
        graph.edge[1].src = 1; 
        graph.edge[1].dest = 2; 
  
        // add edge 0-2 
        graph.edge[2].src = 0; 
        graph.edge[2].dest = 2; 
  
        if (isCycle(graph)==1) 
            System.out.println( "graph contains cycle" ); 
        else
            System.out.println( "graph doesn't contain cycle" );
	}

}

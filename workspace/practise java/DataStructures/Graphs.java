package DataStructures;

import java.util.*;
import java.util.LinkedList;
class count{
    int countPaths;
    public count(){
        countPaths = 0;
    }
}
public class Graphs {
    private int V;
    private ArrayList<ArrayList<Integer>> adj;
    Graphs(int V){
    	this.V = V;
    	this.adj = new ArrayList<ArrayList<Integer>>(V);
    	for(int i=0;i<V;i++){
    		adj.add(new ArrayList<Integer>());
    	}
    }
    void addEdge(int v, int u){
    	adj.get(v).add(u);
    }
    void DFS(int v){
    	boolean visited[] = new boolean[V];
    	DFSUtil(v,visited);
    }
    void DFSUtil(int v, boolean[] visited){
    	visited[v] = true;
    	System.out.print(v+" ");
    	Iterator<Integer> i = adj.get(v).iterator();
    	while(i.hasNext()){
    		int n = i.next();
    		if(!visited[n]){
    			DFSUtil(n,visited);
    		}
    	}
    }
    void BFS(){
    	boolean visited[] = new boolean[V];
    	for(int i=0;i<V;i++){
    		if(visited[i] == false)
    		BFSUtil(i,visited);
    	}
    }
    void BFSUtil(int v, boolean[] visited){
    	visited[v] = true;
    	Queue<Integer> q =  new LinkedList<Integer>();
    	q.add(v);
    	while(!q.isEmpty()){
    		int s = q.remove();
    		System.out.print(s+" ");
    		for(int i=0;i<adj.get(s).size();i++){
    			int node = adj.get(s).get(i);
    			if(!visited[node]){
    				q.add(node);
    				visited[node] = true;
    			}
    		}
    	}
    			
    }
    //Util method to Count number of paths from source to destination
    static void countPathsUtil(ArrayList<ArrayList<Integer>> list, int s, int d, boolean ancestor[],count c1){
        Iterator<Integer> itr = list.get(s).iterator();
        //Keep a track of ancestors so that circular loop does not happen
  	  ancestor[s] = true;
  	  while(itr.hasNext()){
  	       int a = itr.next();
  	       if(!ancestor[a]){
  	       countPathsUtil(list,a,d,ancestor,c1);
  	       }
  	   }
  	  //If current source equals destination increase count
  	   if(s == d){
  	       c1.countPaths++;
  	   }
  	   //mark ancestor false once work is done
  	   ancestor[s] = false;  
      }
    static int countPaths(ArrayList<ArrayList<Integer>> list, int s, int d)
    {
        // add your code here
      if(d>list.size() || s<0 || s>list.size() || d<0){
	    return 0;
	   }
	   boolean ancestor[] = new boolean[list.size()+1];
	   count c1 = new count();
	   for(int i=0;i<list.size();i++){
	       ancestor[i] = false;
	   }
	   countPathsUtil(list,s,d,ancestor,c1);
	   return c1.countPaths;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Graphs g = new Graphs(5);

		 g.addEdge(0, 1);
		    g.addEdge(1, 0);
		    g.addEdge(0, 2);
		    g.addEdge(2, 0);
		    g.addEdge(1, 2);
		    g.addEdge(2, 1);
		    g.addEdge(2, 3);
		    g.addEdge(3, 2);
		    g.addEdge(3, 4);
		    g.addEdge(4, 3);
		    g.addEdge(1, 4);
		    g.addEdge(4, 1);
		    g.addEdge(1, 3);
		    g.addEdge(3, 1);
	        System.out.println("Following is Depth First Traversal "+
	                           "(starting from vertex 2)");

	        g.DFS(2);
	        System.out.println("\nFollowing is Breadth First Traversal ");
	        g.BFS();
	}

}

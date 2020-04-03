//M-coloring problem
/*Below is a inhouse solution for M coloring problem*/
struct color{
    char assignedColor;
    unordered_set<char> adjacentColors;
    /*color(){
        assignedColor = '0';
    }*/
};
char getColor(int m, char availableColors[], unordered_set<char> takenColors){
    for(int i=0;i<m;i++){
        if(takenColors.find(availableColors[i])==takenColors.end()){
            return availableColors[i];
        }
    }
    return '9';
}
bool assignColor(int v1, int v2, color vertices[],
           char availableColors[],int m, int v){
    if(m==1){
        return false;
    }           
    if(vertices[v1].assignedColor!= '0' && vertices[v2].assignedColor !='0' && 
    vertices[v1].assignedColor != vertices[v2].assignedColor){
        //cout<<"not same ";
        //cout<<"assigned colors v1 "<<vertices[v1].assignedColor;
        //cout<<"assined color v2 "<<vertices[v2].assignedColor;
        return true;
    }
    if(vertices[v1].assignedColor == '0' && vertices[v2].assignedColor=='0'){
        vertices[v1].assignedColor = availableColors[0];
        vertices[v2].assignedColor = availableColors[1];
        vertices[v1].adjacentColors.insert(availableColors[1]);
        vertices[v2].adjacentColors.insert(availableColors[0]);
    }else if(vertices[v1].assignedColor=='0'){
        unordered_set<char> temp;
        temp.insert(vertices[v2].assignedColor);
        char ac = getColor(m,availableColors,temp);
        if(ac == '9'){
            return false;
        }
        vertices[v1].assignedColor = ac;
        vertices[v1].adjacentColors.insert(vertices[v2].assignedColor);
        vertices[v2].adjacentColors.insert(ac);
    }else if(vertices[v2].assignedColor=='0'){
        unordered_set<char> temp;
        temp.insert(vertices[v1].assignedColor);
        char ac = getColor(m,availableColors,temp);
        if(ac == '9'){
            return false;
        }
        vertices[v2].assignedColor = ac;
        vertices[v2].adjacentColors.insert(vertices[v1].assignedColor);
        vertices[v1].adjacentColors.insert(ac);
    }else{
       vertices[v2].adjacentColors.insert(vertices[v2].assignedColor);
       char ac = getColor(m,availableColors,vertices[v2].adjacentColors);
       if(ac =='9'){
           return false;
       }
       vertices[v2].assignedColor = ac;
       vertices[v1].adjacentColors.insert(ac);
    }
  return true;  
}
bool graphColoring(bool graph[101][101], int m,int v)
{
    // your code here
    color vertices[v];
    char availableColors[m];
    for(int i=0;i<m;i++){
        availableColors[i] = 'a'+i;
        //cout<<availableColors[i]<<" ";
    }
    for(int i=0;i<v;i++){
        color temp;
        temp.assignedColor='0';
        vertices[i] =temp;
    }
    for(int i=0;i<v;i++){
        for(int j=0;j<v;j++){
            if(graph[i][j]==1 && i!=j){
            bool suc  = assignColor(i,j,vertices,availableColors,m,v);
            if(!suc){
                cout<<"0"<<endl;
                return false;
            }
            }
        }
    }
    cout<<"1"<<endl;
    return true;
}
/* A utility function to print solution */
void printSolution(int color[]) 
{ 
    printf("Solution Exists:"
            " Following are the assigned colors \n"); 
    for (int i = 0; i < V; i++) 
      printf(" %d ", color[i]); 
    printf("\n"); 
} 
/* A utility function to check if the current color assignment 
is safe for vertex v i.e. checks whether the edge exists or not 
(i.e, graph[v][i]==1). If exist then checks whether the color to  
be filled in the new vertex(c is sent in the parameter) is already 
used by its adjacent vertices(i-->adj vertices) or not (i.e, color[i]==c) */
bool isSafe(int v,bool graph[V][V], int color[], int c){
	for(int i=0;i<V;i++){
		if(graph[v][i] && c == color[i]){
			return false;
		}
	}
	return true;
}
bool graphColoringUtil(bool graph[][V], int m, int color[], int v){
	/* base case: If all vertices are assigned a color then 
       return true */
	if(v==V){
		return true;
	}
	 /* Consider this vertex v and try different colors */
	for(int c=1;c<=m;c++){
		/* Check if assignment of color c to v is fine*/
		if(isSafe(v,graph,color,c)){
			color[v] = c;
			 /* recur to assign colors to rest of the vertices */
			if(graphColoringUtil(graph,m,color,v+1)==true){
				return true;
			}
			/* If assigning color c doesn't lead to a solution 
               then remove it */
			color[v] = 0;
		}
	}
	return false;
}
/*This is the backtracking solution to the same problem*/
bool graphColoring(bool graph[V][V], int m){
	int color[V];
	for(int i=0;i<V;i++){
		color[i]=0;
	}
	if(graphColoringUtil(graph,m,color,0)==false){
		cout<<"0"<<endl;
		return false;
	}
	printSolution(color);
	return true;
}
#include <bits/stdc++.h>
using namespace std;
#define f first
#define s second
typedef pair<int,int> pr;
typedef pair<pr,pr> pfpr;

vector<int> parent;
vector<pr> pts;
map<pr,int> mp;
set<pfpr> edges;
int r,c,w;
int R[] = {0,-1,0,+1};
int C[] = {-1,0,1,0};
inline int read(){
    char c;
    int n=0;
    while((c=getchar())<48);
    n+=(c-'0');
    while((c=getchar())>=48){
        n = n*10+(c-'0');
    }
    return n;
}
int find(int x){
    if(parent[x]<0){
        return x;
    }
    return parent[x] = find(parent[x]);
}
int indexOfCurrentPoint(int a, int b, bool make=true){
    //This is for boundary condition. Always keep it zero
    if(a == 0 || a == r || b == 0 || b == c){
        a = b =0;
    }
    pair<int,int> temp = make_pair(a,b);
    //Find the current point in map
    map<pr,int>::iterator it = mp.find(temp);
    //For not index points 
    if(it==mp.end()){
        //If the point was not part of given 'w' points then return -1
        if(make){
            //If part of given 'w' points
            //index the point and keep in map for reference
            int idx = parent.size();
            //always assing the parent as '-1' till union does not happen
            parent.push_back(-1);
            pts.push_back(temp);
            mp[temp] = idx;
            return idx;
        }else{
            return -1;
        }
    }else{
        //return the index if point already present
       return it->second;
    }
    
}
int main() {
	int t= read();
	int x1,y1,x2,y2;
	while(t--){
	    
	    r = read();
	    c = read();
	    w = read();
	    if(r==1 || c==1){
            //If only one block then chefland is doomed
	        if(r==1 && c==1){
	            cout<<"Chefland is doomed\n";
	            continue;
	        }
            //If only one row or col is present then decide on basis 
            //of the 'w' queries given
	        cout<<(!w)<<"\n";
            //read the remaining queries for sake of it
	        while(w--){
	            x1 = read();
	            x2 = read();
	            y1 = read();
	            y2 = read();
	        }
	    }else{
	       edges.clear();
	       parent.clear();
	       mp.clear();
	       pts.clear();
           //Assume result is 2
	       int res=2;
           //Index a zero point for boundary conditions
	       int zero = indexOfCurrentPoint(0,0);
           //Go through the 'w' given queries
	       for(int i=0;i<w;i++){
	          
	          x1 = read();
	          y1 = read();
	          x2 = read();
	          y2 = read();
              //reduce it to align with zero based indexing
	          x1--; y1--;x2--;y2--;
              //The magic part happens here
              //if columns are same then align to row and if
              //rows are same then align to column (Imgination is the key here)
	          if(x1==x2){
	              x2++;
	              y1 = y2;
	          }else{
	              x1 = x2;
	              y2++;
	          }
            //make pairs
	          pr p1 = make_pair(x1,y1);
	          pr p2 = make_pair(x2,y2);
              //insert those pairs to form edges
	          edges.insert(make_pair(p1,p2));
	          edges.insert(make_pair(p2,p1));
              //find the root for first point
	          int root1 = find(indexOfCurrentPoint(x1,y1));
              //find root for second point
	          int root2 = find(indexOfCurrentPoint(x2,y2));
              //if same root then its already covered. No other wall required
	          if(root1 == root2){
	              res = 0;
	          }else{
                  //set the parent
	              if(parent[root1] == parent[root2]){
	                  parent[root1]--;
	              }
	              if(parent[root1]>parent[root2]){
	                  parent[root1] = root2;
	              }else{
	                  parent[root2] = root1;
	              }
	          }
	       }
	       //if result still greater than zero
           if(res){
               //iterate over all points
               for(int i=0;i<pts.size();i++){
                   pr temp = pts[i];
                   //find index of current selected point
                   int x = indexOfCurrentPoint(temp.f,temp.s);
             //go around the selected point to find any walls
             for(int j=0;j<4;j++){
                //find the index of surronding points
                int ni = temp.f+R[j];
                int nj = temp.s+C[j];
                //make a pair of the surronding point
                pr temp2 = make_pair(ni,nj);
                //find the indexed position of the point
                //new points will have -1 as 'nx'
                int nx = indexOfCurrentPoint(ni,nj,false);
                //if a point is found which was indexed and not a boundary point
                //then check if an edge exists 
                //if these points don't have an edge but have same parent
                //then the current 'i'th point is already surrounded on 3 sides
                if(nx>=0 && !(x==nx && x==zero) && 
                       edges.find(make_pair(temp,temp2)) == edges.end()){
                  if(find(x) == find(nx)){
                      res = 1;
                      break;
                  } 
                }
                
               }
               if(res==1){
                   break;
               }
           }
           }
	        
	        cout<<res<<"\n";
	    }
	}
	return 0;
}

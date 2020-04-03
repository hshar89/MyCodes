#include <bits/stdc++.h>
using namespace std;
//Node to represent 4 types of sum
struct node{
    int sum,prefix,suffix,maxsum;
    node(){
        sum=prefix=suffix=maxsum=0;
    }
};
//For reading negative numbers also
inline int read(){
    int n= 0,f=0;
    char c;
    c = getchar();
    while(c<'0' || c>'9'){
        if(c=='-'){
            f=1;
        }
        c = getchar();
    }
    while(c>='0' && c<='9'){
        n = n*10+c-'0';
        c = getchar();
    }
    if(!f){
        return n;
    }
    return n*(-1);
}

void buildTreeUtil(node *st, int ss, int se, int arr[], int si){
    //If leaf node is found update the values
    if(ss==se){
        node temp;
        temp.sum = arr[ss];
        temp.prefix = arr[ss];
        temp.suffix = arr[ss];
        temp.maxsum = arr[ss];
        st[si] = temp;
        return;
    }
    //traverse all the way till every leaf node is coevered
    int mid = ss+(se-ss)/2;
    buildTreeUtil(st,ss,mid,arr,2*si+1);
    buildTreeUtil(st,mid+1,se,arr,2*si+2);
    //Now start updating the parent nodes using leaf node values
    st[si].sum = st[2*si+1].sum+st[2*si+2].sum;
    st[si].prefix = max(st[2*si+1].prefix,st[2*si+2].prefix+st[2*si+1].sum);
    st[si].suffix = max(st[2*si+2].suffix,st[2*si+1].suffix+st[2*si+2].sum);
    st[si].maxsum = max(st[si].prefix,
                    max(st[si].suffix,
                    max(st[2*si+1].maxsum,max(st[2*si+2].maxsum,
                            st[si*2+1].suffix+st[si*2+2].prefix))));
    
}
node* buildTree(int arr[], int n){
    int h = (int)ceil(log2(n));
    int max_size = 2*(int)pow(2,h)-1;
    node* st = new node[max_size];
    buildTreeUtil(st,0,n-1,arr,0);
    return st;
}
node query(node *st, int ss, int se, int qs,int qe, int si){
    //create a temporary result node in case query is out of range
    node result;
    result.sum = result.prefix=result.suffix = result.maxsum = INT_MIN;
    if(qs>se || qe<ss){
        return result;
    }
    //if the query range exactly covers the current range
    if(qs<=ss && qe>=se){
        return st[si];
    }
    int mid = ss+(se-ss)/2;
    //in case the low end of query range is more than mid
    if(qs>mid){
       return query(st,mid+1,se,qs,qe,2*si+2);
    }
    //in case high end of query range is less then mid
    if(qe<=mid){
        return query(st,ss,mid,qs,qe,2*si+1);
    }
    //if the current range totally covers the query range then go both left and right
    node left = query(st,ss,mid,qs,qe,2*si+1);
    node right = query(st,mid+1,se,qs,qe,2*si+2);
    result.sum = left.sum+right.sum;
    result.prefix = max(left.prefix,left.sum+right.prefix);
    result.suffix = max(left.suffix+right.sum, right.suffix);
    result.maxsum = max(result.suffix,
                    max(result.prefix,
                    max(left.maxsum,
                    max(right.maxsum,left.suffix+right.prefix))));
    return result;
}
void updateTree(node* st,int ss, int se, int inx, int new_val, int si){
    //find the leaf node which belongs to the given index
    if(ss == se){
        node temp;
        temp.sum = new_val;
        temp.prefix = new_val;
        temp.suffix = new_val;
        temp.maxsum = new_val;
        st[si] = temp;
        return;
    }
    int mid = ss+(se-ss)/2;
    //move to left or right depending upon where the given index lies
    if(inx<=mid){
        updateTree(st,ss,mid,inx,new_val,2*si+1);
    }else{
       updateTree(st,mid+1,se,inx,new_val,2*si+2); 
    }
    //after traversing all nodes and reaching the leaf node and updating its value
    //now update the parents in path of that leaf node with new value
    node left = st[2*si+1];
    node right = st[2*si+2];
    st[si].sum = left.sum+right.sum;
    st[si].prefix = max(left.prefix,left.sum+right.prefix);
    st[si].suffix = max(left.suffix+right.sum,right.suffix);
    st[si].maxsum = max(st[si].prefix,
                    max(st[si].suffix,
                    max(left.maxsum,
                    max(right.maxsum,left.suffix+right.prefix))));
}
int main() {
	//code
	int t=read();
	int temp,u,v,inx,new_val;
	while(t--){
	    int n = read();
	    int arr[n];
	    int q = read();
	    for(int i=0;i<n;i++){
	        arr[i] = read();
	    }
	    node *st = buildTree(arr,n);
	    while(q--){
	       temp = read();
	       if(temp==1){
	           u= read()-1;
	           v= read()-1;
	           cout<<query(st,0,n-1,u,v,0).maxsum<<"\n";
	       }else{
	           inx = read()-1;
	           new_val = read();
	           updateTree(st,0,n-1,inx,new_val,0);
	       }
	    }
	}
	return 0;
}
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;
struct Node{
  int x;
  int y;
  bool removed;
  int index;
  Node(){
      removed = false;
  }
  Node(int x1, int y1, int i){
      x = x1;
      y = y1;
      index=  i;
  }
};
struct X{
bool operator()(Node const &n1, Node const &n2){
    return n1.x>n2.x;
}
};
struct Y{
bool operator()(Node const &n1, Node const &n2){
    return n1.y>n2.y;
}
};
int main() {
	// your code goes here
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int q;
	cin>>q;
	ll x1,y1;
	char temp;
	int index;
	unordered_map<int,Node> mp;
    priority_queue<Node,vector<Node>,X> pqX;
    priority_queue<Node,vector<Node>,Y> pqY;
	ll answer = 0;
	int i=0;
	for(int i=0;i<q;i++){
	cin>>temp;
	if(temp == '+'){
	  cin>>x1>>y1;  
      Node n1(x1^answer,y1^answer,i);
	  mp.insert(make_pair(i,n1));
      pqX.push(n1);
      pqY.push(n1);
	  i++;
	}else if(temp == '-'){
	   cin>>index;
	   mp[index^answer].removed = true;
	}else{
	  cin>>x1>>y1;  
      int xt = x1^answer;
      int yt = y1^answer;
      if(xt>=yt){
        while(mp[pqX.top().index].removed){
            pqX.pop();
        }
       answer = abs(pqX.top().x-xt) + abs(pqX.top().y-yt);
       cout<<answer<<"\n";
      }else{
         while(mp[pqY.top().index].removed){
            pqY.pop();
        }
       answer = abs(pqY.top().x-xt) + abs(pqY.top().y-yt);
       cout<<answer<<"\n";
      }
	}
	}
	return 0;
}
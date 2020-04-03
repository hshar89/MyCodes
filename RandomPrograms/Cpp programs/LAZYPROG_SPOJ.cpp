#include<bits/stdc++.h>
using namespace std;
class node{
public:
    int a;
    int b;
    int d;
    node():a(-1),b(-1),d(-1){}
    node(int a, int b, int d):a(a),b(b),d(d){
    }
    //compare using operator <
    bool operator<(node const &n1)const{
        return d<n1.d;
    }
};
//Compare by passing a struct 
struct compareNode{
    bool operator()(node const& p1, node const& p2){
        return p1.d>p2.d;
    }
};
double calculateMoneyRequired(node *arr,int n){
    priority_queue<pair<int,int>> pq;
    sort(arr,arr+n);
    double money=0;
    int time=0;
    for(int i=0;i<n;i++){
       time+=arr[i].b;
       pq.push(make_pair(arr[i].a,arr[i].b));
       if(time<=arr[i].d){
           continue;
       }
       while(true){
         pair<int,int> temp = pq.top();
         pq.pop();
         if(time-temp.second<=arr[i].d){
            temp.second-=time-arr[i].d;
            money+=(double)(time-arr[i].d)/(temp.first);
            time=arr[i].d;
            pq.push(temp);
            break;
         }else{
             money += (double)(temp.second)/(double)(temp.first);
             time-=temp.second;
         }
       }
    }
    cout<<money<<"\n";
    return money;
}
int main(){
    int n=6;
    node arr[n];
    arr[0]=node(30,10,20);
    arr[1] = node(15,30,25);
    arr[2] = node(20,70,40);
    arr[3] = node(10,100,50);
    arr[4] = node(25,60,70);
    arr[5] = node(20,50,100);
   
    cout<<fixed<<setprecision(2)<<calculateMoneyRequired(arr,n)<<"\n";
   
}

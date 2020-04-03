#include<bits/stdc++.h>
using namespace std;
struct Point{
    int x,y;
};
int orientation(Point p, Point q, Point r){
    int val = (p.y - q.y)*(r.x-q.x)-(p.x-q.x)*(r.y-q.y);
    if(val == 0){
        return 0;
    }
    return val>0?1:2;
}
bool onSegment(Point p, Point q, Point r){
   return ((r.x>=min(p.x,q.x) &&(r.x<=max(p.x,q.x)) &&(r.y>=min(p.y,q.y)) && (r.y<=max(p.y,q.y))));
}
bool doIntersect(Point p1, Point q1, Point p2, Point q2){
    int o1 = orientation(p1,q1,p2);
    int o2 = orientation(p1,q1,q2);
    int o3 = orientation(p2,q2,p1);
    int o4 = orientation(p2,q2,q1);

    if(o1!=o2 && o3!=o4){
        return true;
    }
    if(o1 == 0 && onSegment(p1,q1,p2)){
        return true;
    }
    if(o2 == 0 && onSegment(p1,q1,q2)){
        return true;
    }
    if(o3 == 0 && onSegment(p2,q2,p1)){
        return true;
    }
    if(o4 == 0 && onSegment(p2,q2,q1)){
        return true;
    }
    return false;
}
int main(){
   
   Point p1 = {1,2};
   Point q1 = {9,2};
   Point p2 = {2,3};
   Point q2 = {5,3};
   cout<<"The given line segmenst intersect: "<<doIntersect(p1,q1,p2,q2);
}
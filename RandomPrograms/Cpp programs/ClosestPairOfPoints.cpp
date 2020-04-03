#include<bits/stdc++.h>
using namespace std;
struct P{
    int x,y;
};
int compareX(P const &p1, P const &p2){
    return p1.x<p2.y;
}
int compareY(P const &p1, P const &p2){
    return p1.y<p2.y;
}
float distance(P p1, P p2){
    return sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
}
float bruteForce(P parr[], int n){
    float minDistance = FLT_MAX;
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
          if(distance(parr[i],parr[j])<minDistance){
              minDistance = distance(parr[i],parr[j]);
          }
        }
    }
}
float stripClosest(P strip[], int n, float d){
   float min = d;
   sort(strip,strip+n,compareY);
   for(int i=0;i<n;i++){
       for(int j=i+1;j<n && (strip[j].y-strip[i].y)<min;j++){
           if(distance(strip[i],strip[j])<min){
               min = distance(strip[i],strip[j]);
           }
       }
   }
}
float closestUtil(P parr[], int n){
    if(n<=3){
        return bruteForce(parr,n);
    }
    int mid = n/2;
    P midp = parr[mid];
    float dl = closestUtil(parr,mid);
    float dr = closestUtil(parr+mid,n-mid);
    
    float d = min(dl,dr);
    P strip[n];
    int j=0;
    for(int i=0;i<n;i++){
        if(abs(parr[i].x- midp.x)<d){
            strip[j] = parr[i];
            j++;
        }
    }
    return min(d,stripClosest(strip,j,d));
}
float closest(P parr[], int n){
  sort(parr,parr+n,compareX);
  return closestUtil(parr,n);
}
int main(){
    //P parr[] = {{2,3},{12,30},{40,50},{5,1},{12,10},{3,4}};
    //P parr[] = {{4,4},{2,0},{8,1},{10,1},{3,1}};
    P parr[] = {{7,10},{5,7},{1,6},{2,3}};
    int n = sizeof(parr)/sizeof(parr[0]);
    cout<<"The smallest distance is: "<<closest(parr,n);
 }
#include<iostream>
using namespace std;
struct Point{
    int x,y;
    int z = 9;
};
int main(){
    struct Point p1 = {8,9};
    struct Point p2 ={.x = 78,.y = 12};
    struct Point p3[2];
    p3[0].x = 12;
    p3[0].y = 14;
    struct Point *p4 = &p1;
     cout<<p1.x<<" "<<p1.y<<"\n";
    cout<<p2.x<<" "<<p2.y<<"\n";
    cout<<p4->x<<" "<<p4->y<<"\n";
}
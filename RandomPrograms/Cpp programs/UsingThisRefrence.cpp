#include<bits/stdc++.h>
using namespace std;
class Test{
   int x;
   int y;
   public:
     Test(int x, int y):x(x),y(y){}
     Test& setX(int a){
         x = a;
         return *this;
     }
     Test& setY(int b){
         y=b;
         return *this;
     }
     int getX(){
         return x;
     }
     int getY(){
         return y;
     }
};
class Test2{
    private:
  int x;
  int y;
public:
  Test2 (int x = 0, int y = 0) { this->x = x; this->y = y; }
  Test2& setX(int a) { x = a; return *this; }
  Test2 setY(int b) { y = b; return *this; }
  void print() { cout << "x = " << x << " y = " << y << endl; }
};
int main(){
    Test obj(900,1000);
    cout<<"y= "<<obj.getY()<<"\n";
    cout<<"x= "<<obj.getX()<<"\n";
    obj.setX(45).setY(78);
    cout<<"y= "<<obj.getY()<<"\n";
    cout<<"x= "<<obj.getX()<<"\n";

    Test2 obj2(45,56);
    obj2.setX(12).setY(14);
    obj2.print();
}
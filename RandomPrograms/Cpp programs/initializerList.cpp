#include<bits/stdc++.h>
using namespace std;
class Point{
    private:
     int x;
     int y;
    public:
     Point(int i=0,int j=0):x(i),y(j){}
      /*  The above use of Initializer list is optional as the  
        constructor can also be written as: 
        Point(int i = 0, int j = 0) { 
            x = i; 
            y = j; 
        } 
    */   
   int getX() const {
       return x;
   }
   int getY() const {
       return y;
   }
};
class Test{
    const int t;
    int &tr;
    public: 
      Test(int t, int &tr):t(t),tr(tr){} //Initializer list must be used
      int getT(){
       return t;
      }
      int getTr(){
          return tr;
      }
};
class A{
    int i;
    public:
      A(int );
};
A::A(int arg){
    i = arg;
    cout<<"A's Constructor called: Value of i: " << i << endl; 
}
class B{
    A a;
    int r;
    public:
      B(int , int );
      int getR(){
      return r;
      }
};
B::B(int x, int r):a(x),r(r){  //Initializer list must be used 
    cout<<"B's Constructor called";
}
class C{
  int i;
  public:
   C(int );
};
C::C(int arg):i(arg){
    cout<<"C's constructor called\n";
}
// Class D is derived from C
class D: C{
    public:
     D(int );
};
D::D(int x):C(x){ //Initializer list must be used
    cout<<"D's constructor called\n";
}
int main(){
    Point t1(12,13);
    cout<<"x= "<<t1.getX()<<" ";
    cout<<"y= "<<t1.getY()<<" ";
    int tr = 56;
    Test t(34,tr);
    cout<<"t= "<<t.getT()<<" ";
    cout<<"tr= "<<t.getTr()<<"\n";

    B obj(100,150);
    cout<<"r= "<<obj.getR()<<"\n";

    D od(900);
}
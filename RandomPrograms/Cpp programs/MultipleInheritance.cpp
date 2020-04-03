#include<iostream>
using namespace std;
class Vehicle{
    public:
    Vehicle(){
        cout<<"This is a vehicle"<<endl;
    }
    virtual void show(){
        cout<<"show from Vehicle"<<endl;
    }
};
class FourWheeler{
    public:
    FourWheeler(){
        cout<<"This is four wheeler"<<endl;
    }
    void show(){
        cout<<"show from four wheeler"<<endl;
    }
};
class Car: public Vehicle, public FourWheeler{
    public:
   void show(){
       cout<<"show from car"<<endl;
   }
};
int main(){
    Car car;
    FourWheeler fw;
    fw.show();
    car.show();
}
#include<bits/stdc++.h>
using namespace std;
class Complex{
    private:
     int real, img;
    public:
    Complex(int r=0, int i=0):real(r),img(i){}
    // This is automatically called when '+' is used with 
    // between two Complex objects
    /*Complex operator +(Complex const &obj){
        Complex res;
        res.real = real+obj.real;
        res.img = img+obj.img;
        return res;
    }*/
    // The global operator function is made friend of this class so 
// that it can access private members 
    friend Complex operator +(Complex const &, Complex const &);
    void print(){
        cout<<real<<"+ i "<<img<<endl;
    }
    bool operator == (Complex rhs){
        return (real == rhs.real) && (img == rhs.img)?true:false;
    }
};
Complex operator+(Complex const &obj1, Complex const &obj2){
    Complex res;
    res.real = obj1.real+obj2.real;
    res.img = obj1.img+obj2.img;
    return res;
}
int main(){
    Complex c1(4,5),c2(6,7);
    Complex res = c1+c2;
    res.print();

    if(c1 == c2){
        cout<<"true"<<"\n";
    }else{
        cout<<"false"<<"\n";
    }
}
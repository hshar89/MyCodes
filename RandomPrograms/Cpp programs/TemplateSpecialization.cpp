#include<iostream>
using namespace std;
template<typename T>
void sort(T arr[], int n){
    //Code to implement quick sort
}
template<>
void sort<char>(char arr[], int n){
    //code to implement counting sort
}
template <typename T>
void fun(T a){
    cout<<"The main template fun():"<<a<<"\n";
}
template<>
void fun<int>(int a){
    cout<<"specialized template for int type:"<<a<<"\n";
}
template<typename T>
class Test{
    public:
     Test(){
         cout<<"General Template Object\n";
     }
};
template<>
class Test<int>{
    public:
    Test(){
        cout<<"specialized template object\n";
    }
};
int main(){

    fun<double>(1.1);
    fun<int>(9);
    fun<char>('a');
    Test<double> t1;
    Test<float> t2;
    Test<int> t3;
    return 0;
}
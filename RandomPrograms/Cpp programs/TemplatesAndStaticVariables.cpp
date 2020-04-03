#include<iostream>
using namespace std;
template<typename T>
void fun(const T&a){
    static int counter=10;
    cout<<++counter<<"\n";
    return;
}
template <class T>
class Test{
private :
 T val;
 public:
  static int count;
  Test(){
      count++;
  }
};
template<class T>
int Test<T>::count = 100;

int main(){
    //each type gets copy of its own 
    //static variables
   fun<int>(13);
   fun<int>(14);
   fun<double>(1.1);
   fun<int>(15);

   Test<int> t1;
   Test<int> t2;
   Test<double> t3;
   cout<<Test<int>::count<<"\n";
   cout<<Test<double>::count<<"\n";
   return 0;
}
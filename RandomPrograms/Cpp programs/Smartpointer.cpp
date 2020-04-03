#include<bits/stdc++.h>
using namespace std;
class Smartptr{
    int *ptr;
    public:
    explicit Smartptr(int *p = NULL){
        ptr = p;
    }
    ~Smartptr(){
        delete (ptr);
    }

    int &operator*(){
        return *ptr;
    }
};
int main(){
    Smartptr ptr(new int());
    *ptr = 20;
    cout<<*ptr;
    // We don't need to call delete ptr: when the object 
    // ptr goes out of scope, destructor for it is automatically
    // called and destructor does delete ptr.
}
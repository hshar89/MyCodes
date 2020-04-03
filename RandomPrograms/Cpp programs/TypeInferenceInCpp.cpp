#include<iostream>
#include<vector>
#include<set>
using namespace std;
int fun(){
    return 3;
}
char fun2(){
    return 'a';
}
struct test{
    int a;
};
template<class A, class B>
auto findMin(A a, B b) -> decltype(a<b?a:b){
    return (a<b)?a:b;
}
int main(){
    auto x = 4;
    auto y = 4.4;
    auto ptr = &x;
    test obj;
    obj.a = 19;
    auto z = obj;
    cout<<typeid(x).name()<<"\n";
    cout<<typeid(y).name()<<"\n";
    cout<<typeid(ptr).name()<<"\n";
    cout<<typeid(z).name()<<"\n";

    set<string> st;
    st.insert({"geeks","for","geeks","org"});
    
    for(auto it = st.begin();it!=st.end();it++){
        cout<<*it<<" ";
    }

    decltype(fun()) x1;
    decltype(fun2()) y1;
    cout<<"\n";
    cout<<typeid(x1).name()<<" ";
    cout<<typeid(y1).name()<<" ";

    x = 5;
    decltype(x) j = x+5;
    cout<<typeid(j).name()<<"\n";

    cout<<findMin(3.44,4)<<"\n";

     // This call returns 3 of double type 
    cout << findMin(5.4, 3) << endl; 
}
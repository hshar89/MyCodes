#include<utility>
#include<iostream>
using namespace std;
int main(){
    pair<int,char> p;
    p.first  = 10;
    p.second = 'f';
    cout<<p.first<<" ";
    cout<<p.second<<"\n";

    pair<string,double> p2 ("gfg",42.0);
    cout<<p2.first<<" ";
    cout<<p2.second<<"\n";
    pair<string,string> p3;
    p3 = make_pair("gfg","fork");

    pair<int, int>pair1 = make_pair(1, 12);
    pair<int, int>pair2 = make_pair(9, 12);

    cout << (pair1 == pair2) << endl;
    cout << (pair1 != pair2) << endl;
    cout << (pair1 >= pair2) << endl;
    cout << (pair1 <= pair2) << endl;
    cout << (pair1 > pair2) << endl;
    cout << (pair1 < pair2) << endl;

    cout<<endl;
}
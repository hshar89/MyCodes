#include<iostream>
#include<queue>
#include<utility>
#include<algorithm>
using namespace std;

int add(int first, int second){
    return first+second -15;
}
int operation(int first, int second, int(*funcToCall)(int, int)){
    return (*funcToCall)(first,second);
}
void funct(int x){
    cout<<x;
}
struct node{

};
class GFG{

};
int f(int &x, int c) 
{
   c  = c - 1;
   if (c == 0) 
   return 1;
   x = x + 1;
   cout<<"x: "<<x<<" ";
   return f(x, c) * x;
} 
int main(){
  int a;
  int (*plus)(int,int) = add;
  a = operation(15,10,plus);
  cout<<a;
  void(*n)(int);
n = &funct;
(*n)(5);
n(5);
cout<<"\n";
struct node left;
struct node right;
cout<<sizeof(left)<<"\n";
cout<<sizeof(GFG)<<"\n";
int val = 2;
cout<<f(val,3)<<endl;
int arr[3]={3,6,2};
cout<<*min_element(arr,arr+3)<<"\n";
cout<<(4&1)<<" ";
}
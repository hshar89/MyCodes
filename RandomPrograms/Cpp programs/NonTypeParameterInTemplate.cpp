#include<iostream>
using namespace std;
template<class T, int max>
int arrmin(T arr[], int n){
    int m = max;
    for(int i=0;i<n;i++){
        if(m>arr[i]){
           m= arr[i];
        }
    }
    return m;
}
template<class T, class U>
class A{
    T x;
    U y;
    static int count;
};
int main(){
  int arr1[] = {3,4,5,6,12,9,234,42};
  int n1 = sizeof(arr1)/sizeof(int);
  char arr2[] = {1,2,3};
  int n2 = sizeof(arr2)/sizeof(char);
  cout<<arrmin<int,10000>(arr1,n1)<<"\n";
  cout<<arrmin<char,256>(arr2,n2)<<"\n";
  A<char,char> a;
  A<int,int> b;
  cout<<sizeof(a)<<"\n";
  cout<<sizeof(b)<<"\n";
 }
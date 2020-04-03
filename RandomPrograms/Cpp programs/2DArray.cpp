#include<iostream>
using namespace std;
int main(){
    int arr[3][4]= {
        {10,11,12,13},
        {14,15,16,17},
        {18,19,20,21}
    };
  int (*ptr)[4];
  ptr = arr;
  cout<<ptr<<" "<<(ptr+1)<<" "<<(ptr+2);
  cout<<endl;
  cout<<*(ptr)<<" "<<*(ptr+1)<<" "<<*(ptr+2);
  cout<<endl;
  cout<<**(ptr)<<" "<<*(*(ptr+1)+1)<<" "<<*(*(ptr+2))<<endl;
}
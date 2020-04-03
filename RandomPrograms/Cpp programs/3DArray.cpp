#include<iostream>
using namespace std;
int main(){
    int arr[2][3][2] = {
        {
            {5,10},
            {6,11},
            {7,12}
        },
        {
            {20,30},
            {21,31},
            {22,32}
        }
    };
   int i, j, k;
   for(int i=0;i<2;i++){
       for(int j=0;j<3;j++){
           for(int k=0;k<2;k++){
               cout<<*(*(*(arr+i)+j)+k)<<" ";
           }
           cout<<"\n";
       }
       cout<<"\n";
   }
}
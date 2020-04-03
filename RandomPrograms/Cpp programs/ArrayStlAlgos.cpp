#include<algorithm>
#include<iostream>
#include<numeric>
using namespace std;
int main(){
    int arr[6]= {1,2,3,4,5,-6};
    //checking if all elements are positive
    all_of(arr,arr+6,[](int x){
        return x>0;
    })?cout<<"All are positive elements":cout<<"All are not positive elements";
    cout<<"\n";

     // Checking if any element is negative 
     any_of(arr,arr+6,[](int x){
         return x<0;
     })?cout<<"There exists a negative element":cout<<"All are positive elements";
     cout<<"\n";
     // Checking if no element is negative 
     none_of(arr,arr+6,[](int x){
         return x<0;
     })?cout << "No negative elements" :cout << "There are negative elements";
     cout<<"\n";

     int arr2[6];
     // Using copy_n() to copy contents 
     copy_n(arr,6,arr2);
     cout << "The new array after copying is : "; 
    for (int i=0; i<6 ; i++) 
       cout << arr2[i] << " "; 
    cout<<"\n";

    // Using iota() to assign values 
    iota(arr, arr+6, 20); 
     // Displaying the new array 
    cout << "The new array after assigning values is : "; 
    for (int i=0; i<6 ; i++) 
       cout << arr[i] << " ";    
}
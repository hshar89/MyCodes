#include<algorithm>
#include<vector>
#include<iostream>
#include<numeric>
using namespace std;
int main(){
    vector<int> v = {2,4,1,7,12,4,19,21,1,43};
    // Checking if vector is partitioned  
    // using is_partitioned() 
    is_partitioned(v.begin(),v.end(),[](int x){
        return (x%2==0);
    })?cout<<"Vector is partioned":cout<<"Vector is not partitioned";
    cout<<endl;


    partition(v.begin(),v.end(),[](int x){
        return x%2==0;
    });

    // Checking if vector is partitioned  
    // using is_partitioned() 
    is_partitioned(v.begin(), v.end(), [](int x) 
    { 
        return x%2==0; 
          
    })? cout << "Now, vector is partitioned after partition operation": 
    cout << "Vector is still not partitioned after partition operation"; 
    cout << endl; 

    // Displaying partitioned Vector 
    cout << "The partitioned vector is : "; 
    for (int &x : v) {
    cout << x << " "; 
    }
    // Initializing vector 
    vector<int> vect = { 2, 1, 5, 6, 8, 7 }; 
     // partitioning vector using stable_partition() 
    // in sorted order 
    stable_partition(vect.begin(), vect.end(), [](int x) 
    { 
        return x%2 == 0;         
    }); 
      
    // Displaying partitioned Vector 
    cout << "The partitioned vector is : "; 
    for (int &x : vect) cout << x << " "; 
    cout << endl; 
      
    // Declaring iterator 
    vector<int>::iterator it1; 
      
    // using partition_point() to get ending position of partition 
    auto it = partition_point(vect.begin(), vect.end(), [](int x) 
    { 
        return x%2==0; 
    }); 
      
    // Displaying partitioned Vector 
    cout << "The vector elements returning true for condition are : "; 
    for ( it1= vect.begin(); it1!=it; it1++) 
    cout << *it1 << " "; 
    cout << endl; 
       
    return 0; 
}
#include<iostream>
#include<algorithm>
#include<vector>
#include<numeric>
using namespace std;

int main(){
    int arr[] = {10,20,5,23,42,20,15,45};
    int n = sizeof(arr)/sizeof(int);
    vector<int> v (arr,arr+n);

    cout<<"vector is: \n";
    for(int i=0;i<n;i++){
        cout<<v[i]<<" "; 
    }
    sort(v.begin(),v.end());

    cout << "\nVector after sorting is: "; 
    for (int i=0; i<n; i++) {
       cout << v[i] << " ";
     } 
     reverse(v.begin(),v.end());
     cout << "\nVector after reversing is: ";   
      for (int i=0; i<n; i++) {
       cout << v[i] << " ";
     } 
     cout << "\nMaximum element of vector is: "; 
     cout<<*max_element(v.begin(),v.end());
     
     cout << "\nMinimum element of vector is: "; 
     cout<<*min_element(v.begin(),v.end());

     // Starting the summation from 0 
    cout << "\nThe summation of vector elements is: ";
    cout << accumulate(v.begin(), v.end(), 0); 

    cout << "\nOccurrences of 20 in vector : ";
    cout<<count(v.begin(),v.end(),20)<<endl;

    // find() returns iterator to last address if 
    // element not present
    find(v.begin(),v.end(),41)!=v.end()?cout<<"found\n":cout<<"Not found\n";
    
    sort(v.begin(),v.end());
    // Returns the first occurrence of 20 
    auto itr = lower_bound(v.begin(),v.end(),20);

    // Returns the last occurrence of 20 
    auto itr2 = upper_bound(v.begin(),v.end(),20);

    cout << "The lower bound is at position: "; 
    cout << itr-v.begin() << endl; 

    cout << "The upper bound is at position: "; 
    cout<< itr2-v.begin()<<endl;
    
    cout << "Vector is :"; 
    for (int i=0; i<n; i++){ 
        cout << v[i]<<" "; 
    }
    v.erase(v.begin()+2);
    n--;
    cout<<"Vector after erasing 3rd element\n";
    for(int i=0;i<n;i++){
        cout<<v[i]<<" ";
    }
    // sorting to enable use of unique() 
    sort(v.begin(), v.end()); 
    
    cout << "\nVector before removing duplicate "
             " occurrences: "; 
    for (int i=0; i<v.size(); i++) 
        cout << v[i] << " "; 

    v.erase(unique(v.begin(),v.end()),v.end());

    cout << "\nVector after deleting duplicates: "; 
    for (int i=0; i< v.size(); i++) 
        cout << v[i] << " ";    

    // modifies vector to its next permutation order 
    next_permutation(v.begin(),v.end());
    cout << "\nVector after performing next permutation:\n";
    for (int i=0; i<v.size(); i++) 
        cout << v[i] << " ";   
    prev_permutation(v.begin(), v.end()); 
    cout << "\nVector after performing prev permutation:\n"; 
    for (int i=0; i<v.size(); i++) 
        cout << v[i] << " ";    

    // Return distance of first to maximum element 
    cout << "\nDistance between first to max element: ";
    cout<<distance(v.begin(),max_element(v.begin(),v.end()));  
    cout<<endl;
    return 0;
}
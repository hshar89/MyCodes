#include<iostream>
using namespace std;
template<typename T>
T myMax(T x, T y){
    return (x>y)?x:y;
}
template <class T>
void bubbleSort(T arr[], int n){
    for(int i=0;i<n-1;i++){
        for(int j=i+1;j<n;j++){
            if(arr[i]>arr[j]){
                swap(arr[i],arr[j]);
            }
        }
    }
}
template<typename T>
class Array{
    private:
     T *ptr;
     int size;
    public:
     Array(T arr[], int s);
     void print();
};
template<typename T>
Array<T>::Array(T arr[], int s){
    ptr = new T[s];
    size = s;
    for(int i=0;i<s;i++){
        ptr[i] = arr[i];
    }
}
template<typename T>
void Array<T>::print(){
    for(int i=0;i<size;i++){
        cout<<*(ptr+i)<<" ";
    }
    cout<<endl;
}
template<class T, class U>
class A{
    T x;
    U y;
    public:
    A(){
        cout<<"construtor called\n";
    }
};
template<class T, class U = char>
class C{
   T x;
   U y;
   public:
    C(){
        cout<<"\nconstructor called\n";
    }
};
int main(){
   cout<<myMax<int>(4,7)<<"\n";
   cout<<myMax<char>('a','b')<<"\n";
   int arr[] = {4,9,2,8,3,12,14};
   int n = sizeof(arr)/sizeof(int);
   bubbleSort(arr,n);
   for(int i=0;i<n;i++){
       cout<<arr[i]<<" ";
   }
   cout<<"\n";
   Array<int> a(arr,n);
   a.print();

   A<char,char> aobj;

   C<char> cobj;// This will call C<char, char>

   return 0;
}


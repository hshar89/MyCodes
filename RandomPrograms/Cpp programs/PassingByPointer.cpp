#include<iostream>
using namespace std;

void swap(int *x, int * y){
    int z = *x;
    *x = *y;
    *y = z;
}
void swap(int &x, int &y){
    int z = x;
    x = y;
    y = z;
}
struct demo{
    int a;
};
int main(){
    int a=45,b=35;
    cout<<"Before Swap\n";
    cout<<"a= "<<a<<"b= "<<b<<"\n";
    swap(&a,&b);
    cout<<"after swap\n";
    cout<<"a= "<<a<<"b= "<<b<<"\n";
    
   int x = 5;
    int y = 6;
    demo d;
    
    int *p;
    p =  &x;
    p = &y;                     // 1. Pointer reintialization allowed
    int &r = x;
    // &r = y;                  // 1. Compile Error
    r = y;                      // 1. x value becomes 6
    
    p = NULL;           
    // &r = NULL;               // 2. Compile Error
    
    p++;                        // 3. Points to next memory location
    r++;                        // 3. x values becomes 7
    
    cout << &p << " " << &x << endl;    // 4. Different address
    cout << &r << " " << &x << endl;    // 4. Same address
    
    demo *q = &d;
    demo &qq = d;
    
    q->a = 8;
    // q.a = 8;                 // 5. Compile Error 
    qq.a = 8;
    // qq->a = 8;               // 5. Compile Error
    
    cout << p << endl;        // 6. Prints the address
    cout << r << endl;        // 6. Print the value of x 
    
}
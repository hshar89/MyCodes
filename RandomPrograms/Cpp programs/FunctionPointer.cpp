#include<iostream>
using namespace std;
void fun(int a){
    cout<<"Value of a"<<a<<"\n";
}
void add(int a, int b) 
{ 
    printf("Addition is %d\n", a+b); 
} 
void subtract(int a, int b) 
{ 
    printf("Subtraction is %d\n", a-b); 
} 
void multiply(int a, int b) 
{ 
    printf("Multiplication is %d\n", a*b); 
} 
// Two simple functions 
void fun1() {
     printf("Fun1\n");
      } 
void fun2() { 
    printf("Fun2\n");
     }
void wrapper(void(*fun)()){
    fun();
}
int main(){
    // fun_ptr is a pointer to function fun() 
    void (*fun_ptr)(int) = &fun;
    (*fun_ptr)(10);

    void(*fun_ptr_arr[])(int,int) = {add,subtract,multiply};
    unsigned int ch, a=19,b=10;
    printf("Enter Choice: 0 for add, 1 for subtract and 2 "
            "for multiply\n"); 
    scanf("%d", &ch); 
    if(ch>2){
        return 0;
    }
    (*fun_ptr_arr[ch])(a,b);

    wrapper(fun1);
    wrapper(fun2);
    return 0;
}
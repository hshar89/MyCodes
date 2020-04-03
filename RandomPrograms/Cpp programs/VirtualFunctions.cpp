#include<iostream>
using namespace std;
class Employee{
    public:
    virtual void raiseSalary(){
 /* common raise salary code */
    }
    virtual void promote(){
/* common promote code */ 
    }
};
class Manager: public Employee{
    virtual void raiseSalary(){
/* Manager specific raise salary code, may contain 
          increment of manager specific incentives*/
    }
    virtual void promote(){
/* Manager specific promote */
    }
};
class B{
    public:
     virtual void show(){
         cout<<"Showing base class\n";
     }
     void display(){
         cout<<"Displaying base class\n";
     }
};
class D: public B{
public:
 void display(){
     cout<<"displaying derived class\n";
 }
 void show(){
     cout<<"showing derived class\n";
 }
};
// We need a very simple function to increment the salary of all employees 
// Note that emp[] is an array of pointers and actual pointed objects can 
// be any type of employees. This function should ideally be in a class  
// like Organization, we have made it global to keep things simple 
void globalRaiseSalary(Employee *emp[], int n){
   for(int i=0;i<n;i++){
       emp[i]->raiseSalary();
        // Polymorphic Call: Calls raiseSalary()  
        // according to the actual object, not  
        // according to the type of pointer
   }
}
int main(){
    B b;
    B *ptr;
    ptr = &b;
    ptr->display();
    ptr->show();
    D d;
    ptr = &d;
    ptr->display();
    ptr->show();
}
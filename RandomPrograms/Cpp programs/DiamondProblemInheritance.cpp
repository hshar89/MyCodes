#include<iostream>
using namespace std;
class Person{
    public:
    Person(int x){
        cout<<"Person::Person(int ) called"<<endl;
    }
    Person(){
        cout << "Person::Person() called" << endl;
    }
};
class Faculty: virtual public Person{
    public:
    Faculty(int x):Person(x){
        cout<<"Faculty::Faculty(int ) called"<<endl;
    }
};
class Student: virtual public Person{
    public:
    Student(int x):Person(x){
        cout<<"Student::Student(int ) called"<<endl;
    }
};
class TA: public Student, public Faculty{
  public:
  //Below explicitly calling Person to call grandparent parametrized constructor
  TA(int x):Student(x),Faculty(x),Person(x){
      cout<<"TA::TA(int ) called"<<endl;
  }
}; 
int main(){
    /*One important thing to note in the above output is,
     the default constructor of ‘Person’ is called. 
     When we use ‘virtual’ keyword, the default constructor of grandparent class is called by
     default even if the parent classes explicitly call parameterized constructor.*/
    TA ta(30);

}
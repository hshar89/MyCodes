#include<iostream>
using namespace std;
namespace first{
    int val = 50;
}
namespace ns1{
    int value(){
        return 45;
    }
}
namespace ns2{
    class geek;
}
class ns2::geek{
    public:
    void display(){
        cout<<"This is good display"<<"\n";
    }
};
namespace ns3{
    void display();
    class geek2{
        public:
         void display();
    };
}
void ns3::display(){
    cout<<"Khali pilli"<<"\n";
}
void ns3::geek2::display(){
    cout<<"Masakali"<<"\n";
}
int val = 400;
void printTheArray(int** arr5, int r, int c);

int main(){
cout<<first::val<<" ";
cout<<ns1::value()<<"\n";
ns2::geek obj1 ;
obj1.display();
ns3::display();
ns3::geek2 obj2;
obj2.display();
int arr[6] = {3,14,5};
for(int i=0;i<6;i++){
    cout<<&arr[i]<<" ";
}
int *ptr = arr;
cout<<(*(ptr)+1)<<"\n";
printf("size of array %d",sizeof(arr));

//Ways to implement 2d array in Cpp
int r = 3,c=4;
int count =0;
int *arr1 = (int *)malloc(r*c*sizeof(int));
for(int i=0;i<r;i++){
    for(int j=0;j<c;j++){
        *(arr1+i*c+j) = ++count;
        printf("%d ",*(arr1+i*c+j));
    }
}
int *arr2[r];
for(int i=0;i<r;i++){
    arr2[i] = (int *)malloc(c*sizeof(int));
}
cout<<"\n";
count =0;
for(int i=0;i<r;i++){
    for(int j=0;j<c;j++){
        *(*(arr2+i)+j) = ++count; 
        cout<<arr2[i][j]<<" ";
    }
}

int **arr3 = (int **)malloc(r*sizeof(int *));
for(int i=0;i<r;i++){
    arr3[i] = (int *)malloc(c*sizeof(int));
}
cout<<"\n";
count = 10;
for(int i=0;i<r;i++){
    for(int j=0;j<c;j++){
        arr3[i][j] =++count;
        cout<<arr3[i][j]<<" ";
    }
}
int *ptr2 , **arr4;
count = 20;
int len = sizeof(int *)*r+sizeof(int)*c*r;
arr4 = (int **)malloc(len);
ptr2 = (int *)(arr4+r);
for(int i=0;i<r;i++){
    arr4[i] = (ptr2+c*i);
}
cout<<"\n";
for(int i=0;i<r;i++){
    for(int j=0;j<c;j++){
        *(*(arr4+i)+j) = ++count;
        cout<<*(*(arr4+i)+j)<<" ";
    }
}
int **arr5 = (int **)malloc(r*sizeof(int *));
for(int i=0;i<r;i++){
    arr5[i] = (int *)malloc(c*sizeof(int));
}
for(int i=0;i<r;i++){
    for(int j=0;j<c;j++){
        arr5[i][j] = ++count;
    }
}
cout<<"\n";
printTheArray(arr5,r,c);
}
void printTheArray(int** arr5, int r, int c){
    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            cout<<arr5[i][j]<<" ";
        }
    }
}

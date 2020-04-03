#include<bits/stdc++.h>
using namespace std;
class Minheap{
   int *harr;
   int capacity;
   int heap_size;
   public:
      Minheap(int capacity);
      void MinHeapify(int pos);
      int parent(int i){
          return (i-1)/2;
      }
      int left(int i){
          return 2*i+1;
      } 
      int right(int i){
          return 2*i+2;
      }
      int extractMin();
      void decreaseKey(int i, int new_val);
      int getMin(){
          return harr[0];
      }
      void deleteKey(int i);
      void insertKey(int k);
};
Minheap::Minheap(int cap){
    capacity = cap;
    heap_size = 0;
    harr = new int[cap];
}
void Minheap::insertKey(int k){
    if(heap_size ==capacity){
        cout<<"\nOverflow"<<endl;
        return;
    }
    heap_size++;
    int i= heap_size-1;
    harr[i] = k;
    while(i!=0 && harr[parent(i)]>harr[i]){
        swap(harr[i],harr[parent(i)]);
        i = parent(i);
    }
}
void Minheap::MinHeapify(int i){
    int l = left(i);
    int r = right(i);
    int smallest = i;
    if(l<heap_size && harr[l]<harr[i]){
        smallest = l;
    }
    if(r<heap_size && harr[r]<harr[smallest]){
        smallest = r;
    }
    if(smallest!=i){
        swap(harr[i],harr[smallest]);
        MinHeapify(smallest);
    }
}
int Minheap::extractMin(){
    if(heap_size<=0){
        return INT_MAX;
    }
    if(heap_size==1){
        heap_size--;
        return harr[heap_size];
    }
    int res = harr[0];
    harr[0] = harr[heap_size-1];
    heap_size--;
    MinHeapify(0);
    return res;
}
void Minheap::decreaseKey(int i, int new_val){
    if(new_val>=harr[i]){
        cout<<"\nCannot be reduced";
        return;
    }
   harr[i] = new_val;
   while(i!=0 && harr[parent(i)]>harr[i]){
       swap(harr[i],harr[parent(i)]);
       i = parent(i);
   }
}
void Minheap::deleteKey(int i){
    if(i>=heap_size){
        cout<<"\nCannot delete Out of bounds";
        return;
    }
    decreaseKey(i,INT_MIN);
    extractMin();
}
int main(){
    Minheap h(10);
    h.insertKey(3); 
    h.insertKey(2); 
    h.deleteKey(1); 
    h.insertKey(15); 
    h.insertKey(5); 
    h.insertKey(4); 
    h.insertKey(45); 
    cout << h.extractMin() << " "; 
    cout << h.getMin() << " "; 
    h.decreaseKey(2, 1); 
    cout << h.getMin(); 

return 0;
}
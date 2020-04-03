#include <bits/stdc++.h>
#include <conio.h>
using namespace std;
class Trainer{
    public:
     int sadnessLevel;
     int arrivalDay;
     int lectures;
};
class MinHeap{
    int capacity;
    int heap_size;
    Trainer *harr;
    public:
    MinHeap(int cap){
        heap_size=0;
        capacity = cap;
        harr = new Trainer[cap];
    }
      void Minheapify(int i);
      Trainer extractMin();
      int parent(int i){
          return (i-1)/2;
      }
      int left(int i){
          return 2*i+1;
      }
      int right(int i){
          return 2*i+2;
      }
      void insert(Trainer t);
};
void MinHeap::insert(Trainer t){
    if(heap_size>=capacity){
        return;
    }
    heap_size++;
    int i = heap_size-1;
    harr[i] = t;
    while(i!=0 && harr[parent(i)].sadnessLevel<harr[i].sadnessLevel){
        swap(harr[parent(i)],harr[i]);
        i = parent(i);
    }
}
Trainer MinHeap::extractMin(){
    if(heap_size <=0){
        return;
    }
    Trainer temp = harr[0];
    harr[0] = harr[heap_size-1];
    heap_size--;
    Minheapify(0);
    return temp;
}
void MinHeap::Minheapify(int i){
    int l = left(i);
    int r = right(i);
    int largest = i;
    if(l<heap_size && harr[l].sadnessLevel>harr[i].sadnessLevel){
        largest = l;
    }
    if(r<heap_size && harr[r].sadnessLevel > harr[largest].sadnessLevel){
        largest = r;
    }
    if(largest!=i){
        swap(harr[i],harr[largest]);
        Minheapify(largest);
    }
}
int main() {
	// your code goes here
    int n = 2;
    int d = 3;
    Trainer trainers[n];
    trainers[0].arrivalDay = 1;
    trainers[0].lectures = 2;
    trainers[0].sadnessLevel = 300;

    trainers[1].arrivalDay = 2;
    trainers[1].lectures = 2;
    trainers[1].sadnessLevel = 100;

    MinHeap minheap(n);
    minheap.insert(trainers[0]);
    minheap.insert(trainers[1]);
    int days[d+1];
    memset(days,0,sizeof(days));
    long totalSadness = 0;
    while(n--){
      Trainer temp = minheap.extractMin();
      int i =temp.arrivalDay;
      int j =temp.lectures+i>=d?d:temp.lectures+i;
      int lecturesTaken = 0;
      while(i<j){
          if(!days[i]){
            days[i] = 1;
            lecturesTaken++;
          }
          i++;
      }
      totalSadness += ((temp.lectures-lecturesTaken)*temp.sadnessLevel);
    }
	return 0;
}
package DataStructures;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MinHeap {
    public int capacity;
    public int size;
    public int harr[];
    public MinHeap(int cap){
    	this.capacity = cap;
    	this.size = 0;
    	this.harr = new int[cap];
    }
    public int left(int i){
    	return (2*i+1);
    }
    public int right(int i){
    	return (2*i+2);
    }
    public int parent(int i){
     return(i-1)/2;
    }
    static void swap(int[] harr, int i, int j){
    	int temp = harr[i];
    	harr[i] = harr[j];
    	harr[j] = temp;
    }
    public void insert(int x){
    	if(size>=capacity){
    		return;
    	}
    	if(size == 0){
    		harr[0] = x;
    	}else{
    	harr[size] = x;
    	int i = size;
    	while(i>0 && harr[parent(i)]>harr[i]){
    		swap(harr,parent(i),i);
    		i = parent(i);
    	}
    	}
    	size++;
    }
    public int extractMin(){
    	if(size==0){
    		return -1;
    	}
    	int top = harr[0];
    	harr[0] = harr[size-1];
    	harr[size-1] = 0;
    	size--;
    	minHeapify(harr,0);
    	return top;
    }
    public void deleteKey(int k){
    	if(k>=size){
    		return;
    	}
    	int deleted = harr[k];
    	harr[k] = harr[size-1];
    	harr[size-1] = 0;
    	size--;
    	if(deleted<harr[k]){
    		minHeapify(harr,k);
    	}else{
    		while(k>0 && harr[parent(k)]>harr[k]){
    			swap(harr,parent(k),k);
    			k = parent(k);
    		}
    	}
    }
    public void decreaseKey(int i, int new_val){
    	 harr[i] = new_val;
    	 while (i != 0 && harr[parent(i)] > harr[i])
         {
             int temp = harr[i] ;
             harr[i] = harr[parent(i)];
             harr[parent(i)] = temp;
             i = parent(i);
         }
    }
    public void minHeapify(int[] harr,int i){
    	while(i<size){
    		int l = left(i);
    		int r = right(i);
    		int smallest = i;
    		if(l<size && harr[l]<harr[i]){
    			smallest = l;
    		}
    		if(r<size && harr[r]<harr[smallest]){
    			smallest = r;
    		}
    		if(smallest!=i){
    			swap(harr,smallest,i);
    		}else{
    			break;
    		}
    		i = smallest;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {28,21,23,14,17,15,9,8,5,11,6,3};
		//int[] arr = {4,2,7,6,9};
		PriorityQueue<Integer> pq = 
                new PriorityQueue<Integer>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }        
        long sum=0;
        while(!pq.isEmpty()){
            int a = pq.remove();
            int b = pq.remove();
            sum+=a+b;
            if(pq.isEmpty()){
                break;
            }
            pq.add(a+b);
        }
        System.out.println(sum);
		 Iterator itr = pq.iterator(); 
	        while (itr.hasNext()) 
	            System.out.print(itr.next()+" "); 
	}

}

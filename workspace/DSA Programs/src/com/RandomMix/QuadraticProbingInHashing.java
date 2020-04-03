package PractiseJavaPrograms;

import java.util.HashMap;


public class QuadraticProbingInHashing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] arr ={21,10,32,43};
     int hash_size = 11;
     int[] hash_table = new int[hash_size];
     for(int i=0;i<hash_size;i++){
    	 hash_table[i] = -1;
     }
     quadraticProbing(hash_table,hash_size,arr,arr.length);
     for(int i=0;i<hash_size;i++){
    	 System.out.print(hash_table[i]+" ");
     }
     HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
     int[] arr2 = {1,1,2,2,3,3,3,4,5,6,7};
     for(int i=0;i<arr2.length;i++){
         if(mp.containsKey(arr2[i])){
             mp.put(arr2[i],mp.get(arr2[i])+1);
         }else{
             mp.put(arr2[i],1);
         }
     }
    
	}
	static void quadraticProbing(int hash_table[], int hash_size, 
			int arr[], int n)
			{
			    //Your code here
			    for(int i=0;i<n;i++){
			       int index = hashFunc(arr[i],hash_size,0);
			       if(hash_table[index] == -1){
			           hash_table[index] = arr[i];
			       }else{
			           int j=1,index2 = -1;
			           while(index2!=index){
			               index2 = hashFunc(arr[i],hash_size,j);
			               if(hash_table[index2]==-1){
			                   hash_table[index2] = arr[i];
			                   break;
			               }else{
			                   j++;
			               }
			           }
			       }
			    }
			}
			static int hashFunc(int n, int m, int x){
			    return (n+(x*x))%m;
			}
}

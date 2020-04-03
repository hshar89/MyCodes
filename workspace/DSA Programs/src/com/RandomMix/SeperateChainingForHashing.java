package PractiseJavaPrograms;

import java.util.ArrayList;

public class SeperateChainingForHashing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] arr = {92,4,14,24,44,91};
       int hashSize = 10;
       ArrayList<ArrayList<Integer>> hashTable = new ArrayList<ArrayList<Integer>>(hashSize);
       for(int i=0;i<hashSize;i++){
    	   hashTable.add(new ArrayList<Integer>());
       }
       separateChaining(arr,arr.length,hashTable,hashSize);
       for(int i=0;i<hashTable.size();i++){
    	   if(hashTable.get(i).size()>0){
    		  System.out.print(i+"->");
    		  for(int j=0;j<hashTable.get(i).size()-1;j++){
    			  System.out.print(hashTable.get(i).get(j)+"->");
    		  }
    		  System.out.print(hashTable.get(i).get(hashTable.get(i).size()-1));
    		  System.out.println();
    	   }
       }
	}
	public static void separateChaining(int arr[], int n, 
			ArrayList<ArrayList<Integer>> hashTable, int hashSize)
			{
			    //Your code here
			    for(int i=0;i<n;i++){
			        int index = hashFunc(arr[i],hashSize);
			        if(hashTable.get(index).size() != 0){
			            hashTable.get(index).add(arr[i]);
			        }else{
			            ArrayList<Integer> temp =  new ArrayList<>();
			            temp.add(arr[i]);
			            hashTable.set(index,temp);
			        }
			    }
			    
			}
	static int hashFunc(int n,int m){
	    return n%m;
	}
}

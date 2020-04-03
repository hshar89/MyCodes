package PractiseJavaPrograms;

import java.util.ArrayList;

public class MergeThreeSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static ArrayList<Integer> merge3sorted(int arr1[], int arr2[], int arr3[])
    {
        // add ypur code here
        ArrayList<Integer> al = new ArrayList<>();
        int i=0,j=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<=arr2[j]){
                al.add(arr1[i++]);
            }else{
                al.add(arr2[j++]);
            }
        }
        while(i<arr1.length){
            al.add(arr1[i++]);
        }
        while(j<arr2.length){
            al.add(arr2[j++]);
        }
        int mid = al.size()-1;
        for(i=0;i<arr3.length;i++){
            al.add(arr3[i]);
        }
        i=0;
        j=mid+1;
        while(i<=mid && j<al.size()){
            if(al.get(i)>al.get(j)){
               int value = al.get(j);
               int index = j;
               while(index!=i){
                   al.set(index,al.get(index-1));
                   index--;
               }
               al.set(index,value);
               j++;
               i++;
               mid++;
            }else{
                i++;
            }
        }
        return al;
    }
	public static ArrayList<Integer> merge3Sorted2(int arr1[], int arr2[], int arr3[]){
		ArrayList<Integer> al = new ArrayList<>();
        int n =arr1.length,m=arr2.length, o=arr3.length;
        int i=0,j=0,k=0;
        while(i<n && j<m && k<o){
            if(arr1[i]<=arr2[j] && arr1[i]<=arr3[k]){
                al.add(arr1[i++]);
            }else if(arr2[j]<=arr1[i] && arr2[j]<= arr3[k]){
                al.add(arr2[j++]);
            }else{
                al.add(arr3[k++]);
            }
        }
        if(i==n){
            while(j<m && k<o){
                if(arr2[j]<= arr3[k]){
                    al.add(arr2[j++]);
                }else{
                    al.add(arr3[k++]);
                }
            }
        }else if(j==m){
            while(i<n && k<o){
                if(arr1[i]<= arr3[k]){
                    al.add(arr1[i++]);
                }else{
                    al.add(arr3[k++]);
                }
            }
        }else{
            while(i<n && j<m){
                if(arr1[i]<= arr2[j]){
                    al.add(arr1[i++]);
                }else{
                    al.add(arr2[j++]);
                }
            }
        }
        while(i<n){
            al.add(arr1[i++]);
        }
        while(j<m){
            al.add(arr2[j++]);
        }
        while(k<o){
            al.add(arr3[k++]);
        }
        return al;
	}
}

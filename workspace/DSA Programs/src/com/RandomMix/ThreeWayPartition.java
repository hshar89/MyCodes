package PractiseJavaPrograms;

import java.util.ArrayList;

public class ThreeWayPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ArrayList<Integer> al1 = new ArrayList<>();
       /*al1.add(1);
       al1.add(4);
       al1.add(3);
       al1.add(9);
       al1.add(28);
       al1.add(2);
       al1.add(7);
       al1.add(10);*/
       String ab="3 18 93 53 57 2 81 87 42 66 90 45 20 41 30 32 18 98";
       String[] abA = ab.split("\\s+");
       for(int i=0;i<abA.length;i++){
    	   al1.add(Integer.parseInt(abA[i]));
       }
       System.out.println("before proceesing array list");
       al1.forEach(n -> System.out.print(n+" "));
       threeWayPartition(al1,22,64);
       System.out.println("\nafter proceesing array list");
       al1.forEach(n -> System.out.print(n+" "));
      /* System.out.println("\nthis is for arrays ");
       String ab="3 18 93 53 57 2 81 87 42 66 90 45 20 41 30 32 18 98";
       ab="6 22 68 5 14 62 55 27 60 45 3 3 7 85";
       String[] abA = ab.split("\\s+");
       int[] arr2 = new int[abA.length];
       for(int i=0;i<arr2.length;i++){
    	   arr2[i] = Integer.parseInt(abA[i]);
       }
       int[] arr = {6,22, 68, 5, 14, 62, 55, 27, 60, 45, 3, 3, 7, 85};
       System.out.println("\nOrginal array");
       printArray(arr2);
       partition(arr2,arr2.length,22);
       System.out.println("\nafter 1st processing ");
       printArray(arr2);
       //partition(arr2,arr2.length,64);
       //System.out.println("\nafter 2nd processing ");
       //printArray(arr2);
     */  
	}
	public static ArrayList<Integer> threeWayPartition(ArrayList<Integer> A,
			int a, int b){
			//partitionList(A,a);
			//partitionList(A,b);
			int low = 0,mid=0,high=A.size()-1;
			while(mid<=high){
			    if(A.get(mid)<a){
			        swap(A,mid,low);
			        mid++;
			        low++;
			    }else if(A.get(mid) > b){
			        swap(A,mid,high);
			        high--;
			    }else{
			        mid++;
			    }
			}
	        return A;
		}
	static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	static void partitionList(ArrayList<Integer> al,int a){
		int i=-1,temp,pos=-1;
		for(int j=0;j<al.size();j++){
			if(al.get(j) == a){
				pos = j;
				break;
			}
		}
		for(int j=0;j<al.size();j++){
			if(al.get(j)<a){
				i++;
				temp = al.get(j);
				al.set(j, al.get(i));
				al.set(i, temp);
			}
		}
		if(pos!=-1){
			
			temp = al.get(i);
			al.set(i,a);
			al.set(pos, temp);
		}
	}
	
	static void swap(ArrayList<Integer> al,int i,int j){
        int temp = al.get(i);
        al.set(i,al.get(j));
        al.set(j,temp);
    }
	static void partition(int[] arr,int n,int pivot){
		int i=-1,temp,pos=-1;
		for(int j=0;j<n;j++){
			if(arr[j] == pivot){
				pos = j;
				break;
			}
		}
		for(int j=0;j<n;j++){
			if(arr[j] == pivot){
				i++;
			}else if(arr[j]<pivot){
				i++;
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		if(pos!=-1){
			System.out.println("i "+i+" pos "+pos);
		temp = arr[i+1];
		arr[i+1] = pivot;
		arr[pos] = temp;
		}
	}

}

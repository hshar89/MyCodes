package LearningFromGFG;

import java.util.Random;

class ThreeSort{
public void quickSort(int[] arr){
	//shuffleArray(arr);
	quickSort(arr,0,arr.length-1);
}
public static void quickSort(int[] arr, int low,int high){
	if(low>=high){
		return;
	}
	//{1, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4};
	/*
	 * The below piece of code starts with the end value as pivot 
	 * and keeps swapping the values which are lower then the pivot value
	 * So for the above case the series of 4s will keep moving 
	 * upwards till all fours are together
	 * Also the pivot remains same for a while loop
	 * So pivot values move together and the rest of array is sorted
	 */
	int pivot = arr[high];
	int i=low;
	int lowerIndex = low;
	int greaterIndex = high;
	while(i<= greaterIndex){
		if(arr[i]<pivot){
			//The value for lowerIndex and i increments in this function
			//but is not passed to the swap function
			swap(arr,lowerIndex++,i++);
		}else if(arr[i]> pivot){
			swap(arr,i,greaterIndex--);
		}else{
			i++;
		}
     System.out.println("i "+i+" lowerIndex "+lowerIndex+" greaterIndex "+greaterIndex);
	 for(int r=0;r<arr.length;r++){
		 System.out.println(" present state arr["+r+"] "+arr[r]);
	 }
	}
	quickSort(arr,low,lowerIndex-1);
	quickSort(arr,greaterIndex+1,high);
}
public static void swap(int[] arr, int i, int j){
	//Swap function will  not have the incremented value
	//It will have what was passed before increment/decrement
	System.out.println("this is value at swap "+" i "+i+" j "+j);
	int temp = arr[i];
	arr[i]=arr[j];
	arr[j] = temp;	
}
private static void shuffleArray(int[] ar) {
    Random rnd = new Random();
    for (int i = ar.length - 1; i > 0; i--) {
        int index = rnd.nextInt(i + 1); // random between 0 and i
        swap(ar, i, index);
    }
}
}
public class ThreeWayQuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 4, 2, 4, 2, 6, 1, 2, 4, 1, 5, 3, 9, 1, 2, 4, 1, 4, 4, 4};
    ThreeSort ts = new ThreeSort();
    ts.quickSort(arr);
    System.out.println("after sorting##");
    for(int i =0;i<arr.length;i++){
    	System.out.print(arr[i]+" ");
    }
	}

}

package PractiseJavaPrograms;

public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] arr = {1,4,1,2,7,5,2};
     countingSort(arr,arr.length);
     //printArray(arr,arr.length);
	}
	static void printArray(int[] arr, int n){
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}
	static void countingSort(int[] arr, int n){
		int[] rangeA = new int[10];
		int max=-1;
		for(int i=0;i<n;i++){
			if(arr[i]>max){
				max = arr[i];
			}
			rangeA[arr[i]]++;
		}
		/*for(int i=1;i<rangeA.length;i++){
			rangeA[i] = rangeA[i]+rangeA[i-1];
		}*/
		int j=0;
		for(int i=0;i<=max;i++){
			int temp = rangeA[i];
			while(temp-->0){
				arr[j] = i;
				j++;
			}
		}
		printArray(arr,7);
	}

}

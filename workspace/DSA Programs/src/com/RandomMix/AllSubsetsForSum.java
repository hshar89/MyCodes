package PractiseJavaPrograms;

public class AllSubsetsForSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] arr = {2,3,8,5,9,4};
      printAllSubsetsForSum(arr,0,7);
	}
	static void printAllSubsetsForSum(int[] arr,int index,int num){
		if(index>(arr.length-1)){
			return;
		}
		System.out.println();
		System.out.print(" index "+index);
		//System.out.print(" arr[0] "+arr[0]);
		//System.out.print(" arr[1] "+arr[1]);
		   if((arr[0] + arr[index]) == num){
			   //System.out.println(" \n printing ");
			   System.out.println(arr[0]+" "+arr[index]+" ");
			   return;
		   }
		   int temp = arr[0];
		   arr[0] = arr[index];
		   arr[index] = temp;
		   printAllSubsetsForSum(arr,index+1,num);
		   /*temp = arr[1];
		   arr[1] = arr[index];
		   arr[index] = temp;*/
		   //printAllSubsetsForSum(arr,index+1,num);
	}

}

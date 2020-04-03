package PractiseJavaPrograms;

import java.util.HashMap;

public class Equal1sAnd0s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int[] arr ={1,0,0,1,0,1,1};
   countSubarrWithEqualZeroAndOne(arr,arr.length);
	}
	static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
        int pre_sum =0,res=0;
        for(int i=0;i<n;i++){
        	//Replacing 0's in array with -1 
            if(arr[i] == 0){
                arr[i] = -1;
            }
            pre_sum +=arr[i];
          //If sum = 0, it implies number of 0's and 1's are  
            //equal from arr[0]..arr[i] 
            if(pre_sum == 0){
                res++;
            }
            if(hs.containsKey(pre_sum)){
                res+=hs.get(pre_sum);
            }
            Integer count = hs.get(pre_sum);
            if(count == null){
                hs.put(pre_sum,1);
            }else{
                hs.put(pre_sum,count+1);
            }
        }
        return res;
    }
}

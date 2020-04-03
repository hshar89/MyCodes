package PractiseJavaPrograms;

import java.util.Stack;

public class MaxOfMinForWindowSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int[] arr = {10, 20, 30, 50, 10, 70, 30};
   printMaxOfMin2(arr, arr.length);
	}
	static void printMaxOfMin2(int[] arr, int n) { 
		// Your code here
       int left[] = new int[n+1];
       int right[] = new int[n+1];
       Stack<Integer> st = new Stack<Integer>();
       st.push(0);
       for(int i=1;i<n;i++){
           if(arr[st.peek()]>arr[i]){
               while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                   right[st.pop()] = i;
               }
           }
           st.push(i);
       }
       while(!st.isEmpty()){
           right[st.pop()]  = n;
       }
       st.push(n-1);
       for(int i=n-2;i>=0;i--){
    	   if(arr[st.peek()]>arr[i]){
    		   while(!st.isEmpty() && arr[st.peek()]>arr[i]){
    			   left[st.pop()] = i;
    		   }
    	   }
    	   st.push(i);
       }
       while(!st.isEmpty()){
    	   left[st.pop()] = -1;
       }
       int[] ans = new int[n+1];
       for(int i=0;i<n;i++){
    	   int len = right[i] - left[i] -1;
    	   ans[len] = Math.max(ans[len], arr[i]);
       }
       for(int i=n-1;i>0;i--){
    		   ans[i] = Math.max(ans[i], ans[i+1]);
       }
       
       printArray(ans,n+1);
	}
	static void printArray(int[] ar, int n){
		for(int i=0;i<n;i++){
			System.out.print(ar[i]+" ");
		}
	}
    /*
     * This is the naive solution for this
     */
	static void printMaxOfMin(int[] arr, int n) { 
		// Your code here
		StringBuffer ab = new StringBuffer();
    for(int k=0;k<n;k++){
        int i=0,j=k;
        Stack<Integer> st= new Stack<Integer>();
        st.push(Integer.MIN_VALUE);
       while(j<n){
           int min  = Integer.MAX_VALUE;
           //System.out.println("i "+i+" j "+j);
         for(int r=i;r<=j;r++){
             if(arr[r]<min){
                 min = arr[r];
             }
            // System.out.println("min "+min);
         }
         if(st.peek() <min){
            st.push(min);
        }
         i++;
         j++;
       }
        ab.append(st.pop()+" ");
    }
    System.out.println(ab);
	}
	
}

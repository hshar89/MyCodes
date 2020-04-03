package PractiseJavaPrograms;

import java.util.Stack;

public class StockSpanProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] arr = new int[]{100, 80, 60, 70, 60, 75, 85};
      int[] s = new int[arr.length];
      calculateSpan(arr,arr.length,s);
      for(int i=0;i<arr.length;i++){
    	  System.out.print(s[i]+" ");
      }
	}
	 public static void calculateSpan(int price[], int n, int S[])
	    {
	        // Your code here
	        Stack<Integer> st = new Stack<Integer>();
	        st.push(0);
	        S[0] = 1;
	        for(int i=1;i<n;i++){
	            while(!st.isEmpty() && price[st.peek()]<=price[i]){
	                st.pop();
	            }
	            S[i] = i-(st.isEmpty()==true?-1:st.peek());
	            st.push(i);
	        }
	    }
}

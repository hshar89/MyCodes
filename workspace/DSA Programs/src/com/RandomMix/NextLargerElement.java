package PractiseJavaPrograms;

import java.util.Stack;

public class NextLargerElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      long[] ar = new long[]{6l, 8l, 0l, 1l, 3l};
      printNGE(ar,ar.length);
	}
	 public static void printNGE(long[] arr, int n) { 
	        // Your code here
	        Stack<Integer> st = new Stack<Integer>();
	        long s[] = new long[n];
	        StringBuffer ab = new StringBuffer();
	        st.push(0);
	        for(int i=1;i<n;i++){
	            while(!st.isEmpty() && arr[i]>arr[st.peek()]){
	                s[st.pop()] = arr[i];
	            }
	            st.push(i);
	        }
	        for(int i=0;i<n;i++){
	            if(s[i]==0l){
	                ab.append("-1 ");
	            }else{
	                ab.append(s[i]+" ");
	            }
	        }
	        System.out.print(ab);
	    } 
}

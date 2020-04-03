package PractiseJavaPrograms;

import java.util.Stack;

public class DeleteMidOfStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Stack<Integer> st = new Stack<Integer>();
       st.push(1);
       st.push(2);
       st.push(3);
       st.push(4);
       st.push(5);
       st.push(6);
       deleteMid(st,st.size(),0);
	}
	
	 public static Stack<Integer> deleteMid(Stack<Integer>s,int n,int curr)
	    {
	        //Your code here
	        if(curr == n/2){
	            s.pop();
	            return s;
	        }
	        
	       int data = s.pop();
	       curr++;
	       s = deleteMid(s,n,curr);
	       s.push(data);
	       return s;
	    } 
}

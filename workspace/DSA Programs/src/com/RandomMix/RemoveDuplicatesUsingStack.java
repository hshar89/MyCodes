package PractiseJavaPrograms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RemoveDuplicatesUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String ab = "oagciicgaoyjmabhamy";
      System.out.println(removePair(ab));
      
      Queue<Integer> q1 = new LinkedList<Integer>();
      Queue<Integer> q2 = new LinkedList<Integer>();
      q1.poll();
      q1 = q2 ;
      
      
	}
	public static String removePair(String str){
        // your code here
        Stack<Character> st = new Stack<Character>();
        st.push(str.charAt(0));
        StringBuffer sb= new StringBuffer();
        for(int i=1;i<str.length();i++){
         if(!st.isEmpty()&&st.peek()==str.charAt(i)){
             st.pop();
         }else{
             st.push(str.charAt(i));
         }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        String ab ="";
        for(int i=sb.length()-1;i>=0;i--){
            ab+=sb.charAt(i);
        }
        return ab;
    }
}

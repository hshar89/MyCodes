package PractiseJavaPrograms;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Program to generate Binary numbers till n
 */
public class PrintBinaryUsingQueues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       generate(13l);
	}
	static void generate(long n)
    {
        // Your code here
        Queue<String> q = new LinkedList<String>();
       Deque<Integer> dq = new LinkedList<Integer>();
       
        q.add("1");
        StringBuffer sb = new StringBuffer();
        for(long i=0l;i<n;i++){
            sb.append(q.peek()+" ");
            String a = q.peek();
            String b = q.peek();
            a+="0";
            b+="1";
            q.add(a);
            q.add(b);
            q.remove();
        }
        System.out.print(sb);
    }
    
}

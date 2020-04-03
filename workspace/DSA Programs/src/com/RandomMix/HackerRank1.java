package PractiseJavaPrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HackerRank1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String ab = "abc(+e^*";
       char[] ch = ab.toCharArray();
       Stack<String> sk = new Stack<String>();
       for(int i=0;i<ch.length;i++){
    	   //System.out.println("ch "+(int)ch[i]);
    	   sk.push(String.valueOf(ch[i]));
       }
       char a1 = 'a';
       System.out.println("a "+(int)a1+" z "+(int)'z'+" A "+(int)'A'+ " Z "+(int)'Z');
       
       //sk.push("(");
       //sk.push("a");
       //sk.push("b");
       while(sk.peek().charAt(0)!='('){
    	   System.out.println("sk "+sk.pop());
       }
       System.out.println("the last pop "+sk.pop());
       if(sk.isEmpty()){
    	   System.out.println("empty");
       }else{
       sk.peek();
       }
       int fp = (int)'^';
       String rt = String.valueOf(ch[0]);
       char ch1 = rt.charAt(0);
       System.out.println("testign bitwise and "+ (~5));
       //sk.push(ch[0]);
	}
	 static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
         List<Integer> score = new ArrayList<Integer>();
         int a1=0,b1=0;
         for(int i=0;i<a.size();i++){
             if(a.get(i)>b.get(i)){
            	 a1++;
                 score.set(0, a1);
             }else if(a.get(i)<b.get(i)){
            	 b1++;
            	 score.set(1,b1); 
             }
         }
       return score;
}

}

package PractiseJavaPrograms;

import java.util.Stack;

public class CelebrityProblemStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          int[][] M = new int[][]{{0,1,0},{0,0,0},{0,1,0}};
          System.out.println("celebrity is: "+findCelebrity(M,M.length));
	}
    static boolean knows(int[][] M, int a, int b){
    	if(M[a][b] == 1){
    		return true;
    	}
    	return false;
    }
    static int findCelebrity(int[][]M, int n){
    	Stack<Integer> st = new Stack<>();
    	for(int i=0;i<n;i++){
    		st.push(i);
    	}
    	while(st.size()>1){
    		int a = st.pop();
    		int b =st.pop();
    		if(knows(M,a,b)){
    			st.push(b);
    		}else{
    			st.push(a);
    		}
    	}
    	int c = st.pop();
    	for(int i=0;i<n;i++){
    		if(i!=c && (!knows(M,i,c)|| knows(M,c,i))){
    			return -1;
    		}
    	}
    	return c;
    }
}

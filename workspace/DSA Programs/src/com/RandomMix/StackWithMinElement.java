package PractiseJavaPrograms;

import java.util.Stack;

public class StackWithMinElement {
	 Stack<Integer> s; 
	  Integer minEle; 
	  StackWithMinElement() { 
		  s = new Stack<Integer>();
		  } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackWithMinElement s = new StackWithMinElement(); 
	        s.push(3); 
	        s.push(5); 
	        s.getMin(); 
	        s.push(2); 
	        s.push(1); 
	        s.getMin(); 
	        s.pop(); 
	        s.getMin(); 
	        s.pop(); 
	        s.peek(); 
	}
	void getMin(){
		if(s.isEmpty()){
			System.out.println("Stack is Empty");
		}
		else{
			System.out.println("Minimum Element in the " + 
                    " stack is: " + minEle); 
		}
	}
	void push(int x){
		if(s.isEmpty()){
			minEle = x;
			s.push(x);
		}else{
			if(x<minEle){
				minEle = x;
				x = 2*x-minEle;
			}
			s.push(x);
		}
		
	}
	void peek(){
		if (s.isEmpty()) 
        { 
            System.out.println("Stack is empty "); 
            return; 
        } 
		 Integer t = s.peek(); // Top element. 
		  
	        System.out.print("Top Most Element is: "); 
	  
	        // If t < minEle means minEle stores 
	        // value of t. 
	        if (t < minEle) 
	            System.out.println(minEle); 
	        else
	            System.out.println(t); 
	}
	void pop(){
		if(s.isEmpty()){
			System.out.println("Stack is Empty");
			return;
		}
		int x = s.pop();
		if(x<minEle){
			System.out.println(minEle);
			minEle = 2*minEle - x;
		}else{
			System.out.println("Element: "+x);
		}
	
	}
	

}

package PractiseJavaPrograms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Stack;

/**
 * Following is algorithm for evaluation postfix expressions.
1) Create a stack to store operands (or values).
2) Scan the given expression and do following for every scanned element.
…..a) If the element is a number, push it into the stack
…..b) If the element is a operator, pop operands for the operator from stack. 
Evaluate the operator and push the result back to the stack
3) When the expression is ended, the number in the stack is the final answer
 * @author harshsharma3
 *
 */
public class PostFixToInfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp="231*+9-";
        System.out.println("postfix evaluation: "+evaluatePostfix(exp));
        String exp2 = "100 200 + 2 / 5 * 7 +"; 
        exp2 = "10 5 + 60 6 / * 8 -";
        System.out.println(evaluatePostfix2(exp2));
	}
	static int evaluatePostfix(String exp) 
    { 
		 Stack<Integer> stack=new Stack<>(); 
		 for(int i=0;i<exp.length();i++) 
	        { 
	            char c=exp.charAt(i); 
	            // If the scanned character is an operand (number here), 
	            // push it to the stack. 
	            if(Character.isDigit(c)) 
	            stack.push(c - '0'); 
	            //  If the scanned character is an operator, pop two 
	            // elements from stack apply the operator 
	            else
	            { 
	                int val1 = stack.pop(); 
	                int val2 = stack.pop(); 
	                switch(c) 
	                { 
	                    case '+': 
	                    stack.push(val2+val1); 
	                    break; 
	                      
	                    case '-': 
	                    stack.push(val2- val1); 
	                    break; 
	                      
	                    case '/': 
	                    stack.push(val2/val1); 
	                    break; 
	                      
	                    case '*': 
	                    stack.push(val2*val1); 
	                    break; 
	              } 
	            } 
	        } 
	        return stack.pop();
	            
	        }
	// Method to evaluate value of a postfix expression 
	//This one is for greater than single digit numbers
	// with space int expression
    static int evaluatePostfix2(String exp) 
    { 
        //create a stack 
        Stack<Integer> stack = new Stack<>(); 
          
        // Scan all characters one by one 
        for(int i = 0; i < exp.length(); i++) 
        { 
            char c = exp.charAt(i); 
              
            if(c == ' ') 
            continue; 
              
            // If the scanned character is an operand  
            // (number here),extract the number 
            // Push it to the stack. 
            else if(Character.isDigit(c)) 
            { 
                int n = 0; 
                  
                //extract the characters and store it in num 
                while(Character.isDigit(c)) 
                { 
                    n = n*10 + (int)(c-'0'); 
                    i++; 
                    c = exp.charAt(i); 
                } 
                i--; 
  
                //push the number in stack 
                stack.push(n); 
            } 
              
            // If the scanned character is an operator, pop two 
            // elements from stack apply the operator 
            else
            { 
                int val1 = stack.pop(); 
                int val2 = stack.pop(); 
                  
                switch(c) 
                { 
                    case '+': 
                    stack.push(val2+val1); 
                    break; 
                      
                    case '-': 
                    stack.push(val2- val1); 
                    break; 
                      
                    case '/': 
                    stack.push(val2/val1); 
                    break; 
                      
                    case '*': 
                    stack.push(val2*val1); 
                    break; 
            } 
            } 
        } 
        return stack.pop();  
    } 
    }

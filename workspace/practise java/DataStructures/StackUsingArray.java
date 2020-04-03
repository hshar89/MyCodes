package DataStructures;

public class StackUsingArray {
   static final int MAX = 1000;
   int top;
   int arr[] = new int[MAX];
   StackUsingArray(){
	   top = -1;
   }
   boolean push(int a){
	   if(top >= MAX-1){
		   System.out.println("Stack Overflow"); 
           return false; 
	   }else{
		   arr[++top] = a;
		   System.out.println(a + " pushed into stack"); 
           return true; 
	   }
   }
   int pop(){
	   if(top <0){
		   System.out.println("Stack Underflow"); 
           return 0; 
	   }else{
		   int x = arr[top--]; 
           return x; 
	   }
   }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingArray s = new StackUsingArray(); 
	        s.push(10); 
	        s.push(20); 
	        s.push(30); 
	        System.out.println(s.pop() + " Popped from stack"); 
	}

}

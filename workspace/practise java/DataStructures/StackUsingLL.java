package DataStructures;

public class StackUsingLL {
   Node root;
   public boolean isEmpty(){
	   if(root == null){
		   return true;
	   }
	   return false;
   }
   public void push(int a){
	   Node newRoot = new Node(a);
	   if(root == null){
		   root = newRoot;
	   }else{
		   Node temp = root;
		   root = newRoot;
		   newRoot.next = temp;
	   }
	   System.out.println(a + " pushed to stack"); 
   }
   public int pop(){
	   int popped = Integer.MIN_VALUE;
	   if(root == null){
		   System.out.println("Stack is Empty"); 
	   }else{
		   popped = root.data;
		   root = root.next;
	   }
	   return popped;
   }
   public int peek() { 
       if (root == null) { 
           System.out.println("Stack is empty"); 
           return Integer.MIN_VALUE; 
       } else { 
           return root.data; 
       } 
         
   } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingLL sll = new StackUsingLL(); 
		  
	        sll.push(10); 
	        sll.push(20); 
	        sll.push(30); 
	  
	        System.out.println(sll.pop() + " popped from stack"); 
	      
	        System.out.println("Top element is " + sll.peek()); 
	  
	}

}

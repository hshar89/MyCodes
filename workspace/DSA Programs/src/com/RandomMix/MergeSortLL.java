package PractiseJavaPrograms;

public class MergeSortLL {
	 Node head;
	 void printList(Node node) { 
	      while (node != null) { 
	          System.out.print(node.data + " "); 
	          node = node.next; 
	      } 
	  } 
	 public void addToLast(Node node) 
	  { 
		 if(head == null){
			 head = node;
		 }else{
			 Node temp = head;
			 while(temp.next!=null){
				 temp = temp.next;
			 }
				 temp.next = node;
		 }
	  } 
	 /*
	  * This is an in-house merge sort
	  */
	 static Node mergeSort(Node head)
	    {
	        if(head == null || head.next == null){
	            return head;
	        }
	        Node slow = head,fast =head.next;
	        while(fast!=null){
	            fast = fast.next;
	            if(fast!=null){
	                fast = fast.next;
	                slow= slow.next;
	            }
	        }
	        Node head2 = slow.next;
	        slow.next = null;
	        head = mergeSort(head);
	        head2 = mergeSort(head2);	       
	        Node res = merge(head,head2);
	        return res;
	    }
	   /*
	    * This method is use to merge two sorted LL
	    */
	    static Node merge(Node a, Node b){
	        Node result = null;
	        if(a == null){
	            return b;
	        }
	        if(b== null){
	            return a;
	        }
	        if(a.data<=b.data){
	           result = a;
	           result.next = merge(a.next,b);
	        }else{
	            result = b;
	            result.next = merge(a,b.next);
	        }
	        //System.out.println("printing merge");
	        //printList(result);
	        return result;
	    }
	 static Node sortedMerge(Node headA, Node headB) {
	     // This is a "method-only" submission. 
	     // You only need to complete this method
	     Node head = headB;
	     Node tempA = null;
	     Node tempB = headB;
	     Node prev = null,next=null;
	    
	     //while(headA!=null){
	         while(tempB!=null){
	        	 System.out.println(" tempB start "+tempB.data);
	             if(headA.data<tempB.data){
	            	 System.out.println("head a "+headA.data+" tempb "+tempB.data);	            	
	                 tempA = headA;
	                 headA = headA.next;
	                 System.out.println(" heada next "+headA.data);
	                 if(prev == null){
	                     head = tempA;
	                     head.next = tempB;
	                 }else{
	                	 System.out.println(" prev "+prev.data);
	                 prev.next = tempA;
	                 tempA.next = tempB;
	                // System.out.println("tempA inside "+headA.data);
	                 //System.out.println("tempA next "+next.next.data);
	                 }
	                 tempB = tempA;
	             }/*else if(headA.next == null && tempB.data<headA.data){
	                 tempB.next = headA;
	                 break;
	             }*/
	             else{
	             System.out.println("tempB inside "+tempB.data);
	             prev = tempB;
	             tempB = tempB.next;
	             }
	         }
	         if(headA !=null && headA.next == null){
	        	 prev.next = headA;
	         }
	         //System.out.println(" prev "+prev.data);
	         //prev = tempA;
	         //tempB = tempA;
	         //break;
	         //tempA = headA;
	     //}
	     return head;
	   } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSortLL llist3 = new MergeSortLL(); 
		MergeSortLL llist4 = new MergeSortLL();
		MergeSortLL llist5 = new MergeSortLL();
		MergeSortLL llist6 = new MergeSortLL();
          llist3.addToLast(new Node(5));
          llist3.addToLast(new Node(10));
          llist3.addToLast(new Node(15));
          llist3.addToLast(new Node(40));
          
          llist4.addToLast(new Node(2));
          llist4.addToLast(new Node(3));
          llist4.addToLast(new Node(20));
          
          llist5.addToLast(new Node(1));
          llist5.addToLast(new Node(1));
          
          llist6.addToLast(new Node(2));
          llist6.addToLast(new Node(4));
          Node head = sortedMerge(llist5.head,llist6.head);
          while(head!=null){
          	System.out.print(head.data+" ");
          	head = head.next;
          }
	}

}

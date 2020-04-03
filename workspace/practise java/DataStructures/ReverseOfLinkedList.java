package DataStructures;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;
public class ReverseOfLinkedList {
   Node head;
	  
  Node reverse(Node node) { 
      Node prev = null; 
      Node current = node; 
      Node next = null; 
      while (current != null) { 
          next = current.next; 
          current.next = prev; 
          prev = current; 
          current = next; 
      } 
      node = prev; 
      return node; 
  } 
  // prints content of double linked list 
  void printList(Node node) { 
	  System.out.println("node "+node.data);
      while (node != null) { 
          System.out.print(node.data + " "); 
          node = node.next; 
      } 
  } 
  
  public static boolean detectLoop1(Node h){
	  HashSet<Node> hs1 = new HashSet<Node>();
	  if(h == null){
		  return false;
	  }
	  while(h!=null){
		  if(hs1.contains(h)){
			  return true;
		  }
		  hs1.add(h);
		  h = h.next;
	  }
	  return false;
  }
  public static void removeLoop(Node head){
	  //Your code here
      if(head == null){
          return;
      }
      Node h = head.next, t = head;
      while(h.next != null){
          if(t == h){
             break; 
          }
          t= t.next;
          h= h.next.next;
      }
      int loopLen = 1;
      h = h.next;
      while(h!=null && h != t){
          h = h.next;
          loopLen++;
      }
      t=head;
      Node begin = head,prev=null;
      int i = 1;
      while(t.next!=null && i<=loopLen){
          t  = t.next;
          i++;
      }
      while(t!= begin){
          prev = t;
          begin = begin.next;
          t = t.next;
      }
      prev.next = null;
  }
  /* Inserts a new Node at front of the list. */
   public void push(int new_data) 
  { 
      /* 1 & 2: Allocate the Node & 
                Put in the data*/
      Node new_node = new Node(new_data); 

      /* 3. Make next of new Node as head */
      new_node.next = head; 

      /* 4. Move the head to point to new Node */
      head = new_node; 
  } 
  //This is Flyod's Cycle algo
  int detectLoop2() 
  { 
      Node slow_p = head, fast_p = head; 
      while (slow_p != null && fast_p != null && fast_p.next != null) { 
          slow_p = slow_p.next; 
          fast_p = fast_p.next.next; 
          if (slow_p == fast_p) { 
              System.out.println("Found loop"); 
              return 1; 
          } 
      } 
      return 0; 
  } 
  int detectAndRemoveNode(Node node){
	  Node slow = node,fast = node;
	  if(slow!=null && fast!= null && fast.next!=null){
		  slow = slow.next;
		  fast = fast.next.next;
		  if(slow == fast){
			  removeLoop(slow,node);
			  return 1;
		  }
	  }
	  return 0;
  }
  void removeLoop(Node loop, Node head){
	  Node ptr1 = loop, ptr2 = loop;
	  int k=1,i;
	  while(ptr2.next!=ptr1){
		  ptr2 = ptr2.next;
		  k++;
	  }
	  ptr1 = head;
	  ptr2 = head;
	  for(i=0;i<k;i++){
		  ptr2 = ptr2.next;
	  }
	  /*  Move both pointers at the same pace, 
      they will meet at loop starting node */
	  while(ptr2.next != ptr1){
		  ptr1 = ptr1.next;
		  ptr2 = ptr2.next;
	  }
	  // Get pointer to the last node 
      while (ptr2.next != ptr1) { 
          ptr2 = ptr2.next; 
      } 
      /* Set the next node of the loop ending node 
      to fix the loop */
     ptr2.next = null; 
  }
  void detectAndRemoveLoop2(Node node){
	  if(node == null || node.next == null){
		  return;
	  }
	  Node slow = node,fast =node;
	  slow = slow.next;
	  fast = fast.next.next;
	  // Search for loop using slow and fast pointers 
      while (fast != null && fast.next != null) { 
          if (slow == fast)  
              break; 
            
          slow = slow.next; 
          fast = fast.next.next; 
      } 
      /* If loop exists */
      if(slow == fast){
    	  slow = node;
    	  while(slow.next != fast.next){
    		  slow = slow.next;
    		  fast = fast.next;
    	  }
    	  /* since fast->next is the looping point */
    	  fast.next = null;
      }
  }
  Node reverseThroughRecurssion2(Node head){
	  if(head == null){
		  return head;
	  }
	  if(head.next == null){
		  return head;
	  }
	  Node newHeadNode = reverseThroughRecurssion2(head.next);
	  head.next.next = head;
	  head.next = null;
	  return newHeadNode;
  }
  Node reverseThroughRecursion1(Node curr, Node prev){
	  if(curr.next ==null){
		  head = curr;
	  curr.next = prev;
	  return head;
	  }
	  Node next1 = curr.next;
	  curr.next = prev;
	  reverseThroughRecursion1(next1, curr);
	  return head;
  }
  Node reverseByKey2(Node node,int k){

      Node current = node; 
      Node next = null; 
      Node prev = null; 
        
      int count = 0; 
 
      /* Reverse first k nodes of linked list */
      while (count < k && current != null)  
      { 
          next = current.next; 
          current.next = prev; 
          prev = current; 
          current = next; 
          count++; 
      } 
 
      /* next is now a pointer to (k+1)th node  
         Recursively call for the list starting from current. 
         And make rest of the list as next of first node */
      if (next != null)  
         node.next = reverseByKey2(next, k); 
 
      // prev is now head of input list 
      return prev; 
  }
  public Node reverseBykey(Node node, int k)
  {
	// Create a stack of Node*  
	    Stack<Node> mystack = new Stack<Node> ();  
	    Node current = head;  
	    Node prev = null;  
	  
	    while (current != null) 
	    {  
	  
	        // Terminate the loop whichever comes first  
	        // either current == NULL or count >= k  
	        int count = 0;  
	        while (current != null && count < k) 
	        {  
	            mystack.push(current);  
	            current = current.next;  
	            count++;  
	        }  
	  
	        // Now pop the elements of stack one by one  
	        while (mystack.size() > 0)  
	        {  
	  
	            // If final list has not been started yet.  
	            if (prev == null) 
	            {  
	                prev = mystack.peek();  
	                head = prev;  
	                mystack.pop();  
	            }  
	            else
	            {  
	                prev.next = mystack.peek();  
	                prev = prev.next;  
	                mystack.pop();  
	            }  
	        }  
	    }  
	  
	    // Next of last element will point to NULL.  
	    prev.next = null;  
	  
	    return head; 
  }
 static Node sortedMerge(Node headA, Node headB) {
	     Node dummyNode = new Node(0);
	     Node tail = dummyNode;
	     while(true){
	    	 if(headA == null){
	    		 tail.next = headB;
	    		 break;
	    	 }
	    	 if(headB == null){
	    		 tail.next = headA;
	    		 break;
	    	 }
	    	 if(headA.data<=headB.data){
	    		 tail.next = headA;
	    		 headA = headA.next;
	    	 }else{
	    		 tail.next = headB;
	    		 headB = headB.next;
	    	 }
	    	 tail = tail.next;
	     }
	     return dummyNode.next;
	   } 
  Node sortedMergeByRecursion(Node headA, Node headB){
	  if(headA == null){
		  return headB;
	  }
	  if(headB == null){
		  return headA;
	  }
	  if(headA.data<headB.data){
		  headA.next = sortedMergeByRecursion(headA.next,headB);
		  return headA;
	  }else{
		  headB.next = sortedMergeByRecursion(headA,headB.next);
		  return headB;
	  }
  }
 //Utility function to get the middle of the linked list
  static Node getMiddle(Node h){
	  if(h==null){
		  return h;
	  }
	  Node fast = h.next,slow=h;
	  // Move fastptr by two and slow ptr by one 
      // Finally slowptr will point to middle node
	  while(fast!=null){
		  fast = fast.next;
		  if(fast!=null){
			  fast = fast.next;
			  slow = slow.next;
		  }
	  }
	  return slow;
  }
  static Node mergeSort(Node h){
	  if(h==null || h.next == null){
		  return h;
	  }
	  System.out.println(" h in merge Sort "+h.data);
	  Node middle = getMiddle(h);
	  System.out.println(" middle in MS "+middle.data);
	  Node nextOfMiddle = middle.next;
	  System.out.println(" next of middle "+nextOfMiddle.data);
	  middle.next = null;
	  
	  Node left = mergeSort(h);
	  System.out.println(" left "+left.data);
	  Node right = mergeSort(nextOfMiddle);
	  System.out.println(" rigth "+right.data);
	  Node sortedList = sortedMerge2(left,right);
	  System.out.println(" sorted list "+sortedList.data);
	  return sortedList;
  }
  static Node sortedMerge2(Node a, Node b){
	  if(a==null){
		  return b;
	  }
	  if(b==null){
		  return a;
	  }
	  Node result = null;
	  if(a.data<=b.data){
		  result = a;
		  result.next = sortedMerge(result.next,b);
	  }else{
		  result = b;
		  result.next = sortedMerge(a,result.next);
	  }
	  return result;
  }
  static Node addTwoLinkedList(Node a, Node b, int carry){
	  if(a==null && b == null){
		  return null;
	  }
	  if(a==null){
		  return b;
	  }
	  if(b==null){
		  return a;
	  }
	  System.out.println(" a "+a.data+" b "+b.data);
	  int sum = (a!=null?a.data:0) + (b!=null?b.data:0)+carry;
	  Node temp = new Node(sum%10);
	 // System.out.println(" temp "+temp.data);
	  System.out.println(" sum "+sum);
	  carry = sum/10;
		/*  if(a!=null)
		  a.next = new Node(a.next.data+ (sum/10));
		  else
		  b.next = new Node(b.next.data+ (sum/10)); */
	  
	  temp.next = addTwoLinkedList(a.next,b.next, carry);
	  if(temp.next != null && temp.next.data>9){
		  temp.next.next = new Node((temp.next.data)/10);
		  temp.next = new Node(temp.next.data%10);
	  }
	  return temp;
  }
  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ReverseOfLinkedList list = new ReverseOfLinkedList(); 
	        list.head = new Node(85); 
	        list.head.next = new Node(15); 
	        list.head.next.next = new Node(4); 
	        list.head.next.next.next = new Node(20); 
	        list.head.next.next.next.next = new Node(5); 
	        list.head.next.next.next.next.next = new Node(6); 
	        list.head.next.next.next.next.next.next = new Node(7);  
	       // System.out.println("Given Linked list"); 
	       // list.printList(head); 
	        head = list.reverse(head); 
	        //System.out.println(""); 
	        //System.out.println("Reversed linked list "); 
	       // list.printList(head); 
	        Node res = list.reverseThroughRecursion1(head, null);
	        System.out.println(""); 
	        System.out.println(""); 
	        System.out.println("Reversed linked list "); 
	       // list.printList(res); 
	        
	       // System.out.println(); 
            //System.out.println("Reversed Linked list:"); 
            Node llist1 = list.reverseThroughRecurssion2(list.head); 
           // list.printList(llist1);
            
            /*ReverseOfLinkedList llist = new ReverseOfLinkedList(); 
            
            llist.push(20); 
            llist.push(4); 
            llist.push(15); 
            llist.push(10); 
            
            /*Create loop for testing */
            //llist.head.next.next.next.next = llist.head; 
      
           // if (detectLoop1(head)) 
           //     System.out.println("Loop found"); 
           // else
             //   System.out.println("No Loop"); 
            
            ReverseOfLinkedList llist2 = new ReverseOfLinkedList(); 
            llist2.push(11);
            llist2.push(12);
            llist2.push(13);
            llist2.push(14);
            llist2.push(15);
            llist2.push(16);
            llist2.push(17);
            llist2.push(18);
            llist2.push(19);
            System.out.println(" for reference "+llist2.head.data);
            llist2.printList(llist2.head);
            Node new_head2 = llist2.reverseByKey2(llist2.head,2);
            System.out.println();
            while(new_head2!=null){
            	System.out.print(new_head2.data+" ");
            	new_head2 = new_head2.next;
            }
            //System.out.println("head "+getMiddle(llist2.head).data);
            
            //llist2.printList(new_head);*/
            //mergeSort(llist2.head);
            /*ReverseOfLinkedList llist3 = new ReverseOfLinkedList(); 
            ReverseOfLinkedList llist4 = new ReverseOfLinkedList();
            llist3.push(40);
            llist3.push(15);
            llist3.push(10);
            llist3.push(5);
            
            llist4.push(20);
            llist4.push(3);
            llist4.push(2);
            
            //Node head = sortedMerge(llist3.head,llist4.head);
            //while(head!=null){
            	//System.out.print(head.data+" ");
            	//head = head.next;
            //}
            ReverseOfLinkedList llist5 = new ReverseOfLinkedList(); 
            ReverseOfLinkedList llist6 = new ReverseOfLinkedList();
            
            llist5.push(4);
            llist5.push(7);
            llist5.push(8);
            llist5.push(5);
            
            llist6.push(3);
            llist6.push(1);
            llist6.push(1); 
            
            ReverseOfLinkedList llist7 = new ReverseOfLinkedList(); 
            ReverseOfLinkedList llist8 = new ReverseOfLinkedList(); 
            
            int arr1[] = { 9, 9, 9 }; 
            int arr2[] = { 1, 8 }; 
            // Create first list as 9->9->9 
            for (int i = arr1.length - 1; i >= 0; --i) 
            	llist7.push(arr1[i]); 
      
            // Create second list as 1->8 
            for (int i = arr2.length - 1; i >= 0; --i) 
            	llist8.push(arr2[i]); 
      
           Node new_head =  addTwoLinkedList(llist7.head,llist8.head,0);
           while(new_head != null){
        	   System.out.print(new_head.data+" ");
        	   new_head = new_head.next;
           }*/
            ReverseOfLinkedList llist8 = new ReverseOfLinkedList(); 
            llist8.push(0);
            llist8.push(1);
            llist8.push(1);
            llist8.push(0);
            llist8.push(2);
            llist8.push(1);
            llist8.push(2);
            llist8.push(2);
            //llist8.push(5);
            Node new_head = segregate(llist8.head);
            System.out.println(" priting list ");
            llist2.printList(new_head);
        }
	static Node segregate(Node head)
    {
        // add your code here
        Node last = head,curr=head,prev=null,temp = head;
        //Stack<Node> my2s = new Stack<Node>();
        //Stack<Node> my0s = new Stack<Node>();
        while(last.next!=null){
            last = last.next;
        }
        int counter = 8;
        while(counter-->0){
            curr = temp;
            System.out.println(" curr "+curr.data);
            System.out.println("curr next "+curr.next.data);
            if(curr.data == 2){
                if(prev!=null){
                     System.out.println("prev data "+prev.data);
                 prev.next = curr.next;
                }else{
                	head = curr.next;
                }
                last.next = curr; 
                temp = curr.next;
                curr.next = null;
                last = curr;
                }else if(curr.data ==0 && prev!=null){
                    prev.next = curr.next;
                    temp = curr.next;
                    curr.next = head;
                    head = curr;
                }else{
                    System.out.println("else mei");
                    prev = temp;
                    temp = temp.next;
                }
        }
        System.out.println("head "+head.data);
        return head;
     }
}

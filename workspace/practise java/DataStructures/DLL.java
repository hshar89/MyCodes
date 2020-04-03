package DataStructures;

public class DLL {
	class Node{
		  int data;
		  Node prev;
		  Node next;
		  Node(int d){
			  data = d;
			  prev = null;
			  next =null;
		  }
	}
      Node head;   
      /* Function to reverse a Doubly Linked List */
      void reverse() { 
          Node temp = null; 
          Node current = head; 
    
          /* swap next and prev for all nodes of  
           doubly linked list */
          while (current != null) { 
              temp = current.prev; 
              current.prev = current.next; 
              current.next = temp; 
              current = current.prev; 
          } 
    
          /* Before changing head, check for the cases like empty  
           list and list with only one node */
          if (temp != null) { 
              head = temp.prev; 
          } 
      } 
      // This function prints contents of linked list 
      // starting from the given node 
      public void printlist(Node node) 
      { 
          Node last = null; 
    
          while (node != null) { 
              System.out.print(node.data + " "); 
              last = node; 
              node = node.next; 
          } 
    
          System.out.println(); 
      } 
      void addTolast(Node node){
    	  if(head == null){
    		  head = node;
    	  }else{
    		  Node temp = head;
    		  while(temp.next !=null){
    			  temp = temp.next;
    		  }
    		  temp.next = node;
    		  node.prev = temp;
    	  }
      }
      void printList(Node head){
    	  Node temp = head;
    	  while(temp!=null){
    		  System.out.println(temp.data+" ");
    		  temp = temp.next;
    	  }
    	  System.out.println();
      }
      public void push(int new_data){
    	  Node new_node = new Node(new_data);
    	  new_node.next = head;
    	  new_node.prev = null;
    	  
    	  if(head !=null){
    		  head.prev = new_node;
    	  }
    	  head = new_node;
      }
      public void insertAfter(Node prev_node, int new_data){
    	  if(prev_node== null){
    		  System.out.println("The given previous node cannot be NULL "); 
    	        return; 
    	  }
    	  /* 2. allocate node  
    	    * 3. put in the data */
    	    Node new_node = new Node(new_data); 
    	  
    	    new_node.next = prev_node.next;
    	    
    	    prev_node.next = new_node; 
    	    
    	    new_node.prev = prev_node;
    	    if (new_node.next != null) 
    	        new_node.next.prev = new_node; 
      }
   // Add a node at the end of the list 
      public void append(int new_data){
    	  /* 1. allocate node  
    	     * 2. put in the data */
    	    Node new_node = new Node(new_data); 
    	    
    	    Node last = head;
    	     new_node.next = null;
    	     
    	     if (head == null) { 
    	         new_node.prev = null; 
    	         head = new_node; 
    	         return; 
    	     } 
    	     
    	     while (last.next != null) 
    	         last = last.next; 
    	     
    	     last.next = new_node; 
    	     new_node.prev = last; 
      }
   // Function to delete a node in a Doubly Linked List. 
      // head_ref --> pointer to head node pointer. 
      // del --> data of node to be deleted. 
      void deleteNode(Node head_ref, Node del) 
      { 
    
          // Base case 
          if (head == null || del == null) { 
              return; 
          } 
    
          // If node to be deleted is head node 
          if (head == del) { 
              head = del.next; 
          } 
    
          // Change next only if node to be deleted 
          // is NOT the last node 
          if (del.next != null) { 
              del.next.prev = del.prev; 
          } 
    
          // Change prev only if node to be deleted 
          // is NOT the first node 
          if (del.prev != null) { 
              del.prev.next = del.next; 
          } 
    
          // Finally, free the memory occupied by del 
          return; 
      } 
      public static void quickSort(Node l,Node h){
    	  //Node last = head;
    	  
    	  if(h!=null && l!=h && l!=h.next){
    	  Node i = partition(l,h);
    	  quickSort(l,i.prev);
    	  quickSort(i.next,h);
    	  }
      }
      public static Node partition(Node l, Node h){
    	  Node i =null, temp = l;
    	  int x = h.data;
    	  while(temp!=h){
    		  if(temp.data<=x){
    			  i = i==null?l:i.next;
    			  int t = i.data;
    			  i.data = temp.data;
    			  temp.data = t;
    		  }
    		  temp = temp.next;
    	  }
    	  i = i==null?l:i.next;
    	  int t = i.data;
    	  i.data = h.data;
    	  h.data = t;
    	  return i;
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 DLL dll = new DLL(); 
		  
	        // Insert 2. So linked list becomes 2->NULL 
	        dll.push(2); 
	  
	        // Insert 4. So linked list becomes 4->2->NULL 
	        dll.push(4); 
	  
	        // Insert 8. So linked list becomes 8->4->2->NULL 
	        dll.push(8); 
	  
	        // Insert 10. So linked list becomes 10->8->4->2->NULL 
	        dll.push(10); 
	        dll.push(18);
	        dll.push(14);
	        dll.push(7);
	        dll.push(15);
	        System.out.print("Created DLL is: "); 
	        dll.printlist(dll.head); 
	  
	        // Deleting first node 
	        //dll.deleteNode(dll.head, dll.head); 
	  
	        // List after deleting first node 
	        // 8->4->2 
	        //System.out.print("\nList after deleting first node: "); 
	        //dll.printlist(dll.head); 
	        Node last = dll.head;
	       while(last.next!=null){
	    	   last = last.next;
	       }
	       quickSort(dll.head,last);
	       System.out.println("after sorting ");
	       dll.printlist(dll.head);
	        
	}

}

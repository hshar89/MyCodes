package DataStructures;

public class CircularLinkedList {
   Node node;
   Node head1;
   Node head2;
   static Node addToEmpty(Node last,int data){
	   if(last!=null){
		   return last;
	   }
	   Node temp = new Node(data);
	   last = temp;
	   last.next = last;
	   return last;
   }
   static Node addBegin(Node last, int data) {
	   if(last == null){
		   return addToEmpty(last,data);
	   }
	   Node temp = new Node(data);
	   temp.next = last.next;
	   last.next = temp;
	   
	   return last;
   }
   static Node addEnd(Node last, int data){
	   if (last == null) 
	        return addToEmpty(last, data); 
	   Node temp = new Node(data);
	   temp.next = last.next;
	   last.next = temp;
	   last = temp;
	   return last;
	   
   }
   static Node addAfter(Node last, int data, int item) {
	   if (last == null) 
	        return null;
	   Node temp,p;
	   p = last.next;
	   do{
		   if(p.data == item){
			   temp = new Node(data);
			   temp.next = p.next;
			   p.next = temp;
			   if(p==last){
				   last = temp;
				   return last;
			   }
		   }
		   p = p.next;
	   }while(p!=last.next);
	   System.out.println(item + " not present in the list."); 
	   return last;
		   
   }
   static void traverse(Node last) 
   { 
       Node p; 
     
       // If list is empty, return. 
       if (last == null) 
       { 
           System.out.println("List is empty."); 
           return; 
       } 
     
       // Pointing to first Node of the list. 
       p = last.next; 
     
       // Traversing the list. 
       do
       { 
           System.out.print(p.data + " "); 
           p = p.next; 
     
       } 
       while(p != last.next); 
     
   } 
   void sliptCL(CircularLinkedList list){
	   Node head = list.node;
	   Node slow_ptr = head; 
       Node fast_ptr = head; 
 
       if (head == null) { 
           return; 
       } 
       /* If there are odd nodes in the circular list then 
       fast_ptr->next becomes head and for even nodes  
       fast_ptr->next->next becomes head */
      while (fast_ptr.next != head 
              && fast_ptr.next.next != head) { 
          fast_ptr = fast_ptr.next.next; 
          slow_ptr = slow_ptr.next; 
      } 

      /* If there are even elements in list then move fast_ptr */
      if (fast_ptr.next.next == head) { 
          fast_ptr = fast_ptr.next; 
      } 

      /* Set the head pointer of first half */
      head1 = head; 

      /* Set the head pointer of second half */
      if (head.next != head) { 
          head2 = slow_ptr.next; 
      } 
      /* Make second half circular */
      fast_ptr.next = slow_ptr.next; 

      /* Make first half circular */
      slow_ptr.next = head; 
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node last = null; 
		  
		    last = addToEmpty(last, 6); 
		    last = addBegin(last, 4); 
		    last = addBegin(last, 2); 
		    last = addEnd(last, 8); 
		    last = addEnd(last, 12); 
		    last = addAfter(last, 10, 8); 	
		    last = addEnd(last,13);
		    traverse(last); 
		    
	}

}

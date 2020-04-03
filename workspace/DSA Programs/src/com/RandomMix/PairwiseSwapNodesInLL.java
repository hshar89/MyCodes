package PractiseJavaPrograms;

public class PairwiseSwapNodesInLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Node head = new Node(1);
         insertNodeAtEnd(head,2);
         insertNodeAtEnd(head,3);
         insertNodeAtEnd(head,4);
         insertNodeAtEnd(head,5);
         insertNodeAtEnd(head,6);
         insertNodeAtEnd(head,7);
         System.out.println("Linked List before calling pairWiseSwap() "); 
         printList(head);
         Node st = pairWiseSwap(head);  
         System.out.println("Linked list after calling pairwiseSwap() "); 
         printList(st); 
         Node head1 = new Node(1);
         insertNodeAtEnd(head1,4);
         insertNodeAtEnd(head1,7);
         Node head2 = new Node(2);
         insertNodeAtEnd(head2,6);
         Node[] a = new Node[2];
         a[0] = head1;
         a[1] = head2;
         System.out.println("Linked list after calling mereSort "); 
         Node new_head = mergeKList(a,2);        
         printList(new_head); 
	}
	/*
	 * This is an in house merge sort for k arrays
	 * More effective method can be found in 
	 * MergeKSortedLL class in this package
	 */
	 static Node mergeKList(Node[]a,int n)
	    {
	     //Add your code here.
	     Node node = new Node(0);
	     Node head = node;
	     for(int i=0;i<n-1;i++){
	         node.next = mergeLL(a[i],a[i+1]);
	          a[i+1] = node.next;
	     }
	     return head.next;
	    }
	    static Node mergeLL(Node head1, Node head2){
	        Node node = new Node(0);
	        Node head = node;
	        while(head1!=null && head2!=null){
	            if(head1.data >head2.data){
	                node.next = head2;
	                head2 = head2.next;
	                node = node.next;
	            }else{
	            node.next  = head1;
	            head1 = head1.next;
	            node = node.next;
	            }
	        }
	        while(head1!=null){
	            node.next = head1;
	            head1= head1.next;
	            node = node.next;
	        }
	        while(head2!=null){
	            node.next = head2;
	            head2 = head2.next;
	            node = node.next;
	        }
	        return head.next;
	    }
	/* Function to pairwise swap elements of a linked list */
    static Node pairWiseSwap(Node node) 
    { 
  
        // If linked list is empty or there is only one node in list 
        if (node == null || node.next == null) { 
            return node; 
        } 
  
        // Initialize previous and current pointers 
        Node prev = node; 
        Node curr = node.next; 
  
        node = curr; // Change head before proceeeding 
  
        // Traverse the list 
        while (true) { 
            Node next = curr.next; 
            curr.next = prev; // Change next of current as previous node 
  
            // If next NULL or next is the last node 
            if (next == null || next.next == null) { 
                prev.next = next; 
                break; 
            } 
  
            // Change next of previous to next next 
            prev.next = next.next; 
  
            // Update previous and curr 
            prev = next; 
            curr = prev.next; 
        } 
        return node; 
    } 
	static void printList(Node head) 
    { 
        Node temp = head; 
        while (temp != null) { 
            System.out.print(temp.data + " "); 
            temp = temp.next; 
        } 
        System.out.println(); 
    } 
   static void insertNodeAtEnd(Node head,int a){
	   Node temp = head;
	   while(temp.next!=null){
		   temp = temp.next;
	   }
	   temp.next = new Node(a);
   }
}

package PractiseJavaPrograms;

import java.util.Stack;

class Node 
{ 
    int data; 
    Node next; 
    Node(int d) {data = d; next = null; } 
} 
public class LinkedListOE {
	Node head;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListOE list = new LinkedListOE();
		list.push(11);
		list.push(89);
		list.push(12);
		list.push(67);
		//list.push(9);
		list.push(30);
		//list.push(15);
		list.push(53);
		list.push(40);
		list.push(10);
		Node temp = list.head;
		System.out.println("before doing work ");
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		/*Node temp = list.head;
		int len = 1;
		while(temp.next!=null){
			temp =temp.next;
			len++;
		}
		double t =  Math.ceil((84/61));
		System.out.println(" len "+t);
		sortEvenOddStack(list);
		System.out.println("After sorting ");
		Node new_head = sort(list.head);
		System.out.println("\n After listing ");
		while(new_head!=null){
			System.out.print(new_head.data+" ");
			new_head = new_head.next;
		}
		//list.printList();*/
		LinkedListOE list2 = new LinkedListOE();
		list2.push(12);
		list2.push(13);
		list2.printList();
		Node slow = list2.head;
		Node fast = slow;
		while(fast!=null){
			fast = fast.next;
			if(fast!=null){
				slow = slow.next;
				fast = fast.next;
			}
		}
		String abc = "why";
		System.out.println(abc.length());
		//System.out.println("fast "+fast.data);
		System.out.println("slow "+slow.data);
		
	}
	static void sortEvenOddStack(LinkedListOE llist){
		Node h = llist.head,prev = null;
		if(h.next == null)return;
		int countEven = 1,count =1;
		while(h.next!=null){
			if(h.data%2==0){
				countEven++;
			}
			h = h.next;
			count++;
		}
		System.out.println(" count "+count+" countEven "+countEven );
		if(count == countEven) return;
		h = llist.head;
		Stack<Node> mystack = new Stack<Node> ();  
		while(h.next!= null){				
	     if(h.data%2 == 0){
	    	 if(prev!=null){
				prev.next = h.next;
				mystack.push(h);
				h = h.next;
				countEven++; 
	    	 }else{
	    		 mystack.push(h);
					llist.head = h.next;
					h = h.next; 
	    	 }
	     } else{
				prev = h;
				h = h.next;
			}
		}
		if(h.data%2==0){
			mystack.push(h);
			prev.next =null;
		}
		Node curr = null,temp = null;
		 while (mystack.size() > 0)  
	        {  
			  curr = mystack.pop();
			  temp = llist.head;
			  curr.next = temp;
			  llist.head = curr;
	        }
	}
	public static Node sort(Node head){
        //your code here, return the head of the sorted list
        if(head == null || head.next == null){
            return head;
        }
        Node temp = head,hare = head.next,prev = null,next =null;
        Stack<Node> mys = new Stack<Node>();
        while(hare!=null){
           mys.push(hare);
           next = hare.next;
           temp.next = next;
           hare.next = null;
           temp = next;
           if(next!=null){
           hare = next.next;
           }else{
        	   hare = null;
           }
        }
        int size = mys.size();
        System.out.println("size "+size);
        Node head2 = new Node(mys.pop().data);
        Node x=head2;
        while(--size>0){
        	x.next = mys.pop();
        	x = x.next;
        }
        x = head2;
        System.out.println("list 2 ");
        while(x!=null){
            System.out.print(x.data+" ");
            x = x.next;
            }
        Node new_head = mergeSort(head,head2);
        System.out.println("\n after merging ");
        while(new_head!=null){
        	System.out.print(new_head.data+" ");
        	new_head = new_head.next;
        }
        return null;
   }
   static Node mergeSort(Node head1, Node head2){
	   Node new_head = null;
	   Node temp1 = head1, temp2 = head2,temp=null,prev=null;
	   if(head1.data > head2.data){
		   new_head = head2;
	   }else{
		   new_head = head1;
	   } 
	   //int a = Math.pow(a, b);
	   while(temp1!=null && temp2!= null){
		   if(temp1.data <= temp2.data){
			   prev = temp1;
			   temp1 = temp1.next;
		   }else{
			   temp = temp2.next;
			   if(prev!=null){
				   prev.next = temp2;
			   }
			   prev = temp2;
			   temp2.next = temp1;			   
			   temp2 = temp;
		   }
	   }
	   //Node nTemp = temp1!=null?temp1:temp2;
	   if(temp2 != null){
	       prev.next = temp2;
	       temp2.next= null;
	   }
	   System.out.println("\n new head "+new_head.data);
	   return new_head;
   }
	static void sortEvenOdd(LinkedListOE llist){

	     Node h = llist.head,temp = null,prev=null;
	     System.out.println("entered "+h.data);
	     int evenCount =0,count=1;
	     while(h.next!=null){
	    	 System.out.println("h "+h.data);
	         if(h.data%2 == 0 && prev!=null){     	 
	             prev.next = h.next;
	             temp = llist.head;
	             llist.head = h;
	             h = h.next;
	             llist.head.next = temp;
	             evenCount++;
	         }else{
	         prev = h;
	         h = h.next;
	         }
	     }
	     System.out.println("done with evens "+llist.head.next.data+" prev "+prev.data+" h "+h.data);
	     prev=null;
	     Node curr = llist.head,next=null;
	     while(h!=null && count<=evenCount){
	         next = curr.next;
	         curr.next = prev;
	         prev = curr;
	         curr = next;
	     }
	     llist.head = prev;
	 }
	 void printList(){
	     Node temp =head;
	     while(temp != null){
	         System.out.print(temp.data+" ");
	         temp = temp.next;
	     }
	     System.out.println();
	 }

}

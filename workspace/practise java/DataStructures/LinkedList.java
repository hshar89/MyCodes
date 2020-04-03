package DataStructures;

//A complete working Java program to demonstrate all insertion methods 
//on linked list 
class LinkedList 
{ 
 Node head;  // head of list 

 /* Linked list Node*/
 static class Node 
 { 
     int data; 
     Node next; 
     Node arb;
     Node(int d) {data = d; next = null; } 
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
 /* Returns count of nodes in linked list */
 public int getCount() 
 { 
     Node temp = head; 
     int count = 0; 
     while (temp != null) 
     { 
         count++; 
         temp = temp.next; 
     } 
     return count; 
 } 
public void deleteNode(int key){
	Node temp = head, prev=null;
	if(temp != null & temp.data == key){
		head = temp.next;
		return;
	}
	
	while(temp != null && temp.data != key){
		prev =temp;
		temp = temp.next;
	}
	if(temp ==null){
		return;
	}
	prev.next = temp.next;
}
/* Returns count of nodes in linked list */
public int getCountRec(Node node) 
{ 
    // Base case 
    if (node == null) 
        return 0; 

    // Count is this node plus rest of the list 
    return 1 + getCountRec(node.next); 
} 

/* Wrapper over getCountRec() */
public int getCountRecursion() 
{ 
    return getCountRec(head); 
} 
public void deleteNodeAtPosition(int position){
	if(head == null){
		return;
	}
	Node temp = head;
	if(position == 0){
		head = temp.next;
		return;
	}
	for(int i=0;temp!=null && i<position-1;i++){
		temp = temp.next;
	}
	if(temp ==null || temp.next == null){
		return;
	}
	Node next = temp.next.next;
	temp.next = next;
}
 /* Inserts a new node after the given prev_node. */
 public void insertAfter(Node prev_node, int new_data) 
 { 
     /* 1. Check if the given Node is null */
     if (prev_node == null) 
     { 
         System.out.println("The given previous node cannot be null"); 
         return; 
     } 

     /* 2 & 3: Allocate the Node & 
               Put in the data*/
     Node new_node = new Node(new_data); 

     /* 4. Make next of new Node as next of prev_node */
     new_node.next = prev_node.next; 

     /* 5. make next of prev_node as new_node */
     prev_node.next = new_node; 
 } 
  
 /* Appends a new node at the end.  This method is  
    defined inside LinkedList class shown above */
 public void append(int new_data) 
 { 
     /* 1. Allocate the Node & 
        2. Put in the data 
        3. Set next as null */
     Node new_node = new Node(new_data); 

     /* 4. If the Linked List is empty, then make the 
           new node as head */
     if (head == null) 
     { 
         head = new Node(new_data); 
         return; 
     } 

     /* 4. This new node is going to be the last node, so 
           make next of it as null */
     new_node.next = null; 

     /* 5. Else traverse till the last node */
     Node last = head;  
     while (last.next != null) 
         last = last.next; 

     /* 6. Change the next of last node */
     last.next = new_node; 
     return; 
 } 

 /* This function prints contents of linked list starting from 
     the given node */
 public void printList() 
 { 
     Node tnode = head; 
     while (tnode != null) 
     { 
         System.out.print(tnode.data+" "); 
         tnode = tnode.next; 
     } 
 } 
 /* Function to swap Nodes x and y in linked list by 
 changing links */
public void swapNodes(int x, int y) 
{ 
	if(x==y) return;
	
	Node prevx = null, currx = head;
	while(currx != null && currx.data != x){
		prevx = currx;
		currx = currx.next;
	}
	Node prevy = null, curry = head;
	while(curry != null && curry.data != y){
		prevy = curry;
		curry = curry.next;
	}
	if(currx == null || curry == null){
		return;
	}
	if(prevx != null){
		prevx.next = curry;
	}else{
		head = curry;
	}
	if(prevy != null){
		prevy.next = currx;
	}else{
		head = currx;
	}
	Node temp = currx.next;
	currx.next = curry.next;
	curry.next = temp;
}
static Node swapNodesV2(Node head_ref, int x, int y)  
{  
	Node head = head_ref;
	if(x==y){
		return null;
	}
	Node a=null, b=null;
	System.out.println("Entering while loop ");
	while(head_ref.next != null){
		if(head_ref.next.data == x){ 
			a = head_ref;
		}
		else if(head_ref.next.data == y){
			b = head_ref;
		}
		head_ref = ((head_ref).next); 
	}
	if(a!= null && b!= null){
		Node temp = a.next;
		a.next = b.next;
		b.next = temp;
		temp = a.next.next;
		a.next.next = b.next.next;
		b.next.next = temp;
	}
	return head;
}
/*Program to sort a singly linked list using QuickSort*/
public static Node quickSort(Node head){
	Node node  = quickSortStart(head,getTail(head));
	return node;
}
static Node getTail(Node h){
	Node last = h;
	while(last.next!=null){
		last = last.next;
	}
	return last;
}
static class Res{
	Node new_head = null, end_node = null;
}
static Node quickSortStart(Node l, Node h){
	if(h == null || l ==h){
		return h;
	}
	Res r = new Res();
	Res s = new Res();
	Node pivot  = partition(l,h,r,s);
	if(r.new_head != pivot){
		Node temp = r.new_head;
		while(temp.next!=pivot){
			temp = temp.next;
		}
		temp.next = null;
		r.new_head = quickSortStart(r.new_head,temp);
		temp = getTail(r.new_head);
		temp.next = pivot;
	}
	pivot.next = quickSortStart(pivot.next,s.end_node);
	return r.new_head;
}
static Node partition(Node head, Node last, Res r, Res s){
	Node curr = head,pivot = last,prev = null,tail = pivot;
	while(curr!=last){
		if(curr.data < pivot.data){
			if(r.new_head == null){
				r.new_head = curr;
			}
			prev = curr;
			curr = curr.next;
		}else{
			if(prev!= null){
				prev.next = curr.next;
			}
			Node tmp = curr.next;
			curr.next = null;
			tail.next = curr;
			tail = curr;
			curr = tmp;
		}
	}
	if(r.new_head == null){
		r.new_head = pivot;
	}
	s.end_node = tail;
	return pivot;
}
/*
 * This method is to copy linked list to another 
 * the original ll has random pointers
 */
static Node copyList(Node head) {
    // your code here
    Node curr = head, temp =null;
    while(curr!=null){
        temp = curr.next;
        curr.next = new Node(curr.data);
        curr.next.next = temp;
        curr = temp;
    }
    curr = head;
    while(curr!=null){
        if(curr.next!=null){
            curr.next.arb = curr.arb!=null?curr.arb.next:curr.arb;
        }
        curr = curr.next!=null?curr.next.next:curr.next;
    }
    Node original = head,copy = head.next;
    temp = copy;
    while(original!=null && copy!=null){
        original.next = original.next!=null?original.next.next:original.next;
        copy.next = copy.next!=null?copy.next.next:copy.next;
        original = original.next;
        copy= copy.next;
    }
    return temp;
}
 /* Driver program to test above functions. Ideally this function 
    should be in a separate user class.  It is kept here to keep 
    code compact */
 public static void main(String[] args) 
 { 
     /* Start with the empty list */
     LinkedList llist = new LinkedList(); 

     // Insert 6.  So linked list becomes 6->NUllist 
     llist.append(6); 

     // Insert 7 at the beginning. So linked list becomes 
     // 7->6->NUllist 
     llist.push(7); 

     // Insert 1 at the beginning. So linked list becomes 
     // 1->7->6->NUllist 
     llist.push(1); 
     llist.push(5); 
     llist.push(3); 
     llist.push(2); 

     // Insert 4 at the end. So linked list becomes 
     // 1->7->6->4->NUllist 
     llist.append(4); 

     // Insert 8, after 7. So linked list becomes 
     // 1->7->8->6->4->NUllist 
     llist.insertAfter(llist.head.next, 8); 

     System.out.println("\nCreated Linked list is: "); 
     llist.printList(); 
     
     llist.deleteNode(8); // Delete for key 8
     llist.deleteNodeAtPosition(2); //Delete at position 2
     System.out.println("\nLinked List after Deletion at position 4:"); 
     llist.printList(); 
     System.out.println("size "+llist.getCount());
     llist.swapNodes(4, 3);
     System.out.print("\n Linked list after calling swapNodes() "); 
     llist.printList();
     System.out.println("trying version 2");
     llist.head=swapNodesV2(llist.head, 6, 3);  
     
     System.out.print("Linked list after calling swapNodes() v2 ");  
     llist.printList();  
 } 

}

package PractiseJavaPrograms;

public class Segregate012LL {
    Node head;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Segregate012LL ll = new Segregate012LL();
		ll.head = new Node(1);
		insertNodeAtEnd(ll.head,2);
		insertNodeAtEnd(ll.head,2);
		insertNodeAtEnd(ll.head,1);
		insertNodeAtEnd(ll.head,2);
		insertNodeAtEnd(ll.head,0);
		insertNodeAtEnd(ll.head,2);
		insertNodeAtEnd(ll.head,2);
		Segregate012LL ll2 = new Segregate012LL();
		ll2.head = new Node(2);
		insertNodeAtEnd(ll2.head,2);
		insertNodeAtEnd(ll2.head,0);
		insertNodeAtEnd(ll2.head,1);
		//printList(segregate(ll2.head));
		segregate(ll2.head);
	}
	static Node segregate(Node head)
    {
        // add your code here
        Node mid = null, start =null, end = null;
        Node new_head = null,connector1 = null, connector2 = null;
        System.out.println("entered while loop ");
        while(head!=null){
            switch(head.data){
                case 0:
                     if(new_head==null){
                         new_head = head;
                         start = new_head;
                     }else{
                    start.next = head;
                    start = start.next;
                     }
                    break;
                case 1:
                     if(connector1==null){
                         connector1 = head;
                         mid = connector1;
                     }else{
                    mid.next = head;
                    mid = mid.next;
                     }
                    break;
                case 2:
                if(connector2==null){
                         connector2 = head;
                         end = connector2;
                     }else{
                    end.next = head;
                    end = end.next;
                     }
                    break;
            }
            head = head.next;
        }
        System.out.println("came out while loop ");
        System.out.println("new_head "+new_head.data);
        System.out.println("connector 1 "+connector1.data);
        System.out.println("connector 2 "+connector2.data);
        System.out.println("mid "+mid.data);
        System.out.println("start "+start.data);
        if(new_head == null){
            new_head = connector1;
            if(new_head == null){
                new_head = connector2;
            }else{
             if(connector2!=null){
                mid.next = connector2;
            }
          }
        }else{
            if(connector1 == null){
                start.next = connector2;
            }else{
                start.next = connector1;
                mid.next = connector2;
            }
        }
        System.out.println("new head "+new_head.next.next.next.next.data);
       return new_head;
    }
	static void insertNodeAtEnd(Node head,int a){
		   Node temp = head;
		   while(temp.next!=null){
			   temp = temp.next;
		   }
		   temp.next = new Node(a);
	   }
	public static void printList(Node node)  
    {  
        while (node != null)  
        {  
            System.out.print(node.data+" "); 
            node = node.next;  
        }  
    }  
}

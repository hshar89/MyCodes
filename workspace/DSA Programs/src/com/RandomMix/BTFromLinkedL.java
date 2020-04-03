package PractiseJavaPrograms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import DataStructures.Node;
class Tree{
	int data;
	    Tree left;
	    Tree right;
	    Tree(int d){
	        data=d;
	        left=null;
	        right=null;
	    }
	}
public class BTFromLinkedL {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Node head = new Node(10);
      head.next = new Node(12);
      head.next.next = new Node(15);
      head.next.next.next = new Node(25);
      head.next.next.next.next = new Node(30);
      head.next.next.next.next.next = new Node(36);
      Tree root = convert(head,null);
      printTree(root);
	}
	static void printTree(Tree root){
		Queue<Tree> q = new LinkedList<Tree>();
		q.add(root);
		while(!q.isEmpty()){
			Tree temp = q.remove();
			System.out.print(temp.data+" ");
			if(temp.left != null){
				q.add(temp.left);
				
			}
			if(temp.right !=null){
				q.add(temp.right);
			}
		}
	}
public static Tree convert(Node head, Tree node) {
        
        if(head == null){
            return null;
        }
        HashMap<Integer,Tree> mp = new HashMap<Integer,Tree>();
        node = new Tree(head.data);
        mp.put(0,node);
        head = head.next;
        int j=1;
        while(head!=null){
            Tree parent = mp.get((j-1)/2);
            parent.left = new Tree(head.data);
            head = head.next;
            mp.put(j,parent.left);
            j++;
            if(head!=null){
             parent.right = new Tree(head.data);
             head = head.next;
             mp.put(j,parent.right);
             j++;
            }
          }
          return node;
        }

}

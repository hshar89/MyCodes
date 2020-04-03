package PractiseJavaPrograms;

public class BTToDLL {
	static BinaryNode head;
    static BinaryNode nexth;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       BinaryNode root = new BinaryNode(10);
       root.left = new BinaryNode(12);
       root.right = new BinaryNode(15);
       root.left.left = new BinaryNode(25);
       root.left.right = new BinaryNode(30);
       root.right.left= new BinaryNode(36);
       System.out.println("the binary Tree");
       printBinaryTree(root);
       System.out.println("converted DLL ");
       printDLL(bToDLL(root));
	}
	static void printBinaryTree(BinaryNode root){
		if(root == null){
			return;
		}
		printBinaryTree(root.left);
		System.out.print(root.data+" ");
		printBinaryTree(root.right);
	}
	static void printDLL(BinaryNode head){
		while(head!=null){
			System.out.print(head.data+" ");
			head = head.right;
		}
		System.out.println();
	}
	static BinaryNode bToDLL(BinaryNode root)
    {
	//  Your code here	
	  if(root == null){
	      return null;
	  }
	  BinaryNode lr = bToDLL(root.left);
	  if(head == null){
	      head = root;
	      head.left = null;
	      head.right = null;
	      nexth = head;
	  }else{
	      nexth.right = root;
	      root.left = nexth;
	      nexth = nexth.right;
	  }
	  BinaryNode rr = bToDLL(root.right);
	  if(rr == head){
	      return head;
	  }
	  return head;
    }

}

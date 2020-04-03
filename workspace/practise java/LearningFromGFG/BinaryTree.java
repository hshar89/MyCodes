package LearningFromGFG;

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

class BinaryNode{
	int data;
	BinaryNode right;
	BinaryNode left;
	BinaryNode(int x){
		data = x;
	}
}
public class BinaryTree {
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         BinaryNode root = new BinaryNode(10);
         root.left = new BinaryNode(5);
         root.right = new BinaryNode(3);
         root.left.right = new BinaryNode(12);
         root.left.left = new BinaryNode(14);
         root.right.left = new BinaryNode(15);
         root.right.right = new BinaryNode(9);
         root.left.right.right = new BinaryNode(18);
         root.right.right.left = new BinaryNode(21);
         root.right.right.left.left = new BinaryNode(22);
         System.out.println("this is inorder ");
         inorder(root);
         System.out.println();
         System.out.println("this is preorder");
         preorder(root);
         System.out.println();
         System.out.println("this is postorder");
         postorder(root);
         System.out.println();
         System.out.println("this is Level ORder Traversal");
         levelOrderTraversal(root);
         System.out.println();
         System.out.println("this is Level ORder Traversal in fancy way");
         levelOrderfancyTravel1(root);
         System.out.println();
         System.out.println("this is Level ORder Traversal in fancy way part 2");
         levelOrderfancyTravel2(root);
         System.out.println();
         System.out.println("this is Level ORder Traversal in fancy way part 3");
         levelOrderfancyTravel3(root);
         System.out.println();
         System.out.println("this is hieght of BT problem");
         System.out.println("hieght of tree "+hieghtOfBT(root));
         System.out.println();
         BinaryNode root2 = new BinaryNode(10);
         root2.left = new BinaryNode(4);
         root2.right = new BinaryNode(6);
         root2.left.left = new BinaryNode(1);
         root2.left.right = new BinaryNode(3);
         root2.right.left = new BinaryNode(2);
         root2.right.right = new BinaryNode(4);
         System.out.println("this is check for children sum problem");
         System.out.println("check for child sum "+checkForChildSumProp(root2));
         
         BinaryNode root3 = new BinaryNode(10);
         root3.left = new BinaryNode(7);
         root3.right = new BinaryNode(15);
         root3.left.right = new BinaryNode(9);
         root3.left.left = new BinaryNode(10);
         root3.right.left = new BinaryNode(12);
         root3.right.right = new BinaryNode(8);
         System.out.println("test preorder ");
         preorder(root3);
         System.out.println("\ntest postOrder ");
         postorder(root3);
         System.out.println("\ntest inorder ");
         inorder(root3);
	}
	static boolean checkForChildSumProp(BinaryNode node){
		if(node == null){
			return true;
		}
		if(node.left==null && node.right==null){
			return true;
		}
		int sum=0;
		if(node.left!=null){
			sum+=node.left.data;
		}
		if(node.right!=null){
			sum+=node.right.data;
		}
		if(sum == node.data && checkForChildSumProp(node.left) && checkForChildSumProp(node.right)){
			return true;
		}
	    return false;
	}
	static int hieghtOfBT(BinaryNode node){
		if(node==null){
			return 0;
		}
		int hr = hieghtOfBT(node.right);
		int hl = hieghtOfBT(node.left);
		return Math.max(hr, hl)+1;
	}
	static void levelOrderfancyTravel3(BinaryNode node){
		if(node == null){
			return;
		}
		Queue<BinaryNode> q = new LinkedList<>();
		q.add(node);	
		while(!q.isEmpty()){
			int size= q.size();
			while(size-->0){
			BinaryNode temp = q.remove();
			System.out.print(temp.data+" ");		
			if(temp.left!=null){
				q.add(temp.left);
			}
			if(temp.right!=null){
				q.add(temp.right);
			}
			}
			System.out.println();
		}
	}
	static void levelOrderfancyTravel2(BinaryNode node){
		if(node == null){
			return;
		}
		Queue<Pair<BinaryNode,Integer>> q = new LinkedList<>();
		Pair<BinaryNode,Integer> p = new Pair<BinaryNode,Integer>(node, 1);
		Pair<BinaryNode,Integer> prev = new Pair<>(null,0);
		q.add(p);	
		while(!q.isEmpty()){
			Pair<BinaryNode,Integer> temp = q.remove();
			if(prev.getKey() != null && prev.getValue()!=temp.getValue()){
				System.out.println();
			}
			System.out.print(temp.getKey().data+" ");				
			if(temp.getKey().left!=null){
				Pair<BinaryNode,Integer> left = new Pair<BinaryNode,Integer>(temp.getKey().left,temp.getValue()+1);
				q.add(left);
			}
			if(temp.getKey().right!=null){
				Pair<BinaryNode,Integer> right = new Pair<BinaryNode,Integer>(temp.getKey().right,temp.getValue()+1);
				q.add(right);
			}
			prev = new Pair<BinaryNode,Integer>(temp.getKey(),temp.getValue());
		}
	}
	static void levelOrderfancyTravel1(BinaryNode node){
		if(node == null){
			return;
		}
		Queue<BinaryNode> q = new LinkedList<>();
		q.add(node);	
		q.add(null);
		while(!q.isEmpty()){
			BinaryNode temp = q.remove();
			if(temp == null){
				if(!q.isEmpty()){
					q.add(null);
				}
				System.out.println();
			}else{
			System.out.print(temp.data+" ");		
			if(temp.left!=null){
				q.add(temp.left);
			}
			if(temp.right!=null){
				q.add(temp.right);
			}
			}
		}
	}
	static void levelOrderTraversal(BinaryNode node){
		if(node == null){
			return;
		}
		Queue<BinaryNode> q = new LinkedList<>();
		q.add(node);		
		while(!q.isEmpty()){
			BinaryNode temp = q.remove();
			System.out.print(temp.data+" ");
			
			if(temp.left!=null){
				q.add(temp.left);
			}
			if(temp.right!=null){
				q.add(temp.right);
			}
		}
	}
	static void inorder(BinaryNode node){
		if(node == null){
			return;
		}
		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);
	}
   static void preorder(BinaryNode node){
	   if(node == null){
		   return;
	   }
	   System.out.print(node.data+" ");
	   preorder(node.left);
	   preorder(node.right);
   }
   static void postorder(BinaryNode root){
	   if(root == null){
		   return;
	   }
	   postorder(root.left);
	   postorder(root.right);
	   System.out.print(root.data+" ");
   }
}

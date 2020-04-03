package PractiseJavaPrograms;

public class DeleteNodeINBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] arr = {2,81,87,42,66,90,45};
     BinaryNode root = new BinaryNode(arr[0]);
     for(int i=1;i<arr.length;i++){
    	 insert(root,arr[i]);
     }
     System.out.println("before deletion ");
     printInorder(root);
     deleteNode(root,81);
     System.out.println("\nafter deletion ");
     printInorder(root);
	}
	static BinaryNode deleteNode(BinaryNode root,int x){
		if(root == null){
			return root;
		}
		if(x<root.data){
			root.left = deleteNode(root.left,x);
		}else if(x>root.data){
			root.right = deleteNode(root.right,x);
		}else{
			if(root.left == null){
				return root.right;
			}else if(root.right == null){
				return root.left;
			}
			root.data = minValue(root.right);
			root.right = deleteNode(root.right,root.data);
		}
		return root;
	}
	static int minValue(BinaryNode root){
		int minv = root.data;
		while(root.left!=null){
			minv = root.left.data;
			root = root.left;
		}
		return minv;
	}
   static BinaryNode insert(BinaryNode root,int x){
	   if(root == null){
		   root = new BinaryNode(x);
		   return root;
	   }
	   if(x>root.data){	   
		   root.right = insert(root.right,x);
	   }else if(x<root.data){		  
		   root.left = insert(root.left,x);
		   }
	   return root;
   }
   static void printInorder(BinaryNode root){
	   if(root==null){
		   return;
	   }
	   printInorder(root.left);
	   System.out.print(root.data+" ");
	   printInorder(root.right);
   }
}

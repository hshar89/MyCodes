package PractiseJavaPrograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
class TreeNode{
	int data;
	int count;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x){
		this.data = x;
		count = 1;
	}
}
public class CountSmallerAferSelf {
    static int maxCount = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      BinaryNode root = new BinaryNode(1);
      root.left = new BinaryNode(0);
      root.right = new BinaryNode(2);
      root.left.left = new BinaryNode(4);
      root.left.right = new BinaryNode(6);
      root.right.left = new BinaryNode(8);
      root.right.right = new BinaryNode(10);
      root.left.left.left = new BinaryNode(14);
      root.right.left.left = new BinaryNode(19);
      root.right.left.left.right = new BinaryNode(21);
      inorderWithoutRecursion(root);
      System.out.println("\n this is for smaller element on right to self ");
      int[] arr = {10, 6, 9, 7, 50 ,14, 17, 19, 34, 51, 23, 14, 12,26,27,28,6, 7, 8 ,9};
      List<Integer> l = countSmaller(arr);
      Iterator<Integer> it = l.iterator();
      while(it.hasNext()){
    	  System.out.print(it.next()+" ");
      }
      System.out.println("this is max count "+maxCount);
	}
  static int insertNode(TreeNode root, int x){
	  int thiscount = 0;
	  while(true){
		  if(x<=root.data){
			  root.count++;
			  if(root.left == null){
				  root.left = new TreeNode(x);
				  break;
			  }else{
				  root = root.left;
			  }
		  }else{
			  thiscount +=root.count;
			  if(root.right==null){
				  root.right = new TreeNode(x);
				  break;
			  }else{
				  root = root.right;
			  }
		  }
	  }
	  if(thiscount>maxCount){
		  maxCount = thiscount;
	  }
	  return thiscount;
  }
  public static List<Integer> countSmaller(int[] arr){
	  List<Integer> cs = new ArrayList<>();
	  cs.add(0);
	  TreeNode root = new TreeNode(arr[arr.length-1]);
	  for(int i=arr.length-2;i>=0;i--){
		  int count  = insertNode(root,arr[i]);
		  cs.add(count);
	  }
	  Collections.reverse(cs);	  
	  //System.out.println("\n this is tree formed ");
	  //inorderWithoutRecursion(root);
	  //System.out.println();
	  return cs;
  }
  static void inorderWithoutRecursion(BinaryNode root){
	  if(root == null){
		  return;
	  }
	  Stack<BinaryNode> st = new Stack<>();
	  BinaryNode curr = root;
	  while(curr!=null || st.size()>0){
		  while(curr!=null){
			  st.push(curr);
			  curr = curr.left;
		  }
		  curr = st.pop();
		  System.out.print(curr.data+" ");
		  curr = curr.right;
	  }
  }
}

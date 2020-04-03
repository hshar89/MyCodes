package PractiseJavaPrograms;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import javafx.util.Pair;

public class BottomViewBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = new BinaryNode(20); 
        root.left = new BinaryNode(8); 
        root.right = new BinaryNode(22); 
        root.left.left = new BinaryNode(5); 
        root.left.right = new BinaryNode(3); 
        root.right.left = new BinaryNode(4); 
        root.right.right = new BinaryNode(25); 
        root.left.right.left = new BinaryNode(10); 
        root.left.right.right = new BinaryNode(14); 
        BottomViewBT tree = new BottomViewBT(); 
        System.out.println("Bottom view of the given binary tree:"); 
        tree.bottomView(root); 
	}
    void bottomView(BinaryNode root){
	   Map<Integer,Integer> mp = new TreeMap<>();
	   Queue<Pair<Integer,BinaryNode>> q = new LinkedList<>();
	   Pair<Integer,BinaryNode> p = new Pair<>(0,root);
	   q.add(p);
	   while(!q.isEmpty()){
		   Pair<Integer,BinaryNode> temp = q.remove();
		   mp.put(temp.getKey(), temp.getValue().data);
		   if(temp.getValue().left!=null){
			   Pair<Integer,BinaryNode> left = new Pair<>(temp.getKey()-1,temp.getValue().left);
			   q.add(left);
		   }
		   if(temp.getValue().right!=null){
			   Pair<Integer,BinaryNode> right = new Pair<>(temp.getKey()+1,temp.getValue().right);
			   q.add(right);
		   }
	   }
	   mp.forEach((n,m) -> System.out.print(m+" "));
   }
}

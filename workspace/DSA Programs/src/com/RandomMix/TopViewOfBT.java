package PractiseJavaPrograms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


import javafx.util.Pair;

public class TopViewOfBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     BinaryNode root= new BinaryNode(10);
     root.left = new BinaryNode(20);
     root.right = new BinaryNode(30);
     root.left.left = new BinaryNode(40);
     root.left.right = new BinaryNode(60);
     root.right.left = new BinaryNode(90);
     printTopView(root);
     String a = "trphogi";
     System.out.println(a.substring(0, 3));
	}
	public static void printTopView(BinaryNode root){
		Queue<Pair<Integer,BinaryNode>> q = new LinkedList<>();
		Pair<Integer, BinaryNode> p = new Pair<Integer,BinaryNode>(0,root);
		HashSet<Integer> set = new HashSet<>();
		q.add(p);
		while(!q.isEmpty()){
			Pair<Integer,BinaryNode> temp = q.remove();
			if(!set.contains(temp.getKey())){
				System.out.print(temp.getValue().data+" ");
				set.add(temp.getKey());
			}
			if(temp.getValue().left!=null){
				Pair<Integer,BinaryNode> left = new Pair<>(temp.getKey()-1,temp.getValue().left);
				q.add(left);
			}
			if(temp.getValue().right!=null){
				Pair<Integer,BinaryNode> right = new Pair<>(temp.getKey()+1,temp.getValue().right);
				q.add(right);
			}
		}
	}
}

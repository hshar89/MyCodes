package PractiseJavaPrograms;
class height{
   	int h;
   	public height(){
   		h=0;
   	}
   }
public class CheckIsBalancedHeightBT {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       BinaryNode root = new BinaryNode(10);
       root.left = new BinaryNode(20);
       root.right = new BinaryNode(30);
       root.left.left = new BinaryNode(40);
       root.left.right = new BinaryNode(60);
       height h1 = new height();
       System.out.println("is balanced "+checkIsBalanced(root,h1));
	}
   static boolean checkIsBalanced(BinaryNode node, height h1){
	   if(node == null){
		   return false;
	   }
	   height hl = new height();
	   height hr = new height();
	   boolean bl = checkIsBalanced(node.left,hl);
	   boolean br = checkIsBalanced(node.right,hr);
	   if(Math.abs(hl.h-hr.h)>1){
		   return false;
	   }
	   h1.h = Math.max(hl.h, hr.h)+1;
	   return bl&&br;
   }
   
}

package PractiseJavaPrograms;

public class CalculateDiaofBT {
	 class height{
	        int h;
	        height(){
	            h=0;
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     BinaryNode root = new BinaryNode(10);
     root.left = new BinaryNode(20);
     root.right = new BinaryNode(30);
     root.left.left = new BinaryNode(40);
     root.left.right = new BinaryNode(60);
     CalculateDiaofBT ct = new CalculateDiaofBT();
     System.out.println("dia of BT "+ct.diameter(root));
	}
	
	    int diameter(BinaryNode node)
	    {
	        // Your code here
	        //Integer h = new Integer(-1);
	        height ht = new height();
	        getdia(node,ht);
	        return ht.h;
	    }
	    int getdia(BinaryNode node,height ht){
	        if(node == null){
	            return 0;
	        }
	        int hl = getdia(node.left,ht);
	        int hr = getdia(node.right,ht);
	        ht.h = Math.max(ht.h,hl+hr+1);
	        return Math.max(hl,hr)+1;
	    }
}

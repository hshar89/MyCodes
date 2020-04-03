package PractiseJavaPrograms;

public class BuyAndSell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    StringBuffer sb = new StringBuffer();
    String ab = "";
    
	}
	 static void stockBuySell(int price[], int n) {
	        
	        // Your code here
	        int[] buy = new int[n];
	        int[] sell = new int[n];
	        int j=0,k= 0;
	        boolean sellIndex = false,buyIndex = true;
	        for(int i=0;i<n-1;i++){
	            if(price[i+1]>price[i] && buyIndex){
	                buy[j] = price[i];
	                j++;
	                sellIndex = true;
	                buyIndex = false;
	            }else if(price[i+1]<price[i] && sellIndex){
	                sell[k] = price[i];
	                k++;
	                sellIndex = false;
	                buyIndex = true;
	            }else if(sellIndex && i+1 == n-1){
	                sell[k] = price[i+1];
	            }
	        }
	        for(int i=0;i<n;i++){
	            if(buy[i] != 0 && sell[i]!=0){
	            System.out.print("("+buy[i]+" "+sell[i]+")"+" ");
	            }
	        }
	        
	    } 
	    

}

package PractiseJavaPrograms;

public class CapitalizeFirstLetter {
    static String capitalizeEveryLetter(String str){
    	str = Character.toUpperCase(str.charAt(0))+ str.substring(1);
    	return str;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String sb = "this is javapoint";
     String cap = "";
     String[] sbL = sb.split(" ");
     for(int i=0;i<sbL.length;i++){
    	 cap += " "+capitalizeEveryLetter(sbL[i]); 
     }
     System.out.println(cap.trim());
	}

}

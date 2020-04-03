package CollectionsInJava;
import java.util.*; 
import java.util.AbstractCollection;
public class FrequencyMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Let us create a list of strings 
        List<String>  mylist = new ArrayList<String>(); 
        mylist.add("practice"); 
        mylist.add("code"); 
        mylist.add("code"); 
        mylist.add("quiz"); 
        mylist.add("geeksforgeeks"); 
   
        // Here we are using frequency() method 
        // to get  frequency of element "code" 
        int freq = Collections.frequency(mylist, "code"); 
   
        System.out.println(freq); 
        
     // Let us create an array of integers 
        Integer arr[] = {10, 20, 20, 30, 20, 40, 50}; 
        int freq1 = Collections.frequency(Arrays.asList(arr), 20);
        System.out.println(freq1);
        
        String ab = "We have a call going on";
        
        HashMap<String,Integer> map1 = new HashMap<String,Integer>();
        for(int i=0;i<ab.length();i++){
        	
        	char ch = ab.charAt(i);
        	String chs = Character.toString(ch).toLowerCase();
        	if(ch != ' '){
        	if(map1.containsKey(chs)){
        		int j = map1.get(chs)+1;
        		map1.put(chs, j);
        	}else{
        		map1.put(chs, 1);
        	}
        	}
        }
        System.out.println(" frequency map "+map1);
	}

}

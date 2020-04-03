package Test4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class StudentTestClass {
	
	  // Complete the secureChannel function below.
    static String secureChannel(int op, String message, String key) {
        if(op==1){
            StringBuffer encodedMsg = new StringBuffer();
            int i=0;
            try{
            while(i<Math.min(message.length(),key.length())){
                for(int j=0;j<(key.charAt(i)-'0');j++){
                    encodedMsg.append(message.charAt(i));
                }
                i++;
            }
            while(i<message.length()){
                encodedMsg.append(message.charAt(i));
                i++;
            }
            }catch(Exception e){
                return "-1";
            }
            return encodedMsg.toString();
        }else if(op==2){
        	String msg = "";
        try{
            int i=0;
            int j=0;
            while(i<message.length() && j<key.length()){
                msg+=message.charAt(i);
                i+= (key.charAt(j)-'0');
                j++;
                i++;
            }
            while(i<message.length()){
                msg+=message.charAt(i);
                i++;
            }
            }catch(Exception e){
                return "-1";
            }
            return msg;
        }
        return "-1";
    }

	   static int countSpecialElements(List<List<Integer>> mat) {
	        int res = 0;
	        int m = mat.size();
	        int n = mat.get(0).size();
	        int rowMin[] = new int[m];
	        int rowMax[] = new int[m];
	        int colMin[] = new int[n];
	        int colMax[] = new int[n];
	        for (int i = 0; i < m; i++) {
	            int mine = Integer.MAX_VALUE;
	            int maxe = Integer.MIN_VALUE;
	            for (int j = 0; j < n; j++) {
	                if (mat.get(i).get(j) > maxe) {
	                    maxe = mat.get(i).get(j);
	                }
	                if (mat.get(i).get(j) < mine) {
	                    mine = mat.get(i).get(j);
	                }
	            }
	            rowMin[i] = mine;
	            rowMax[i] = maxe;
	        }
	        for (int i = 0; i < n; i++) {
	            int mine = Integer.MAX_VALUE;
	            int maxe = Integer.MIN_VALUE;
	            for (int j = 0; j < m; j++) {
	                if (mat.get(j).get(i) > maxe) {
	                    maxe = mat.get(j).get(i);
	                }
	                if (mat.get(j).get(i) < mine) {
	                    mine = mat.get(j).get(i);
	                }
	            }
	            colMin[i] = mine;
	            colMax[i] = maxe;
	        }
	        Set<Integer> set = new HashSet<Integer>();
	        for (int i = 0; i < m; i++) {
	            set.add(rowMin[i]);
	            set.add(rowMax[i]);
	        }
	        for (int i = 0; i < n; i++) {
	            set.add(colMin[i]);
	            set.add(colMax[i]);
	        }
	        if(set.size()==0){
	            return -1;
	        }
	        return set.size();
	    }

	public static void main(String[] args) {

		List<Student> stList = new ArrayList<>();
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

		int arr[] = new int[] { 55, 23, 32, 46, 88, 102, 105, 67, 60 };
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			int digits = getDigitSum(arr[i]);
			if (map.containsKey(digits)) {
				map.get(digits).add(arr[i]);
			} else {
				ArrayList<Integer> li = new ArrayList<>();
				li.add(arr[i]);
				map.put(digits, li);
			}
		}
		Set<Integer> st = map.keySet();
		Iterator it = st.iterator();
		int max_sum = 0;
		while (it.hasNext()) {
			ArrayList<Integer> list = map.get(it.next());
			int len = list.size();
			if (len > 1) {
				max_sum = Math.max(max_sum, list.get(len - 1) + list.get(len - 2));
			}
		}
		System.out.println("Max possible sum: " + max_sum);
		Student s1 = new Student("Ajmal", "Khan", 1, "Biology", 12);
		Student s2 = new Student("Khan", "Ajmal", 1, "English", 18);
		Student s3 = new Student("Priyanka", "Vadra", 1, "English", 21);
		Student s4 = new Student("Coolie", "Kalor", 1, "Maths", 29);
		Student s5 = new Student("Himmat", "Ram", 1, "Science", 9);
		Student s6 = new Student("Aisha", "Shae", 1, "Physics", 30);
		Student s7 = new Student("Renuka", "Kumawat", 1, "Botany", 25);
		Student s8 = new Student("Kumawat", "Renuka", 1, "Maths", 22);
		Student s9 = new Student("Vivek", "Shenoy", 1, "English", 23);
		Student s10 = new Student("Ramjas", "Chaturvedi", 1, "Biology", 4);
		stList.add(s1);
		stList.add(s2);
		stList.add(s3);
		stList.add(s4);
		stList.add(s5);
		stList.add(s6);
		stList.add(s7);
		stList.add(s8);
		stList.add(s9);
		stList.add(s10);
		BiPredicate<Student, Student> bp = (st1, st2) -> {
			return (st1.getFname().equals(st2.getFname()) && st1.getLname().equals(st2.getLname()))
					|| (st1.getLname().equals(st2.getFname()) && st1.getFname().equals(st2.getLname()));
		};
		System.out.println(bp.test(s1, s2));
		List<Student> res = stList.stream().collect(Collectors.toList());

	}

	private static int getDigitSum(int n) {
		int sum = 0;
		while (n > 0) {
			sum += (n % 10);
			n /= 10;
		}
		return sum;
	}

}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomStringShuffle {
	private final static String abc = "abcefghijklmnopqrstuvwxyz";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Character> l = new ArrayList<>();
		List<Character> reversel = new ArrayList<>();
		int n = 10;
		Random r = new Random();
		for(int i=0;i<n;i++) {
			l.add(abc.charAt(r.nextInt(abc.length()-1)));
		}
		l.stream().forEach(s->System.out.print(s));
		reversel.addAll(l);
		Collections.reverse(reversel);
		System.out.println("\nReverse:");
		reversel.stream().forEach(s->System.out.print(s));
		System.out.println();
		Collections.shuffle(l);
		List<Character> res = new ArrayList<>();
		int j=0;
		int k =0;
		while(j<n && k<n) {
			if(r.nextInt(100)>50) {
				res.add(l.get(k));
				k++;
			}else {
				res.add(reversel.get(j));
				j++;
			}	
		}
		while(j<n) {
			res.add(reversel.get(j));
			j++;
		}
		while(k<n) {
			res.add(l.get(k));
			k++;
		}
		res.stream().forEach(s->System.out.print(s));
	}

}

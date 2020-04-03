package LearningFromGFG;

import java.util.HashMap;

public class SearchPatternInString {
    static final int d =256;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String txt = "aabaacaadaabaaabaa";
     String pat = "aaba"; 
     search(txt, pat);
     
     txt = "ABCEABABCDABCEABCD";  
     pat = "ABABCD";  
     searchUniquePattern(pat, txt);  
     System.out.println("this is using rabin karp ");
     rabinKarpSearch(pat,txt,101);
     System.out.println("this is kmp search ");
     kmpSearch(txt,pat);
     //HashMap<Character,Character> mp = new HashMap<Character,Character>();
	}
	 public static void search(String txt, String pat) 
	    { 
	        int M = pat.length(); 
	        int N = txt.length(); 
	  
	        /* A loop to slide pat one by one */
	        for (int i = 0; i <= N - M; i++) { 
	  
	            int j; 
	  
	            /* For current index i, check for pattern  
	              match */
	            for (j = 0; j < M; j++) 
	                if (txt.charAt(i + j) != pat.charAt(j)) 
	                    break; 
	  
	            if (j == M) // if pat[0...M-1] = txt[i, i+1, ...i+M-1] 
	                System.out.println("Pattern found at index " + i); 
	                return;
	        }
	        System.out.println("Pattern Not Found ");
	    } 
	  
	 /* Java program for A modified Naive Pattern Searching  
	 algorithm that is optimized for the cases when all  
	 characters of pattern are different */
	 static void searchUniquePattern(String pat, String txt) {
		 int m = pat.length();
		 int n = txt.length();
		 int i=0;
		 while(i<=n-m){
			 int j;
			 for(j=0;j<m;j++){
				 if(pat.charAt(j)!= txt.charAt(j+i)){
					 break;
				 }
			 }
			 if(j==m){
				 System.out.println("Match found at "+i);
				 i=i+m;
			 }
			 if(j==0){
				 i=i+1;
			 }else{
				 i=i+j;
			 }
			 
		 }
	 }
	 /*Using Rabin Karp algo*/
	 public static void rabinKarpSearch(String pat, String txt, int q){
		 int n=txt.length();
		 int m=pat.length();
		 int h=1;
		 int t =0;//hash value for text
		 int p=0;//hash value for pattern
		 int i,j;
		// The value of h would be "pow(d, M-1)%q" 
		 for(i=0;i<m-1;i++){
			 h=(h*d)%q;
		 }
		 System.out.println("h "+h);
		 for(i=0;i<m;i++){
			t=(d*t+txt.charAt(i))%q;
			p=(d*p+pat.charAt(i))%q;
		 }
		 System.out.println("first hash code for text "+t);
		 System.out.println("first hash code for pat "+p);
		 for(i=0;i<=n-m;i++){
			 // Check the hash values of current window of text 
	            // and pattern. If the hash values match then only 
	            // check for characters on by one 
			 if(p==t){
				 for(j=0;j<m;j++){
					 if(txt.charAt(j+i)!=pat.charAt(j)){
						 break;
					 }
				 }
				 // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
				 if(j==m){
					 System.out.println("found pattern match at "+i);
				 }
			 }
			 if(i<n-m){
				// Calculate hash value for next window of text: Remove 
		            // leading digit, add trailing digit 
				 t=(d*(t-txt.charAt(i)*h)+txt.charAt(i+m))%q;
				 // We might get negative value of t, converting it 
	                // to positive 
				 if(t<0){
					 t = t+q;
				 }
			 }
		 }
	 }
	 static void printArray(int[] arr, int m){
		 for(int i=0;i<m;i++){
			 System.out.print(arr[i]+" ");
		 }
	 }
	 /*KMP algo*/
	 public static void kmpSearch(String txt, String pat){
		 int n = txt.length();
		 int m= pat.length();
		 int[] lsp = new int[m];
		 createlsp(lsp,pat,m);
		 printArray(lsp,m);
		 int i=0,j=0;
		while(i<n){
				 if(pat.charAt(j)==txt.charAt(i)){
					 i++;
					 j++;
				 }
				 if(j==m){
					 System.out.println("found match kmp at "+(i-j));
					 j=lsp[j-1];
				 }
				 else if(i<n && pat.charAt(j) != txt.charAt(i)){
					 if(j!=0){
						 j=lsp[j-1];
					 }else{
						 i=i+1;
					 }
				 }
				 
			 }
		 }
	 static void createlsp(int[] lsp, String pat, int m){
		 int i=1,j=0;
		 lsp[0] = 0;
		 while(i<m){
			 if(pat.charAt(i) == pat.charAt(j)){
				 j++;
				 lsp[i] = j;
				 i++;
			 }else{
				 if(j!=0){
					 j = lsp[j-1];
				 }else{
					 lsp[i] =j;
					 i++;
				 }
			 }
		 }
	 }
}

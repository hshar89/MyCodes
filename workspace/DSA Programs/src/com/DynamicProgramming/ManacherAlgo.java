package com.DynamicProgramming;

public class ManacherAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String ab = "aaaabbaa";
      System.out.println("length of largest plaindrome "+longestPalindromeSubstringEasy(ab.toCharArray()));
      System.out.println("length of largest palindrome by Manachers algo "+longestPalindromicSubstringLinear(ab.toCharArray()));
	}
	
	public static int longestPalindromeSubstringEasy(char arr[]) {
		int longest_substring = 1;
		int start = 0;
		for(int i=0;i<arr.length;i++) {
			int x,y;
			// Find the longest even length palindrome  
	        // with center points as i-1 and i.  
			x = i;
			y=i+1;
			while(x>=0 && y<arr.length && arr[x]==arr[y]) {
				if(longest_substring<(y-x+1)) {
					start = x;
					longest_substring = y-x+1;
				}
				x--;
				y++;
			}
			// Find the longest odd length palindrome with center  
	        // point as i  
			 x=i-1;
			 y=i+1;
			 while(x>=0 && y<arr.length && arr[x] == arr[y]) {
				 if(longest_substring<(y-x+1)) {
						start = x;
						longest_substring = y-x+1;
					}
				 x--;
				 y++;
			 }
		}
		for(int i=start;i<(start+longest_substring);i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
		return longest_substring;
	}
	 /**
     * Linear time Manacher's algorithm to find longest palindromic substring.
     * There are 4 cases to handle
     * Case 1 : Right side palindrome is totally contained under current palindrome. In this case do not consider this as center.
     * Case 2 : Current palindrome is proper suffix of input. Terminate the loop in this case. No better palindrom will be found on right.
     * Case 3 : Right side palindrome is proper suffix and its corresponding left side palindrome is proper prefix of current palindrome. Make largest such point as
     * next center.
     * Case 4 : Right side palindrome is proper suffix but its left corresponding palindrome is be beyond current palindrome. Do not consider this
     * as center because it will not extend at all.
     *
     * To handle even size palindromes replace input string with one containing $ between every input character and in start and end.
     */
	public static int longestPalindromicSubstringLinear2(char input[]) {
		int index=0;
		//preprocess the input to convert it into type abc -> $a$b$c$ to handle even length case.
        //Total size will be 2*n + 1 of this new array.
		char arr[] = new char[2*input.length+1];
		int n = arr.length;
		for(int i=0;i<n;i++) {
			if(i%2==0) {
				arr[i] = '$';
			}else {
				arr[i] = input[index++];
			}
		}
		//create temporary array for holding largest palindrome at every point. There are 2*n + 1 such points.
		int temp[] = new int[n];
		int start = 0;
		int end = 0;
		int i=0;
		//here i is the centre
		try {
		for(i=0;i<n;) {
			//expand around i see how far we can go
			while(start>0 && end <n-1 && arr[start-1] == arr[end+1]) {
				start--;
				end++;
			}
			//set the longest value of palindrome around center i at T[i]
			temp[i] = end-start+1;
			//this is case 2. Current palindrome is proper suffix of input. No need to proceed. Just break out of loop.
			if(end == n-1) {
				break;
			}
			//Mark newCenter to be either end or end + 1 depending on if we dealing with even or old number input.
			int newcentre = end+(i%2==0?1:0);
			
			for(int j=i+1;j<=end;j++) {
				 //i - (j - i) is left mirror. Its possible left mirror might go beyond current center palindrome. So take minimum
                //of either left side palindrome or distance of j to end.
				temp[j] = Math.min(temp[i-(j-i)], 2*(end-j)+1);
				//Only proceed if we get case 3. This check is to make sure we do not pick j as new center for case 1 or case 4
                //As soon as we find a center lets break out of this inner while loop.
				if(j+temp[i-(j-i)]/2==end) {
					newcentre = j;
					break;	
				}
			}
			 //make i as newCenter. Set right and left to atleast the value we already know should be matching based of left side palindrome.
			i=newcentre;
			end = i+temp[i]/2;
			start = i-temp[i/2];
		}
		}catch(Exception e) {
			System.out.println("i "+i+" end "+end+" n "+n);
		}
	  int max = Integer.MAX_VALUE;
	  for(int k=0;k<temp.length;k++) {
		  int val = temp[k]/2;
		  if(max<val) {
			  max = val;
		  }
	  }
		return max;
	}
	public static int longestPalindromicSubstringLinear(char input[]) {
        int index = 0;
        //preprocess the input to convert it into type abc -> $a$b$c$ to handle even length case.
        //Total size will be 2*n + 1 of this new array.
        char newInput[] = new char[2*input.length + 1];
        for(int i=0; i < newInput.length; i++) {
            if(i % 2 != 0) {
                newInput[i] = input[index++];
            } else {
                newInput[i] = '$';
            }
        }

        //create temporary array for holding largest palindrome at every point. There are 2*n + 1 such points.
        int T[] = new int[newInput.length];
        int start = 0;
        int end = 0;
        //here i is the center.
        for(int i=0; i < newInput.length; ) {
            //expand around i. See how far we can go.
            while(start >0 && end < newInput.length-1 && newInput[start-1] == newInput[end+1]) {
                start--;
                end++;
            }
            //set the longest value of palindrome around center i at T[i]
            T[i] = end - start + 1;

            //this is case 2. Current palindrome is proper suffix of input. No need to proceed. Just break out of loop.
            if(end == T.length -1) {
                break;
            }
            //Mark newCenter to be either end or end + 1 depending on if we dealing with even or old number input.
            int newCenter = end + (i%2 ==0 ? 1 : 0);

            for(int j = i + 1; j <= end; j++) {

                //i - (j - i) is left mirror. Its possible left mirror might go beyond current center palindrome. So take minimum
                //of either left side palindrome or distance of j to end.
                T[j] = Math.min(T[i - (j - i)], 2 * (end - j) + 1);
                //Only proceed if we get case 3. This check is to make sure we do not pick j as new center for case 1 or case 4
                //As soon as we find a center lets break out of this inner while loop.
                if(j + T[i - (j - i)]/2 == end) {
                    newCenter = j;
                    break;
                }
            }
            //make i as newCenter. Set right and left to atleast the value we already know should be matching based of left side palindrome.
            i = newCenter;
            end = i + T[i]/2;
            start = i - T[i]/2;
        }

        //find the max palindrome in T and return it.
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < T.length; i++) {
            int val;
      /*      if(i%2 == 0) {
                val = (T[i] -1)/2;
            } else {
                val = T[i]/2;
            }*/
            val = T[i]/2;
            if(max < val) {
                max = val;
            }
        }
        return max;
    }

	public int longestPalindromeDynamic(char []str){
        boolean T[][] = new boolean[str.length][str.length];
        
        for(int i=0; i < T.length; i++){
            T[i][i] = true;
        }
        
        int max = 1;
        for(int l = 2; l <= str.length; l++){
            int len = 0;
            for(int i=0; i < str.length-l+1; i++){
                int j = i + l-1;
                len = 0;
                if(l == 2){
                    if(str[i] == str[j]){
                        T[i][j] = true;
                        len = 2;
                    }
                }else{
                    if(str[i] == str[j] && T[i+1][j-1]){
                        T[i][j] = true;
                        len = j -i + 1;
                    }
                }
                if(len > max){
                    max = len;
                }
            }
        }
        return max;
    }

}

package PractiseJavaPrograms;

import java.util.Arrays;

public class xPowyGreaterThanyPowx {
	public static void main(String[] args) {
		String a1 = "12 477 306 166 207 99 419 120 292 25 468 351 435 496 476 76 195 288 466 263 140 9 461 183 87 496 123 436 449 60 120 139 467 374 251 61 342 94 49 407 419 269 213 66 120 128 72 115 43 251 250 229 262 478 237 26 107 466 284 454 406 127 154 166 46 128 281 432 381 184 348 224 82 64 45 250 427 441 163 292 30 199 99 479 228 326 461 270 181 224 348 403 166 83 424 56 188 308 310 331 92 112 45 345 76 190 206 257 225 218 357 49 261 281 151 89 467 68 279 174 344 49 433 77 264 99 336 117 358 481 167 162 492 434 430 86 251 392 194 289 289 287 58 60 328 411 227 291 242 265 167 75 193 149 413 393 217 159 328 160 43 340 164 449 397 251 397 197 179 109 487 438 304 324 2 42 346 131 95 401 494 55 395 205";
		String[] al = a1.split("\\s+");
		int[] arr1 = new int[al.length];
		for(int i=0;i<al.length;i++){
			arr1[i] = Integer.parseInt(al[i]);
		}
		a1 = "43 125 70 82 144 328 202 3 24 39 62 335 102 206 401 233 457 137 211 418 94 478 293 411 491 409 276 390 70 392 140 336 307 40 174 70 74 445 328 196 337 396 103 317 8 23 265 449 9 273 9 291 158 48 332 87 197 407 468 315 191 468 106 12 384 154 440 327 443 430 441 28 41 387 444 48 154 471 111 106 210 472 472 243 333 343 421 226 382 219 89 352 253 358 366 476 431 352 103 251 289 248 73 291 220 218 494 261 257 93 194 200 33 350 374 344 434 445 357 487 26 365 1 333 23 146 54 210 396 248 9 320 135 137";
		al = a1.split("\\s+");
		int[] arr2 = new int[al.length];
		for(int i=0;i<arr2.length;i++){
			arr2[i] = Integer.parseInt(al[i]);
		}
		System.out.println("count "+countPairs(arr1,arr2,arr1.length,arr2.length));
		
		int[] arr3 = {0,2,6,8,9};
		System.out.println("binary search "+Math.abs(Arrays.binarySearch(arr3, 10)+2));
	}
	static void printArray(int[] arr, int n){
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}
	 // Function to return count of pairs with x as one element 
    // of the pair. It mainly looks for all values in Y[] where 
    // x ^ Y[i] > Y[i] ^ x 
    static int count(int x, int Y[], int n, int NoOfY[]) 
    { 
        // If x is 0, then there cannot be any value in Y such that 
        // x^Y[i] > Y[i]^x 
        if (x == 0) return 0; 
       
        // If x is 1, then the number of pais is equal to number of 
        // zeroes in Y[] 
        if (x == 1) return NoOfY[0]; 
       
        // Find number of elements in Y[] with values greater than x 
        // getting upperbound of x with binary search 
        int idx = Arrays.binarySearch(Y, x); 
        int ans; 
        if(idx < 0){ 
            idx = Math.abs(idx+1); 
            ans = Y.length - idx; 
        } 
        else{ 
            while (idx<n && Y[idx]==x) { 
                idx++; 
            } 
            ans = Y.length - idx; 
        } 
       
        // If we have reached here, then x must be greater than 1, 
        // increase number of pairs for y=0 and y=1 
        ans += (NoOfY[0] + NoOfY[1]); 
       
        // Decrease number of pairs for x=2 and (y=4 or y=3) 
        if (x == 2)  ans -= (NoOfY[3] + NoOfY[4]); 
       
        // Increase number of pairs for x=3 and y=2 
        if (x == 3)  ans += NoOfY[2]; 
       
        return ans; 
    } 
	// Function to returns count of pairs (x, y) such that 
    // x belongs to X[], y belongs to Y[] and x^y > y^x 
    static int countPairs(int X[], int Y[], int m, int n) 
    { 
        // To store counts of 0, 1, 2, 3 and 4 in array Y 
        int NoOfY[] = new int[5]; 
        for (int i = 0; i < n; i++) 
            if (Y[i] < 5) 
                NoOfY[Y[i]]++; 
       
        // Sort Y[] so that we can do binary search in it 
        Arrays.sort(Y); 
       
        int total_pairs = 0; // Initialize result 
       
        // Take every element of X and count pairs with it 
        for (int i=0; i<m; i++) 
            total_pairs += count(X[i], Y, n, NoOfY); 
       
        return total_pairs; 
    } 
}

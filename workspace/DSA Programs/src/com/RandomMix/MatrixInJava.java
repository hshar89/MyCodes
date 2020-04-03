package PractiseJavaPrograms;

import java.util.HashSet;
import java.util.Set;

public class MatrixInJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat2 = {{12,15,17},{30,45,67},{40,56,93}};
        int[][] mat3 = {{1},{2},{3},{4},{5},{6},{7},{8},{9}};
        int[][] mat4 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
        int[][] mat5 = {{7, 67, 5, 49, 44, 24, 29, 89},{5,98,18,79,12,81,28,82},{38,49,46,99,86,97,23,50},{36,6,1,63,0,10,2,7},{77,59,56,22,36,38,63,41}};
        int[][] mat6 = {{1,0,0},{1,0,0},{1,0,0},{0,0,0}};
        /*System.out.println("the index of element "+searchInSortedMatrix(mat2,56));
        transposeMatrix(mat);
        rotateMat(mat);
        for(int i=0;i<mat.length;i++){
        	for(int j=0;j<mat[i].length;j++){
        		System.out.print(mat[i][j]+" ");
        	}
        }
        printBoundaryElements(3,3,mat2);
        System.out.println("\n new one ");
        boundaryTraversal2(8,1,mat3);
        spirallyTraversal(5,8,mat5);*/
        booleanMatrix(4,3,mat6);
        
	}
	static void beautifulMatrixOpp(int[][] matrix,int n){
		// Initialize the sumRow[] 
        // and sumCol[] array to 0 
        int[] sumRow = new int[n]; 
        int[] sumCol = new int[n]; 
        
     // Calculate sumRow[] and 
        // sumCol[] array 
        for (int i = 0; i < n; ++i) 
   
            for (int j = 0; j < n; ++j) 
            { 
                sumRow[i] += matrix[i][j]; 
                sumCol[j] += matrix[i][j]; 
            } 
     // Find maximum sum value  
        // in either row or in column 
        int maxSum = 0; 
        for (int i = 0; i < n; ++i)  
        { 
            maxSum = Math.max(maxSum, sumRow[i]); 
            maxSum = Math.max(maxSum, sumCol[i]); 
        } 
        int count = 0; 
        for (int i = 0, j = 0; i < n && j < n;)  
        {     
        	 // Find minimum increment 
            // required in either row 
            // or column 
            int diff = Math.min(maxSum - sumRow[i], 
                        maxSum - sumCol[j]); 
            // Add difference in  
            // corresponding cell, 
            // sumRow[] and sumCol[] 
            // array 
            matrix[i][j] += diff; 
            sumRow[i] += diff; 
            sumCol[j] += diff; 
            // Update the count  
            // variable 
            count += diff; 
      
            // If ith row satisfied, 
            // increment ith value  
            // for next iteration 
            if (sumRow[i] == maxSum) 
                ++i; 
            // If jth column satisfied,  
            // increment jth value for 
            // next iteration 
            if (sumCol[j] == maxSum) 
                ++j; 
        }
        System.out.println("count "+count);
	}
	static void booleanMatrix2(int r, int c, int mat[][]){
		  //Your code here
        int[] row = new int[r];
        int[] col = new int[c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j] == 1){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
     for(int i=0;i<r;i++){
         for(int j=0;j<c;j++){
             if(row[i] ==1 || col[j] == 1){
                System.out.print(1+" "); 
             }else{
                 System.out.print(0+" ");
             }
         }
         System.out.println();
     }
	}
	static void booleanMatrix(int r, int c, int mat[][])
    {
        //Your code here
        Set<Integer> setOfRows = new HashSet<Integer>();
        Set<Integer> setOfColumns = new HashSet<Integer>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j] == 1){
                    setOfRows.add(i);
                    setOfColumns.add(j);
                }
            }
        }
      for(Integer a: setOfRows){
    	  int j=0;
    	  while(j<c){
    		  mat[a][j] = 1;
    		  j++;
    	  }
      }
      for(Integer a: setOfColumns){
    	  int i=0;
    	  while(i<r){
    		  mat[i][a] = 1;
    		  i++;
    	  }
      }
            
      printMatrix(mat,r,c);  
    }
	static void printMatrix(int[][] mat, int r,int c){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
	static void spirallyTraversal(int m,int n, int[][] arr1){
		int i=0,j=0,k;
	       while(i<m && j<n){
	           for(k=j;k<n;k++){
	               System.out.print(arr1[i][k]+" ");
	           }
	           i++;
	          
	           for(k=i;k<m;k++){
	               System.out.print(arr1[k][n-1]+" ");
	           }    
	           j++;
	           if(i<m){
	           for(k=n-2;k>=j;k--){
	               System.out.print(arr1[m-1][k]+" ");
	           }
	           }
	           if(j<n){
	           for(k=m-1;k>=i;k--){
	               System.out.print(arr1[k][j-1]+" ");
	           }	
	           }
	           m--;
	           n--;
	       }
	}
	static String searchInSortedMatrix(int[][] mat,int n){
		int i=0;
		//while(i<mat.length){
			int j = mat[0].length-1;
			while(j>=0 && i<mat.length){
				if(mat[i][j]>n){
					j--;
				}else if(mat[i][j]<n){
					i++;
				}else{
					return i+" "+j;
				}
			}
		//}
		return "-1";
	}
	static void rotateMat(int[][] mat){
		for(int i=0;i<mat.length;i++){
			int j=mat.length-1,k=0;
			while(j>k){
				int temp = mat[k][i];
				mat[k][i] = mat[j][i];
				mat[j][i] = temp;
				j--;
				k++;
			}
		}
	}
   static void transposeMatrix(int [][] mat){
	   for(int i=0;i<mat.length;i++){
       	for(int j=i+1;j<mat[i].length;j++){
       		int temp = mat[i][j];
       		mat[i][j] = mat[j][i];
       		mat[j][i] = temp;
       		//swap(mat[i][j],mat[j][i]);
       	}
       }
   }
   static void printBoundaryElements(int n1, int m1, int a[][]){
	   int i=0,j=0;
	      while(true){
	           if(i==0 && j==0){
	           while(j<m1){
	               System.out.print(a[i][j]+" ");
	               j++;
	           }
	           }else if(i==0 && j==m1){
	        	   i++;
	               while(i<n1){
	                   System.out.print(a[i][j-1]+" ");
	                   i++;
	               }
	           }else if(i==n1 && j==m1){
	        	   j=j-2;
	               while(j>=0){
	                   System.out.print(a[i-1][j]+" ");
	                   j--;
	               }
	               j++;
	           }else if(i==n1 && j==0){
	        	   i=i-2;
	               while(i>0){
	                   System.out.print(a[i][j]+" ");
	                   i--;
	               }
	             i--;
	           }else{
	               break;
	           }
	       }
   }
   static void boundaryTraversal2(int n1, int m1, int[][] a){
	   //Your code here
	   int i=0,j=0,k;
	      while(i<n1 && j<m1){
	          for(k=j;k<m1;k++){
	              System.out.print(a[i][k]+" ");
	          }
	          i++;
	          for(k=i;k<n1;k++){
	              System.out.print(a[k][m1-1]+" ");
	          }
	          if(i==n1) break;
	          i=k-1;
	          j=m1-1;
	          for(k=j-1;k>=0;k--){
	              System.out.print(a[i][k]+" ");
	          }
	          //k=i;
	          for(k=i-1;k>0;k--){
	              System.out.print(a[k][0]+" ");
	          }
	          i++;
	          j++;
	      }
	      
   }
} 

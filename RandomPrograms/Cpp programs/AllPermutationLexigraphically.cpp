#include <iostream>
#include <bits/stdc++.h>
using namespace std;
int compare(const void*a, const void *b){
   return ( *(char *)a - *(char *)b ); 
}
int findCeil(char ab[], char first, int l, int h){
      int ceilValue = l;
	  for(int i=l;i<=h;i++){
	    if(ab[i]>first && ab[i]<ab[ceilValue]){
		ceilValue = i;
		}
		}
		return ceilValue;
}
void permutate(char ab[],int n){
      qsort(ab,n,sizeof(ab[0]),compare);
	  int finished = false;
	  while(!finished){
	  cout<<ab<<" ";
	  int i;
	  for(i=n-2;i>=0;i--){
	     if(ab[i]<ab[i+1]){
		 break;
		 }
		 }
	   if(i<0){
         break;
       }else{
        int ceilValue = findCeil(ab,ab[i],i+1,n-1);
        swap(ab[i],ab[ceilValue]);
        qsort(ab+i+1,size-i-1,sizeof(ab[0]),compare);
    }
     }
}	 
int main() {
	//code
	int t;
	cin>>t;
	while(t-->0){
	    string str;
	    cin>>str;
	    int n = str.length();
	    char ab[n];
	    strcpy(ab,str.c_str());
	    permutate(ab,n);
	    cout<<endl;
	}
	return 0;
}
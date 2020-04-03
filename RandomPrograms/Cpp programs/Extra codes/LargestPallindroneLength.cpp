//To find Largest length of a pallindrone in a string
#include <iostream>
using namespace std;
void printSubStr( string str, int low, int high ) 
{ 
    for( int i = low; i <= high; ++i ) 
        cout << str[i]; 
} 
void printLargestPalindrome(string str, int n){
    bool dp[n][n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            dp[i][j] = false;
            if(i==j){
                dp[i][i] = true;
            }
        }
    }
    int start=-1,maxLength=1;
    for(int i=0;i<n-1;i++){
      if(str[i]==str[i+1]){
          dp[i][i+1] = true;
          if(start==-1){
          start = i;
          maxLength = 2;
          }
      }    
    }
    int k;
    for(k=3;k<=n;k++){
        for(int i=0;i<n-k+1;i++){
              int j = i+k-1;
            if(dp[i+1][j-1] && str[i] == str[j]){
                dp[i][j] = true;
            if(k>maxLength){
                //cout<<" k "<<k<<" ";
                maxLength = k;
                start = i;
            }
            }
        }
    }
    if(start == -1){
        cout<<str[0];
    }else{
    printSubStr( str, start, start + maxLength - 1 ); 
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
	    printLargestPalindrome(str,n);
	    cout<<endl;
	}
	return 0;
}
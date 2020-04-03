#include <iostream>
#include <vector>
#include <iterator>
using namespace std;
bool isSequencePossible(int arr[], int s, vector<int> adj[], int marker[],int n){
    if(s<0){
        return true;
    }
    //cout<<"s: "<<s<<" ";
    for(int i=0;i<n;i++){
        if(marker[i] < adj[i].size() && adj[i][marker[i]] == arr[s]){
            marker[i]++;
           if(isSequencePossible(arr,s-1,adj,marker,n)){
               return true;
           }else{
               marker[i]--;
           } 
        }
    }
    return false;
}
int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t-->0){
	    int n;
	    cin>>n;
	    //cout<<"n: "<<n<<" ";
	    vector<int> adj[n];
	    int totalNumbersInList = 0;
	    for(int i=0;i<n;i++){
	        int m;
	        cin>>m;
	        totalNumbersInList+=m;
	        int temp;
	        for(int j=0;j<m;j++){
	            cin>>temp;
	            adj[i].push_back(temp);
	        }
	    }
	    //cout<<"totalNumbersInList: "<<totalNumbersInList<<" ";
	    int temp;
	    int arr[totalNumbersInList];
	    int marker[totalNumbersInList];
	    for(int i=0;i<totalNumbersInList;i++){
	        cin>>temp;
	        arr[i] = temp;
	        marker[i] = 0;
	    }
	    if(isSequencePossible(arr,totalNumbersInList-1,adj,marker,n)){
	        cout<<"Yes"<<endl;
	    }else{
	        cout<<"No"<<endl;
	    }
	}
	return 0;
}

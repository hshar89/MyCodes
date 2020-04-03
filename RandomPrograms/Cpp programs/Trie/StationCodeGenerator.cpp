#include <iostream>
#include <bits/stdc++.h>
using namespace std;
struct TrieNode{
    TrieNode* child[26];
    bool isEndOfWord;
    TrieNode(){
        for(int i=0;i<26;i++){
           child[i] = NULL; 
        }
        isEndOfWord=false;
    }
};
string getStationCode(TrieNode* root, string toi){
    //cout<<"entered station code ";
    TrieNode* curr = root;
    string code="";
    int firstUnmatchIndex = -1;
    for(int i=0;i<toi.length();i++){
       if(curr->child[toi[i]-'a']!=NULL){
           code+=toi[i];
       }else{
           firstUnmatchIndex = firstUnmatchIndex==-1?i:firstUnmatchIndex;
           curr->child[toi[i]-'a'] = new TrieNode();
       }
       curr= curr->child[toi[i]-'a'];
    }
    code+=toi[firstUnmatchIndex];
    return code;
}
int main() {
	//code
	int t;
	cin>>t;
	while(t-->0){
	    int n;
	    cin>>n;
	    string toi;
	    TrieNode* root = new TrieNode();
	    unordered_map<string,int> mp;
	    for(int i=0;i<n;i++){
	        cin>>toi;
	        //cout<<toi<<" ";
	        if(mp.find(toi)!=mp.end()){
	            cout<<toi<<" "<<(mp[toi]+1)<<endl;
	        }else{
	          cout<<getStationCode(root,toi)<<endl;  
	        }
	        mp[toi]++;
	    }
	}
	return 0;
}
#include<bits/stdc++.h>
using namespace std;
unordered_set<string> st;
bool dictionaryContains(string s){
    if(st.find(s)!=st.end()){
        return true;
    }
    return false;
}
bool wordBreak(string s){
    int size = s.length();
    if(size == 0){
        return true;
    }
    bool dp[size+1];
    memset(dp,0,sizeof(dp));
    for(int i=1;i<=size;i++){
        if(dp[i]==false && dictionaryContains(s.substr(0,i))){
            dp[i] = true;
        }
        if(dp[i]){
             if(i==size){
                return true;
            }
            int lastMatch = i;
            for(int j=i+1;j<=size;j++){
               // cout<<"lastMatch: "<<lastMatch<<" "<<j<<"\n";
                if(dp[j]==false && dictionaryContains(s.substr(lastMatch,j-lastMatch))){
                    dp[j] = true;
                    lastMatch = j;
                }
                if(j==size){
                if(dp[j]){
                    return true;
                }else{
                    return false;
                }
                }
            }
        }
    }
}
int main(){
    st.insert("mobile");
    st.insert("samsung");
    st.insert("sam");
    st.insert("sung");
    st.insert("man");
    st.insert("mango");
    st.insert("icecream");
    st.insert("and");
    st.insert("go");
    st.insert("i");
    st.insert("like");
    st.insert("ice");
    st.insert("cream");
    if(wordBreak("ilikedsamsung")){
        cout<<"1\n";
    }else{
        cout<<"0\n";
    }
}
#include<bits/stdc++.h>
using namespace std;
int canTreeBeFormed(int pre[], int post[], int in[], int len){
    if(len == 0){
        return 1;
    }
    if(len == 1){
        return (pre[0] == post[0]) &&(post[0] == in[0]);
    }
    int idx = -1;
    for(int i=0;i<len;i++){
        if(in[i] == pre[0]){
            idx = i;
            break;
        }
    }
    if(idx == -1){
        return 0;
    }
    int ret1 = canTreeBeFormed(pre+1,post,in,idx);
   int ret2 = canTreeBeFormed(pre+idx+1,post+idx,in+idx+1,len-idx-1);
   return ret1 && ret2;
}
int main(){
    int preOrder[] = {1, 2, 4, 5, 3}; 
    int postOrder[] = {4, 5, 2, 3, 1}; 
    int inOrder[] = {4, 2, 5, 1, 3}; 
  
    int n = sizeof(inOrder)/sizeof(inOrder[0]);  
    if(canTreeBeFormed(preOrder,postOrder,inOrder,n)){
        cout<<"yes";
    }else{
        cout<<"no";
    }
}
#include<bits/stdc++.h>
using namespace std;
struct node{
    int data;
    node *left, *right;
    node(int data){
        this->data= data;
        left = right = NULL;
    }
};
int search(int preOrder[], int l, int r, int val){
    for(int i=l;i<=r;i++){
        if(preOrder[i] == val){
            return i;
        }
    }
    return -1;
}
node* buildTree(int inOrder[], int preOrder[], int l, int r, int &index){
    if(l>r){
        return NULL;
    }
    node* root = new node(inOrder[index++]);
    if(l == r){
        return root;
    }
    int x = search(preOrder,l,r,root->data);
    if(x==-1){
        return NULL;
    }
    root->left= buildTree(inOrder,preOrder,l,x-1,index);
    root->right = buildTree(inOrder,preOrder,x+1,r,index);
    
    return root;
}
int checkForPostOrder(node *root,int postOrder[], int index){
    if(root == NULL){
        return index;
    }
    index = checkForPostOrder(root->left,postOrder,index);
    index  = checkForPostOrder(root->right,postOrder,index);
    if(postOrder[index] == root->data){
        return index+1;
    }
    return -1;
}
int main(){
    int inOrder[] = {4, 2, 5, 1, 3}; 
    int preOrder[] = {1, 2, 4, 5, 3}; 
    int postOrder[] = {4, 5, 2, 3, 1}; 
  
    int n = sizeof(inOrder)/sizeof(inOrder[0]);
    int index = 0;  
    node *root = buildTree(inOrder,preOrder,0,n-1,index);
    if(checkForPostOrder(root,postOrder,0) != -1){
        cout<<"yes";
    }else{
        cout<<"no";
    }
}
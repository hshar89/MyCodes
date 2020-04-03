#include<bits/stdc++.h>
using namespace std;
struct node{
  int data;
  node *left,*right;
  node(int data){
      this->data = data;
      left=right=NULL;
  }
};
node* findRootUtil(node *root, int n1, int n2, bool &v1, bool &v2){
    if(root==NULL){
        return NULL;
    }
    if(root->data == n1){
        v1 = true;
        return root;
    }
    if(root->data == n2){
        v2 = true;
        return root;
    }
    node* left = findRootUtil(root->left,n1,n2,v1,v2);
    node *right = findRootUtil(root->right,n1,n2,v1,v2);

    if(left && right){
        return root;
    }
    return left!=NULL?left:right;
}
bool findRoot(node* root, int n1){
    if(root == NULL){
        return false;
    }
    if(root->data == n1 || findRoot(root->left,n1) || findRoot(root->right,n1)){
        return true;
    }
    return false;
}
node* findCommonRoot(node* root, int n1, int n2){
    bool v1 = false;
    bool v2 = false;
    node *lca = findRootUtil(root,n1,n2,v1,v2);
    if(v1 && v2 || (v1 && findRoot(lca,n2) || (v2 && findRoot(lca,n1)))){
        return lca;
    }
    return NULL;
}
int main(){
    node *root= new node(1);
    root->left= new node(2);
    root->right = new node(3);
    root->left->left = new node(4);
    root->left->right = new node(5);
    root->left->left->left = new node(6);
    root->left->right->right = new node(7);
    root->right->left = new node(8);
    root->right->right = new node(9);
    node *lca = findCommonRoot(root,3,8);
    if(lca!=NULL){
        cout<<"common root: "<<lca->data<<"\n";
    }else{
        cout<<"not found\n";
    }
    return 0;
}
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
bool findPath(node* root, int n1, vector<int> &path){
    if(root == NULL){
        return false;
    }
    path.push_back(root->data);
    if(root->data == n1){
        return true;
    }
    if((root->left && findPath(root->left,n1,path)) ||
             (root->right && findPath(root->right,n1,path))){
        return true;
    }
    path.pop_back();
    return false;
}
int findCommonRoot(node*root, int n1, int n2){
    vector<int> path1,path2;
    if(!findPath(root,n1,path1) || !findPath(root,n2,path2)){
        return -1;
    }
    int i;
    for(i=0;i<path1.size() && i<path2.size();i++){
        if(path1[i] != path2[i]){
            break;
        }
    }
    return path1[i-1];
}
int main(){
    node *root= new node(1);
    root->left= new node(2);
    root->right = new node(3);
    root->left->left = new node(4);
    root->left->right = new node(5);
    root->left->left->left = new node(6);
    root->left->right->right = new node(7);
    int lca = findCommonRoot(root,3,7);
    if(lca!=-1){
        cout<<"common root: "<<lca<<"\n";
    }else{
        cout<<"not found\n";
    }

}
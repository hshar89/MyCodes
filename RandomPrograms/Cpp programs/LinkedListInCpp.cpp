#include<bits/stdc++.h>
using namespace std;
struct Node{
    int data;
    struct Node* next; 
    Node(int data){
        this->data = data;
        next = NULL;
    } 
};
void addNode(Node **head,int n){
   Node *new_node = new Node(n);
   new_node->next = *head;
   *head = new_node;
}
void printList(Node **head){
    Node *last = *head;
    while(last!=NULL){
        cout<<last->data<<" ";
        last = last->next;
    }
    cout<<"\n";
}
void insertAfter(Node *prev, int new_data){
    if(prev == NULL){
        return;
    }
    Node *new_node = new Node(new_data);
    new_node->next = prev->next;
    prev->next = new_node;
}
void append(Node** head, int new_data){
    Node *new_node = new Node(new_data);
    Node *last = *head;
    if(*head == NULL){
        *head = new_node;
        return;
    }
    while(last->next!=NULL){
        last = last->next;
    }
    last->next = new_node;

}
int main(){
    Node *head = new Node(1);
    addNode(&head,2);
    addNode(&head,3);
    addNode(&head,4);
    printList(&head);
    insertAfter(head->next->next,12);
    insertAfter(head->next,15);
    printList(&head);
    append(&head,18);
    append(&head,19);
    printList(&head);

}

#include <iostream>

using namespace std;

ListNode* createLinkList(int n);
void PrintListNode_Opposite(ListNode *head);

// 结点定义
typedef struct Node{
    int value;
    Node *next;
}ListNode;


int main(){
    
    ListNode *head=createLinkList(20);
    PrintListNode_Opposite(head->next);
    
    return 0;
    
}
 
// 头插法创建单链表
ListNode* createLinkList(int n){
    ListNode *head= (ListNode*)malloc(sizeof(ListNode));
    head->next=NULL;
    for (int i=0; i<n; i++) {
        ListNode* node=(ListNode*)malloc(sizeof(ListNode));
        node->value=i;
        node->next=head->next;
        head->next=node;
    }
    return head;
}

// 逆序输出单链表
void PrintListNode_Opposite(ListNode *head){
    ListNode *he= NULL;
    stack<ListNode*> values;
    while (head!=NULL) {
        values.push(head);
        head=head->next;
        
    }
    while (!values.empty()) {
        he=values.top();
        cout<<he->value<<',';
        values.pop();
    }
}
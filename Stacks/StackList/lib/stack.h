#ifndef STACK_LIST_H
#define STACK_LIST_H

#define TRUE 1
#define FALSE 0

typedef struct Node{
    int data;
    struct Node* top;
}Node;

void initializeStack(Node* ps);
int empty(Node* ps);
void push(Node* ps,int n);
int pop(Node* ps);
int stackTop(Node* ps);

#endif
#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

void initializeStack(Node* ps){
    ps->top = NULL;
}

int empty(Node* ps){
    if(ps->top == NULL){
        return TRUE;
    }
    return FALSE;
}

void push(Node* ps,int n){
    Node* newNode = (Node*)malloc(sizeof(Node*));

    if(newNode == NULL){
        printf("Stack Overflow\n");
        exit(1);
    }

    newNode->data = ps->data;
    newNode->top = ps->top;
    ps->data = n;
    ps->top = newNode;
}

int pop(Node* ps){
    if(empty(ps)){
        printf("\n\nERROR EMPTY STACK!!\n");
        exit(-1);
    }

    int temp = ps->data;
    Node* tempStack = ps->top;

    ps->data = tempStack->data;
    ps->top = tempStack->top;

    free(tempStack);

    return temp;
}

int stackTop(Node* ps){
    int temp = pop(ps);

    push(ps, temp);

    return temp;
}
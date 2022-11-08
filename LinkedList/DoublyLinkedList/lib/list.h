#ifndef LIST_H

#define LIST_H

#include "item.h"

#define TRUE 1
#define FALSE 0

typedef struct node{
    ITEM data;
    struct node* next;
    struct node* prev;
}NODE;

typedef struct list{
    int size;
    struct node* head;
    struct node* tail;
}LIST;

void initializeList(LIST* lst);
NODE* createNode(NODE* node, ITEM i);
int isEmpty(LIST* lst);
void insertFront(LIST* lst, ITEM i);
void printList(LIST* lst);
void printNode(NODE* node);
void insertRear(LIST* lst, ITEM i);
void insertInPosition(LIST* lst, ITEM i, int position);
void insertAfterPosition(LIST* lst, ITEM i, int position);
ITEM deletFront(LIST* lst);
ITEM deletRear(LIST* lst);
ITEM deletInPosition(LIST* lst, int position);
ITEM deletItem(LIST* lst, ITEM i);
ITEM deletIntValue(LIST* lst, ITEM i);
NODE* findIntNode(NODE* node, ITEM i);
ITEM deletDoubleValue(LIST* lst, ITEM i);
NODE* findDoubleNode(NODE* node, ITEM i);
ITEM deletStringValue(LIST* lst, ITEM i);
NODE* findStringNode(NODE* node, ITEM i);

#endif
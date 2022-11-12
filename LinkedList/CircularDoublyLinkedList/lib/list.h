#ifndef LIST_H

#define LIST_H

#include "item.h"

#define TRUE 1
#define FALSE 0

//Estrutura para os nós da lista
typedef struct node{
    ITEM data; //Tipo ITEM(int, double, char/string)
    struct node* next; //Ponteiro para o proximo item
    struct node* prev; //Ponteiro para o item anterior
}NODE;

//Estrutura para a list
typedef struct list{
    int size; //Marcador para o tamanho da lista
    struct node* head; //Ponteiro para o primeiro nó da lista
    struct node* tail; //Ponteiro para o ultimo nó da lista
}LIST;

void initializeList(LIST* lst);
int isEmpty(LIST* lst);
NODE* createNode(NODE* node, ITEM i);
void printList(LIST* lst);
void printNode(NODE* node, NODE* lastNode);
void insertFront(LIST* lst, ITEM i);
void insertRear(LIST* lst, ITEM i);
void insertInPosition(LIST* lst, ITEM i, int position);
ITEM removeFront(LIST* lst);
ITEM removeRear(LIST* lst);
ITEM removeInPosition(LIST* lst, int position);
ITEM removeInt(LIST* lst, ITEM i);
int findInt(NODE* node, NODE* tail, ITEM i, int count);
ITEM removeItem(LIST* lst, ITEM i);
ITEM removeDouble(LIST* lst, ITEM i);
int findDouble(NODE* node, NODE* tail, ITEM i, int count);
ITEM removeString(LIST* lst, ITEM i);
int findString(NODE* node, NODE* tail, ITEM i, int count);

#endif
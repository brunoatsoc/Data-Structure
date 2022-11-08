#ifndef LIST_H

#define LIST_H

#include "item.h"

#define TRUE 1
#define FALSE 0

//Estrutura para os nós da lista
typedef struct node{
    ITEM data; //Tipo de dado ITEM(int, double ou char/string)
    struct node* next; //Ponteiro para o proximo nó
    struct node* prev; //Ponteiro para o nó anterior
}NODE;

//Estrutura para a lista
typedef struct list{
    int size; //Variavel para marcar o tamanho da lista
    struct node* head; //Ponteiro para o primeiro nó da lista
    struct node* tail; //Ponteiro para o ultimo nó da lista
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
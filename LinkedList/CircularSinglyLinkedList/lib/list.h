#ifndef LIST_H

#define LIST_H

#include "item.h"

#define TRUE 1
#define FALSE 0

//Estrutura para os nós da lista
typedef struct node{
    ITEM data; //Variavel do tipo data(int, double e char/string)
    struct node* next; //Ponteiro para o proximo nó da lista
}NODE;

//Estrutura para a lista
typedef struct list{
    int size; //Marcador do tamnho da lista
    struct node* tail; //Ponteiro para o ultimo nó da lista
}LIST;

void initializeList(LIST* lst);
NODE* createNode(NODE* node, ITEM i);
int isEmpty(LIST* lst);
void insertFront(LIST* lst, ITEM i);
void insertRear(LIST* lst, ITEM i);
void printList(LIST* lst);
void insertInPosition(LIST* lst, ITEM i, int position);
ITEM removeFront(LIST* lst);
ITEM removeRear(LIST* lst);
ITEM removeInPosition(LIST* lst, int position);
ITEM removeItem(LIST* lst, ITEM i);
ITEM removeInt(LIST* lst, ITEM i);
int findInt(NODE* node, NODE* tail, ITEM i, int count);
ITEM removeDouble(LIST* lst, ITEM i);
int findDouble(NODE* node, NODE* tail, ITEM i, int count);
ITEM removeString(LIST* lst, ITEM i);
int findString(NODE* node, NODE* tail, ITEM i, int count);

#endif
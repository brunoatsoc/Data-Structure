#ifndef LIST_H

#define LIST_H

#define TRUE 1
#define FALSE 0

#include "item.h"

//Estrutura para o primeiro nó da lista
typedef struct list{
    int size;//Tamanho da lista
    struct node* head;//Ponteiro para o primeiro nó
}LIST;

//Estrutura para o link dos nós
typedef struct node{
    ITEM data;//Tipo de dado do nó
    struct node* next;//Ponteiro para o proximo nó
}NODE;

void initializeList(LIST* list);
void insertFront(LIST* lst, ITEM i);
void insertRear(LIST* lst, ITEM i);
void insertAfterPosition(LIST* lst, ITEM i, int position);
int printList(LIST* lst);
void printNode(NODE* node);
int isEmpty(LIST* lst);
ITEM removeFront(LIST* lst);
ITEM removeRear(LIST* lst);
ITEM removeInPosition(LIST* lst, int position);
int validPosition(LIST* lst, int position);

#endif
#include <stdio.h>
#include <stdlib.h>
#include "list.h"

//Inicializa a lista
void initializeList(LIST* lst){
    lst->size = 0;
    lst->head = NULL;
    lst->tail = NULL;
}

//Cria um nó para a lista e coloca um item neste nó
NODE* createNode(NODE* node, ITEM i){
    node = (NODE*)malloc(sizeof(NODE));
    if(node == NULL){
        printf("Error, memory could not be allocated!!\n");
        exit(-1);
    }
    node->data = i;
    node->next = NULL;
    node->prev = NULL;
    return node;
}

//Verifica se a lista está vazia
int isEmpty(LIST* lst){
    if(lst->head == NULL){
        return TRUE;
    }
    return FALSE;
}

//Insere um  item no começo da lista
void insertFront(LIST* lst, ITEM i){
    NODE* newNode = createNode(newNode, i);

    if(lst->head == NULL){
        lst->head = newNode;
        lst->tail = newNode;
    }else{
        newNode->next = lst->head;
        lst->head->prev = newNode;
        lst->head = newNode;
    }
    ++(lst->size);
}

//Insere um item no final da lista
void insertRear(LIST* lst, ITEM i){
    NODE* newNode = createNode(newNode, i);

    if(lst->head == NULL){
        lst->head = newNode;
        lst->tail = newNode;
    }else{
        newNode->prev = lst->tail;
        lst->tail->next = newNode;
        lst->tail = newNode;
    }
    ++(lst->size);
}

//Insere um item em uma posição da lista
void insertInPosition(LIST* lst, ITEM i, int position){
    if((position > lst->size) || (position < 1)){
        printf("Error in insertInPosition, ivalid position!!\n");
        exit(-1);
    }

    if(position == 1){
        insertFront(lst, i);
    }else{
        NODE* newNode = createNode(newNode, i);
        NODE* aux = lst->head;
        int count;

        for(count = 1; count < (position - 1); count++){
            aux = aux->next;
        }
        newNode->next = aux->next;
        newNode->prev = aux;
        aux->next->prev = newNode;
        aux->next = newNode;
        ++(lst->size);
    }
}

//Insere um item depois de uma posição da lista
void insertAfterPosition(LIST* lst, ITEM i, int position){
    if((position > lst->size) || (position < 1)){
        printf("Error in insertAfterPosition, invalid position!!\n");
        exit(-1);
    }
    if(position == lst->size){
        insertRear(lst, i);
    }else{
        NODE* newNode = createNode(newNode, i);
        NODE* aux = lst->head;
        int count;
        for(count = 1; count < position; count++){
            aux = aux->next;
        }
        newNode->next = aux->next;
        newNode->prev = aux;
        aux->next->prev = newNode;
        aux->next = newNode;
        ++(lst->size);
    }
}

//Remove um item do inicio da lista
ITEM deletFront(LIST* lst){
    if(isEmpty(lst)){
        printf("Error in deletFront, list is empty!!\n");
        exit(-1);
    }
    ITEM tempItem = lst->head->data;
    NODE* aux = lst->head;
    if(lst->head == lst->tail){
        lst->head = NULL;
        lst->tail = NULL;
        free(aux);
        --(lst->size);
        return tempItem;
    }
    lst->head = lst->head->next;
    lst->head->prev = NULL;
    free(aux);
    --(lst->size);
    return tempItem;
}

//Remove um item do final da lista
ITEM deletRear(LIST* lst){
    if(isEmpty(lst)){
        printf("Error in deletRear, list is empty!!\n");
        exit(-1);
    }
    ITEM tempItem = lst->tail->data;
    NODE* aux = lst->tail;
    if(lst->head == lst->tail){
        lst->head = NULL;
        lst->tail = NULL;
        --(lst->size);
        free(aux);
        return tempItem;
    }
    lst->tail = lst->tail->prev;
    lst->tail->next = NULL;
    free(aux);
    --(lst->size);
    return tempItem;
}

//Remove um item de uma posição da lista
ITEM deletInPosition(LIST* lst, int position){
    if(isEmpty(lst)){
        printf("Error in deletInPosition, list is empty!!\n");
        exit(-1);
    }
    if((position > lst->size) || (position < 1)){
        printf("Error in deletInPosition, invalid position!!\n");
        exit(-1);
    }
    if(position == 1){
        return deletFront(lst);
    }else if(position == lst->size){
        return deletRear(lst);
    }
    int count;
    NODE* aux = lst->head;
    ITEM tempItem;
    for(count = 1; count < position; count++){
        aux = aux->next;
    }
    tempItem = aux->data;
    aux->prev->next = aux->next;
    aux->next->prev = aux->prev;
    free(aux);
    --(lst->size);
    return tempItem;
}

//Remove o item passado por parametro da lista
ITEM deletItem(LIST* lst, ITEM i){
    switch(i.eType){
        case 1:
            return deletIntValue(lst, i);
        case 2:
            return deletDoubleValue(lst, i);
        case 3:
            return deletStringValue(lst, i);
    }
}

//Remove um item inteiro da lista
ITEM deletIntValue(LIST* lst, ITEM i){
    if(lst->head->data.iValue == i.iValue){
        return deletFront(lst);
    }else if(lst->tail->data.iValue == i.iValue){
        return deletRear(lst);
    }else{
        ITEM tempItem;
        NODE* aux = findIntNode(lst->head, i);

        tempItem = aux->data;
        aux->prev->next = aux->next;
        aux->next->prev = aux->prev;
        free(aux);
        --(lst->size);
        return tempItem;
    }
}

//Encontra um nó com um valor inteiro especifico na lista
NODE* findIntNode(NODE* node, ITEM i){
    if(node->data.iValue == i.iValue){
        return node;
    }
    if(node->next == NULL){
        printf("Error in findIntNode, item not fount!!\n");
        exit(-1);
    }
    return findIntNode(node->next, i);
}

//Remove um item double da lista
ITEM deletDoubleValue(LIST* lst, ITEM i){
    if(lst->head->data.dValue == i.dValue){
        return deletFront(lst);
    }else if(lst->tail->data.dValue == i.dValue){
        return deletRear(lst);
    }else{
        ITEM tempItem;
        NODE* aux = findDoubleNode(lst->head, i);

        tempItem = aux->data;
        aux->prev->next = aux->next;
        aux->next->prev = aux->prev;
        free(aux);
        --(lst->size);
        return tempItem;
    }
}

//Encontra um nó com um valor double especifico na lista
NODE* findDoubleNode(NODE* node, ITEM i){
    if(node->data.dValue == i.dValue){
        return node;
    }
    if(node->next == NULL){
        printf("Error in findDoubleNode, item not fount!!\n");
        exit(-1);
    }
    return findDoubleNode(node->next, i);
}

//Remove um item string da lista
ITEM deletStringValue(LIST* lst, ITEM i){
    if(lst->head->data.sValue == i.sValue){
        return deletFront(lst);
    }else if(lst->tail->data.sValue == i.sValue){
        return deletRear(lst);
    }else{
        ITEM tempItem;
        NODE* aux = findStringNode(lst->head, i);

        tempItem = aux->data;
        aux->prev->next = aux->next;
        aux->next->prev = aux->prev;
        free(aux);
        --(lst->size);
        return tempItem;
    }
}

//Encontra um nó com um valor string especifico na lista
NODE* findStringNode(NODE* node, ITEM i){
    if(node->data.sValue == i.sValue){
        return node;
    }
    if(node->next == NULL){
        printf("Error in findStringNode, item not fount!!\n");
        exit(-1);
    }
    return findStringNode(node->next, i);
}

//Imprime a lista
void printList(LIST* lst){
    if(isEmpty(lst)){
        printf("Error in printList, list is empty!!\n");
        exit(-1);
    }
    printNode(lst->head);
}

//Imprime o conteudo de cada nó da lista recursivamente
void printNode(NODE* node){
    if(node == NULL){
        return;
    }
    printItem(node->data);
    printNode(node->next);
}
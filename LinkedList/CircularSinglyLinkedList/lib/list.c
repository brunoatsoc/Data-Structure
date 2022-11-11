#include <stdio.h>
#include <stdlib.h>
#include "list.h"

//Inicializa a lista
void initializeList(LIST* lst){
    lst->size = 0;
    lst->tail = NULL;
}

//Cria um nó para a lista
NODE* createNode(NODE* node, ITEM i){
    node = (NODE*)malloc(sizeof(NODE));
    if(node == NULL){
        printf("Error in createNode, memory could not be allocated!!\n");
        exit(-1);
    }
    node->data = i;
    node->next = NULL;
    return node;
}

//Vareifica se a lista está vazia
int isEmpty(LIST* lst){
    if(lst->tail == NULL){
        return TRUE;
    }
    return FALSE;
}

//Insere um item no começo da lista
void insertFront(LIST* lst, ITEM i){
    NODE* newNode = createNode(newNode, i);

    if(lst->tail == NULL){
        lst->tail = newNode;
        lst->tail->next = newNode;
    }else{
        newNode->next = lst->tail->next;
        lst->tail->next = newNode;
    }
    ++(lst->size);
}

//Insere um item no final da lista
void insertRear(LIST* lst, ITEM i){
    NODE* newNode = createNode(newNode, i);

    if(lst->tail == NULL){
        lst->tail = newNode;
        lst->tail->next = newNode;
    }else{
        newNode->next = lst->tail->next;
        lst->tail->next = newNode;
        lst->tail = newNode;
    }
    ++(lst->size);
}

//Imprime a lista
void printList(LIST* lst){
    if(isEmpty(lst)){
        printf("Error in printList, list is empty!!\n");
        exit(-1);
    }
    NODE* first = lst->tail->next;
    NODE* aux = lst->tail->next;

    do{
        printItem(aux->data);
        aux = aux->next;
    }while(aux != first);
}

//Insere em uma posição especifica da lista
void insertInPosition(LIST* lst, ITEM i, int position){
    if((position > lst->size) || (position < 1)){
        printf("Error in insertInPosition, invalid position!!\n");
        exit(-1);
    }
    if(position == 1){
        insertFront(lst, i);
        return;
    }else{
        NODE* newNode = createNode(newNode, i);
        NODE* aux = lst->tail->next;
        int count;

        for(count = 1; count < position - 1; count++){
            aux = aux->next;
        }
        newNode->next = aux->next;
        aux->next = newNode;
        ++(lst->size);
    }
}

//Remove um item do começo da lista
ITEM removeFront(LIST* lst){
    if(isEmpty(lst)){
        printf("Error in removeFront, list is empty!!\n");
        exit(-1);
    }
    NODE* aux = lst->tail->next;
    ITEM auxItem = lst->tail->next->data;

    if(aux == lst->tail){
        lst->tail = NULL;
        free(aux);
        --(lst->size);
        return auxItem;
    }

    lst->tail->next = aux->next;
    free(aux);
    --(lst->size);
    return auxItem;
}

//Remove um item do final da lista
ITEM removeRear(LIST* lst){
    if(isEmpty(lst)){
        printf("Error in removeRear, list is empty!!\n");
        exit(-1);
    }
    NODE* aux = lst->tail;
    ITEM auxItem = lst->tail->data;

    if(aux == aux->next){
        lst->tail = NULL;
        free(aux);
        --(lst->size);
        return auxItem;
    }else{
        NODE* temp = lst->tail->next;

        while(temp->next != lst->tail){
            temp = temp->next;
        }

        temp->next = aux->next;
        lst->tail = temp;
        free(aux);
        --(lst->size);
        return auxItem;
    }
}

//Remove um item de uma posição especifica da lista
ITEM removeInPosition(LIST* lst, int position){
    if(isEmpty(lst)){
        printf("Error in removeInPosition, list is empty!!\n");
        exit(-1);
    }
    if((position > lst->size) || (position < 1)){
        printf("Error in removeInPosition, invalid position!!\n");
        exit(-1);
    }
    if(position == 1){
        return removeFront(lst);
    }else if(position == lst->size){
        return removeRear(lst);
    }else{
        NODE* aux = lst->tail->next;
        NODE* temp;
        ITEM auxItem;
        int count;

        for(count = 1; count < position - 1; count++){
            aux = aux->next;
        }

        temp = aux->next;
        aux->next = temp->next;
        free(temp);
        --(lst->size);
        return auxItem;
    }
}

//Remove um item especifico da lista
ITEM removeItem(LIST* lst, ITEM i){
    if(isEmpty(lst)){
        printf("Error in removeItem, list is empty!!\n");
        exit(-1);
    }

    switch(i.eType){
        case IS_INT:
            return removeInt(lst, i);
        case IS_DOUBLE:
            return removeDouble(lst, i);
        case IS_STRING:
            return removeString(lst, i);
    }
}

//Remove um item do tipo inteiro
ITEM removeInt(LIST* lst, ITEM i){
    if(lst->tail->next->data.iValue == i.iValue){
        return removeFront(lst);
    }else if(lst->tail->data.iValue == i.iValue){
        return removeRear(lst);
    }else{
        return removeInPosition(lst, findInt(lst->tail->next, lst->tail, i, 0));
    }
}

//Procura o item do tipo int na lista e retorna a posição dele
int findInt(NODE* node, NODE* tail, ITEM i, int count){
    if(node == tail){
        printf("Error, item not found!!\n");
        exit(-1);
    }
    if(node->data.iValue == i.iValue){
        return 1;
    }
    return 1 + findInt(node->next, tail, i, count++);
}

//Remove um item do tipo double
ITEM removeDouble(LIST* lst, ITEM i){
    if(lst->tail->next->data.dValue == i.dValue){
        return removeFront(lst);
    }else if(lst->tail->data.dValue == i.dValue){
        return removeRear(lst);
    }else{
        return removeInPosition(lst, findDouble(lst->tail->next, lst->tail, i, 0));
    }
}

//Procura um item do tipo double na lista e retorna a posição dele
int findDouble(NODE* node, NODE* tail, ITEM i, int count){
    if(node == tail){
        printf("Error, item not found!!\n");
        exit(-1);
    }
    if(node->data.dValue == i.dValue){
        return 1;
    }
    return 1 + findDouble(node->next, tail, i, count++);
}

//Remove um item do tipo char/string
ITEM removeString(LIST* lst, ITEM i){
    if(lst->tail->next->data.sValue == i.sValue){
        return removeFront(lst);
    }else if(lst->tail->data.sValue == i.sValue){
        return removeRear(lst);
    }else{
        return removeInPosition(lst, findString(lst->tail->next, lst->tail, i, 0));
    }
}

//Procura um item do tipo char/string na lista e retorna a posição dele
int findString(NODE* node, NODE* tail, ITEM i, int count){
    if(node == tail){
        printf("Error, item not found!!\n");
        exit(-1);
    }
    if(node->data.sValue == i.sValue){
        return 1;
    }
    return 1 + findString(node->next, tail, i, count++);
}
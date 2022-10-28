#include <stdio.h>
#include  <stdlib.h>
#include "list.h"

//Inicializa lista
void initializeList(LIST* lst){
    lst->head = NULL;
    lst->size = 0;
}

//Insere um elemento no inicio da lista
void insertFront(LIST* lst, ITEM i){
    NODE* newNode = (NODE*)malloc(sizeof(NODE));

    if(newNode == NULL){
        printf("Error in insertFront, could not allocate memory!!\n");
        exit(-1);
    }

    newNode->data = i;
    newNode->next = lst->head;

    if(lst->head == NULL){
        lst->head = newNode;
    }else{
        lst->head = newNode;
    }
    ++(lst->size);
}

//Insere um elemento no final
void insertRear(LIST* lst, ITEM i){
    NODE* newNode = (NODE*)malloc(sizeof(NODE));
    NODE* aux = lst->head;

    if(newNode == NULL){
        printf("Error insertRear, could not allocate memory!!\n");
        exit(-1);
    }

    newNode->data = i;
    newNode->next = NULL;

    if(lst->head == NULL){
        lst->head = newNode;
    }else{
        while(aux->next != NULL){
            aux = aux->next;
        }
        aux->next = newNode;
    }
    ++(lst->size);
}

//Insere um item depois da posição position
void insertAfterPosition(LIST* lst, ITEM i, int position){
    if(validPosition(lst, position)){
        printf("Error in insertAfterPosition, invalid position!!\n");
        exit(-1);
    }

    int count;
    NODE* aux = lst->head;
    NODE* newNode = (NODE*)malloc(sizeof(NODE));

    if(newNode == NULL){
        printf("Error in insertAfterPosition, could not allocate memory!!\n");
    }

    for(count = 1; count < position; count++){
        aux = aux->next;
    }
    newNode->data = i;
    newNode->next = aux->next;
    aux->next = newNode;
    ++(lst->size);
}

//Imprime a lista completa
int printList(LIST* lst){
    if(isEmpty(lst)){
        printf("Error in printList, list is empty!!\n");
        return -1;
    }
    printNode(lst->head);//Chama função auxiliar para impimir a lista recursivamente
    return 2;
}

//Função auxiliar para imprimir a lista recursivamente
void printNode(NODE* node){
    if(node == NULL){
        return;
    }else{
        printItem(node->data);
        printNode(node->next);
    }
}

//Verifica se a lista está vazia
int isEmpty(LIST* lst){
    if(lst->head == NULL){
        return TRUE;
    }
    return FALSE;
}

//Remove do inicio da lista
ITEM removeFront(LIST* lst){
    if(isEmpty(lst)){
        printf("Error in removeFront, list is empty!!\n");
        exit(-1);
    }
    NODE* aux;
    ITEM i = lst->head->data;

    aux = lst->head;
    lst->head = lst->head->next;
    free(aux);
    --(lst->size);
    return i;
}

//Remove do fim da lista
ITEM removeRear(LIST* lst){
    if(isEmpty(lst)){
        printf("Error in removeRear, list is empty!!\n");
        exit(-1);
    }
    NODE* aux = lst->head;
    NODE* prevNode;

    while(aux->next != NULL){
        prevNode = aux;
        aux = aux->next;
    }

    ITEM i = aux->data;

    if(aux == lst->head){
        lst->head = NULL;
    }else{
        prevNode->next = NULL;
    }
    free(aux);
    --(lst->size);
    return i;
}

//Remove um item de uma posição especifica
ITEM removeInPosition(LIST* lst, int position){
    if(isEmpty(lst)){
        printf("Error in removeInPosition, list is empty!!\n");
        exit(-1);
    }
    if(validPosition(lst, position)){
        printf("Error in removeInPosition, invalid position!!\n");
        exit(-1);
    }
    int count;
    NODE* temp = lst->head;
    NODE* nextNode;
    ITEM i;

    if(position == 1){
        i = removeFront(lst);
    }else{
        for(count = 1; count < (position - 1); count++){
            temp = temp->next;
        }
        nextNode = temp->next;
        i = nextNode->data;
        temp->next = nextNode->next;
        free(nextNode);
    }
    --(lst->size);
    return i;
}

//Valida a posição de um item na lista
int validPosition(LIST* lst, int position){
    if((position > lst->size) || (position < 1)){
        return TRUE;
    }
    return FALSE;
}
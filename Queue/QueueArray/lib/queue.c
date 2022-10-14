#include <stdio.h>
#include <stdlib.h>
#include "queue.h"

//Inicializa a fila
void initializeQueue(QUEUE* pq){
    pq->front = -1;
    pq->rear = -1;
    pq->size = 0;
}

//Incere no final da fila
void enqueue(QUEUE* pq, ITEM item){
    if(pq->size == SIZE){
        printf("Queue is full!!\n");
        exit(-1);
    }

    if(pq->rear == SIZE - 1){
        pq->rear = -1;
    }

    ++(pq->size);
    pq->item[++(pq->rear)] = item;
}

//Retira do começo da fila
ITEM dequeue(QUEUE* pq){
    if(empty(pq)){
        printf("Queue is empty!!\n");
        exit(-1);
    }

    if(pq->front == SIZE - 1){
        pq->front = -1;
    }

    ITEM temp = pq->item[++(pq->front)];

    --(pq->size);
    return temp;
}

//Verifica se a fila está vazia
int empty(QUEUE* pq){
    if(pq->size == 0){
        return TRUE;
    }else{
        return FALSE;
    }
}
#ifndef QUEUE_H

#define QUEUE_H

#include "item.h"

#define SIZE 5
#define TRUE 1
#define FALSE 0

typedef struct Queue{
    ITEM item[SIZE];
    int front, rear, size;
}QUEUE;

void initializeQueue(QUEUE* pq);
void enqueue(QUEUE* pq, ITEM item);
ITEM dequeue(QUEUE* pq);
int empty(QUEUE* pq);

#endif
#include <stdio.h>
#include <stdlib.h>
#include "lib/queue.h"

int main(void){
    QUEUE q;
    ITEM i;

    initializeQueue(&q);

    i.eType = IS_INT;
    i.iValue = 10;
    enqueue(&q, i);
    printItem(q.item[q.front]);

    i.eType = IS_DOUBLE;
    i.dValue = 25.897;
    enqueue(&q, i);
    printItem(q.item[q.front]);
    
    i.eType = IS_STRING;
    i.sValue = "Bruno Santos Costa";
    enqueue(&q, i);
    printItem(q.item[q.front]);

    i.eType = IS_INT;
    i.iValue = 12345;
    enqueue(&q, i);
    printItem(q.item[q.front]);

    printItem(dequeue(&q));
    printItem(dequeue(&q));
    printItem(dequeue(&q));
    printItem(dequeue(&q));

    return 0;
}
#include <stdio.h>
#include <stdlib.h>
#include "lib/list.h"

int main(void){
    LIST l;
    ITEM i;

    initializeList(&l);

    printf("%d\n", isEmpty(&l));

    i.eType = IS_INT;
    i.iValue = 10;
    insertFront(&l, i);

    i.eType = IS_INT;
    i.iValue = 2;
    insertFront(&l, i);

    i.eType = IS_INT;
    i.iValue = 5;
    insertFront(&l, i);

    printList(&l);

    //printItem(removeInPosition(&l, 3));
    removeInPosition(&l, 1);

    printList(&l);

    printf("%d\n", isEmpty(&l));

    return 0;
}
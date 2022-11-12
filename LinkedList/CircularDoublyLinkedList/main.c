#include <stdio.h>
#include <stdlib.h>
#include "lib/list.h"

int main(void){
    LIST l;
    ITEM i;

    initializeList(&l);

    i.eType = IS_INT;
    i.iValue = 25;
    insertFront(&l, i);

    i.eType = IS_INT;
    i.iValue = 12;
    insertFront(&l, i);

    i.eType = IS_INT;
    i.iValue = 900;
    insertRear(&l, i);

    i.eType = IS_INT;
    i.iValue = 100;
    insertRear(&l, i);

    /*removeFront(&l);
    removeFront(&l);
    removeFront(&l);
    removeFront(&l);*/

    /*removeRear(&l);
    removeRear(&l);
    removeRear(&l);
    removeRear(&l);*/

    //removeInPosition(&l, 2);

    i.eType = IS_INT;
    i.iValue = 12;
    removeItem(&l, i);

    printList(&l);

    return 0;
}
#include <stdio.h>
#include "lib/list.h"

int main(void){
    LIST l;
    ITEM i;

    initializeList(&l);

    i.eType = IS_INT;
    i.iValue = 100;
    insertFront(&l, i);

    i.eType = IS_INT;
    i.iValue = 50;
    insertFront(&l, i);

    i.eType = IS_INT;
    i.iValue = 1234;
    insertFront(&l, i);

    i.eType = IS_INT;
    i.iValue = 9000;
    insertFront(&l, i);

    i.eType = IS_INT;
    i.iValue = 22;
    insertRear(&l, i);

    i.eType = IS_INT;
    i.iValue = 2022;
    insertRear(&l, i);

    i.eType = IS_INT;
    i.iValue = 7777;
    insertInPosition(&l, i, 6);

    i.eType = IS_INT;
    i.iValue = 11111;
    insertInPosition(&l, i, 2);

    //printList(&l);

    /*removeFront(&l);
    removeFront(&l);
    removeFront(&l);
    removeFront(&l);
    removeFront(&l);
    removeFront(&l);
    removeFront(&l);
    removeFront(&l);*/

    /*removeRear(&l);
    removeRear(&l);
    removeRear(&l);
    removeRear(&l);
    removeRear(&l);
    removeRear(&l);
    removeRear(&l);
    removeRear(&l);*/

    //removeInPosition(&l, 5);

    i.eType = IS_INT;
    i.iValue = 11111;
    removeItem(&l, i);

    printList(&l);

    return 0;
}
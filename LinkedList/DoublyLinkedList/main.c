#include <stdio.h>
#include "lib/list.h"

int main(void){
    LIST l;
    ITEM i;

    initializeList(&l);

    i.eType = IS_INT;
    i.iValue = 100;
    insertRear(&l, i);

    i.eType = IS_INT;
    i.iValue = 50;
    insertRear(&l, i);

    i.eType = IS_INT;
    i.iValue = 123;
    insertRear(&l, i);

    i.eType = IS_INT;
    i.iValue = 10;
    insertRear(&l, i);

    i.eType = IS_INT;
    i.iValue = 900;
    insertRear(&l, i);

    i.eType = IS_DOUBLE;
    i.dValue = 98.76;
    insertRear(&l, i);

    i.eType = IS_STRING;
    i.sValue = "Bruno Santos Costa";
    insertInPosition(&l, i, 1);

    i.eType = IS_INT;
    i.iValue = 2000;
    insertAfterPosition(&l, i, 7);

    printList(&l);

    deletInPosition(&l, 5);

    i.eType = IS_INT;
    i.iValue = 2000;
    deletItem(&l, i);

    i.eType = IS_DOUBLE;
    i.dValue = 98.76;
    deletItem(&l, i);

    i.eType = IS_STRING;
    i.sValue = "Bruno Santos Costa";
    deletItem(&l, i);

    printList(&l);

    return 0;
}
#include <stdio.h>
#include <stdlib.h>
#include "lib/list.h"

int main(void){
    LIST l;
    ITEM i;

    initializeList(&l);

    i.eType = IS_INT;
    i.iValue = 192;
    insertFront(&l, i);

    i.eType = IS_DOUBLE;
    i.dValue = 12.34;
    insertFront(&l, i);

    i.eType = IS_STRING;
    i.sValue = "Bruno Santos Costa";
    insertFront(&l, i);

    i.eType = IS_STRING;
    i.sValue = "OI OI OI";
    insertAfterPosition(&l, i, 3);

    printList(&l);

    i.eType = IS_STRING;
    i.sValue = "Bruno Santos Costa";
    removeItem(&l, i);

    printList(&l);

    return 0;
}
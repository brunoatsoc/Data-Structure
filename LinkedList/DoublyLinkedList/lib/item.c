#include <stdio.h>
#include "item.h"

void printItem(ITEM i){
    switch(i.eType){
        case 1:
            printf("%d\n", i.iValue);
            break;
        case 2:
            printf("%lf\n", i.dValue);
            break;
        case 3:
            printf("%s\n", i.sValue);
    }
}
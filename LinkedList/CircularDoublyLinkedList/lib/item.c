#include <stdio.h>
#include "item.h"

//Imprime um item do tipo ITE(int, double, char/string)
void printItem(ITEM i){
    switch(i.eType){
        case IS_INT:
            printf("%d\n", i.iValue);
            break;
        case IS_DOUBLE:
            printf("%lf\n", i.dValue);
            break;
        case IS_STRING:
            printf("%s\n", i.sValue);
    }
}
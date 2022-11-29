#include <stdio.h>
#include "item.h"

//Imprime um elemento da fila
void printItem(ITEM item){
    switch(item.eType){
        case IS_INT:
            printf("%d\n", item.iValue);
            break;
        case IS_DOUBLE:
            printf("%lf\n", item.dValue);
            break;
        case IS_STRING:
            printf("%s\n", item.sValue);
    }
}
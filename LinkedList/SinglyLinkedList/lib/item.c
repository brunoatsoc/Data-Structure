#include <stdio.h>
#include "item.h"

//Imprime um elemento da lista(int, double ou char)
void printItem(ITEM item){
    switch(item.eType){
        case 1:
            printf("%d\n", item.iValue);
            break;
        case 2:
            printf("%lf\n", item.dValue);
            break;
        case 3:
            printf("%s\n", item.sValue);
    }
}
#include <stdio.h>
#include "stackItem.h"

void print_stack_item(STACK_ITEM item){
    switch(item.etype){
        case IS_INT:
            printf("%d\n", item.ivalue);
            break;
        case IS_DOUBLE:
            printf("%lf\n", item.dvalue);
            break;
        case IS_STRING:
            printf("%s\n", item.svalue);
            break;
    }
}
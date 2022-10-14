#ifndef STACK_ARRAY_H

#define STACK_ARRAY_H

#include "stackItem.h"

#define STACKSIZE 100
#define TRUE 1
#define FALSE 0

typedef struct stack{
    int top;
    STACK_ITEM items[STACKSIZE];
}STACK;

int is_empty(STACK *ps);
STACK_ITEM pop(STACK *ps);
void push(STACK *ps, STACK_ITEM x);
void initialize_stack(STACK *ps);
STACK_ITEM stack_top(STACK *ps);

#endif
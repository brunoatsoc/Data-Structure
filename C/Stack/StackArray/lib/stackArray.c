#include <stdio.h>
#include <stdlib.h>
#include "stackArray.h"
#include "stackItem.h"

//Varifica se a pilha está vazia
int is_empty(STACK *ps){
    if(ps->top == -1){
        return TRUE;
    }
    return FALSE;
}

//Remove da pilha
STACK_ITEM pop(STACK *ps){
    if(is_empty(ps)){
        printf("Stack Undeflow\n");
        exit(1);
    }
    return ps->items[ps->top--];
}

//Incere na pilha
void push(STACK *ps, STACK_ITEM x){
    if(ps->top == STACKSIZE - 1){
        printf("Stack Overflow\n");
        exit(-1);
    }
    ps->items[++(ps->top)] = x;
}

//Inicializa a pilha
void initialize_stack(STACK *ps){
    ps->top = -1;
}

//Obtem o elemento do topo da pilha
STACK_ITEM stack_top(STACK *ps){
    STACK_ITEM temp = pop(ps);
    push(ps, temp);

    return temp;
}
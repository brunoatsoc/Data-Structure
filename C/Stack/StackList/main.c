#include <stdio.h>
#include "lib/stack.h"

int main(void){
    Node s;

    initializeStack(&s);
    printf("%d\n", empty(&s));
    push(&s, 10);
    printf("%d\n", empty(&s));
    push(&s, 14);
    push(&s, 98);
    push(&s, 45);
    push(&s, 1);
    push(&s, 100);
    push(&s, 234);
    push(&s, 3);
    printf("%d\n", stackTop(&s));
    pop(&s);
    printf("%d\n", stackTop(&s));

    return 0;
}
#include <stdio.h>

int multiplication(int x, int y);

int main(void){
    printf("%d\n", multiplication(2000, 1000));

    return 0;
}

int multiplication(int x, int y){
    if(y == 0 || x == 0){
        return 0;
    }

    if(x > y){
        return x + multiplication(x, y - 1);
    }

    return multiplication(y, x);
}
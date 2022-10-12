#include <stdio.h>

void factorial(long long unsigned int *n);

int main(void){
    long long unsigned int n = 10;

    factorial(&n);

    printf("%llu\n", n);

    return 0;
}

void factorial(long long unsigned int *n){
    if(*n > 1){
        long long unsigned int x = *n - 1;
        factorial(&x);
        *n = *n * x;
    }else if (*n == 1 || *n == 0){
        *n = 1;
    }
}
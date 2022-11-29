#include <stdio.h>

int fibonacci(int n, int x, int y);

int main(void){
    int n = 10; // Termo que a pessoa quer ver
    int x = 1;  // Primeiro termo
    int y = 1;  // Segundo termo

    printf("%d\n", fibonacci(n, x, y)); // Imprime o resultado

    return 0;
}

//Aqui n é o enesimo termo, x o primeiro termo e y o segundo
int fibonacci(int n, int x, int y){
    if(n == 1){
        return x;
    }else if(n == 2){
        return y;
    }
    //Subtrai o enesimo termo, cloca y o termo anterior e coloca x+y como o proximo termo
    return fibonacci(n - 1, y, x + y);
}
#include <stdio.h>
#include <string.h>

#define TRUE 1
#define FALSE 0

int ehPalindromo(char palavra[6], int fim, int inicio);

int main(void){
    char palavra[6] = "aabaa";
    int tamanho = strlen(palavra), aux = 0;

    if(ehPalindromo(palavra, tamanho - 1, aux)){
        printf("É palindromo\n");
    }else{
        printf("Não é palindromo\n");
    }

    return 0;
}

//Função para descobrir se uma string é um palindromo
int ehPalindromo(char palavra[6], int fim, int inicio){
    if(inicio == fim){ // Condição de parada(quado chegar no meio da string)
        return TRUE;
    }else if(palavra[inicio] == palavra[fim]){// Chamadas recursivas(vai caminhando pelos extremos da string)
        return ehPalindromo(palavra, --fim, ++inicio);
    }

    return FALSE; // Retorna zero se não tiver nenhuma letra igual nos extremos
}
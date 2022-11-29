#ifndef ITEM_H

#define ITEM_H

#define IS_INT 1
#define IS_DOUBLE 2
#define IS_STRING 3

//Estrutura para o tipo ITEM(int, double, char/string)
typedef struct item{
    int eType;

    union{
        int iValue;
        double dValue;
        char* sValue;
    };
}ITEM;

void printItem(ITEM i);

#endif
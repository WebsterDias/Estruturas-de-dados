#include <stdlib.h>
#include <stdio.h>

void resolveSCM(int m[8][7], int X, int Y, char x[7], char y[6]);
int max(int m[8][7], int X, int Y);
void encontraSCM(char *sub, int X, int Y, char x[7], char y[6]);
void imprimeM(int m[8][7]);
int e = 4;

int main(){

    char x[7] = {'a','b','c','b','d','a','b'};
    char y[6] = {'b','d','c','a','b','a'};
    int m[8][7];

    printf("\n -----SCM - Subcadeia Comum Maxima-----\n");

    for(int i=0; i<8; i++){
        for(int j=0; j<7; j++){
            m[i][j] = 0;
        }
    }

    int X = 1;
    int Y = 1;
    resolveSCM(m,X,Y,x,y);

    char sub[e];
    imprimeM(m);
    printf("\n\n Subcadeia de tamanho: %d: ",m[7][6]);

    X = 6;
    Y = 5;
    encontraSCM(sub,X,Y,x,y);

    for(int i=0; i<m[7][6]; i++){
        printf("%c ",sub[i]);
    }
    printf("\n");

return 0;
}

void resolveSCM(int m[8][7], int X, int Y, char x[7], char y[6]){

    int r = 0;
    if(X == 8){
        r = 1;
    }

    while(r == 0 && Y < 7){
        if(x[X-1] == y[Y-1]){
            m[X][Y] = m[X-1][Y-1] + 1;
        }else{
            m[X][Y] = max(m,X,Y);
        }
        Y++;
    }
    if(X<8){
        Y = 1;
        X++;
        resolveSCM(m,X,Y,x,y);
    }
}

int max(int m[8][7], int X, int Y){
    int max;
    int cima = m[X-1][Y];
    int atras = m[X][Y-1];

    if(cima > atras){
        max = cima;
    }else{
        max = atras;
    }
return max;
}

void encontraSCM(char *sub, int X, int Y, char x[7], char y[6]){

    if(e >= 0){
        if(x[X] == y[Y]){
            e--;
            sub[e] = y[Y];
            Y--;
            X--;
            encontraSCM(sub,X,Y,x,y);
        }else{
            Y--;
            encontraSCM(sub,X,Y,x,y);
        }
    }
}

void imprimeM(int m[8][7]){
    for(int i=0; i<8; i++){
        for(int j=0; j<7; j++){
            printf("\t%d ",m[i][j]);
        }
        printf("\n");
    }
}

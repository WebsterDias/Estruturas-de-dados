#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#define nLetras 4

char letras[nLetras] = {'a','b','c','d'};
int desLin = 0;
int desCol = 0;
int c = 0;

int resolveQuadradoR(char m[4][4], int c, int linhaAtual, int colunaAtual, int quadradoLin, int quadradoCol);

bool verLinha(char m[4][4], int linhaAtual, char letra);

bool verColuna(char m[4][4], int colunaAtual, char letra);

void imprimeQuadrado(char m[4][4]);


int main() {

    //criando a matriz e atribuindo "v" como 'vazio'
    char m[4][4] = {'b','v','v','d','v','d','b','v','v','c','d','v','d','v','v','c'};
    //Substituir nas chaves {} -> 'b','v','v','d','v','d','b','v','v','c','d','v','d','v','v','c' para CONSTRUIR um quadrado latino!

    imprimeQuadrado(m);
    printf("\n\nPosicao vazia:\n");
    resolveQuadradoR(m,c,0,0,3,3);

    imprimeQuadrado(m);

return 0;
}

int resolveQuadradoR(char m[4][4], int c, int linhaAtual, int colunaAtual, int quadradoLin, int quadradoCol){

    int achou = 0;

        if(m[linhaAtual][colunaAtual] == 'v'){

            printf("\t(%d,%d)\n",linhaAtual,colunaAtual);

            if(linhaAtual == quadradoLin && colunaAtual == quadradoCol){
                achou = 1;
            }
            /**/
            while(achou == 0 && c < nLetras){
                if(verLinha(m,linhaAtual,letras[c]) == true)
                    if(verColuna(m,colunaAtual,letras[c]) == true)
                        m[linhaAtual][colunaAtual] = letras[c];
                c++;
            }
        }else{
            while(colunaAtual < 3){
                colunaAtual++;
                resolveQuadradoR(m,c,linhaAtual,colunaAtual,quadradoLin,quadradoCol);
            }
            if(linhaAtual < 3){
                colunaAtual = 0;
                linhaAtual++;
                resolveQuadradoR(m,c,linhaAtual,colunaAtual,quadradoLin,quadradoCol);
            }

        }

    return achou;
}

bool verLinha(char m[4][4], int linhaAtual, char letra){

    for(int n = 0; n<4; n++){
        if(m[linhaAtual][n] == letra){
            return false;
        }
    }
    return true;
}

bool verColuna(char m[4][4], int colunaAtual, char letra){

    for(int n = 0; n<4; n++){
        if(m[n][colunaAtual] == letra){
            return false;
        }
    }
    return true;
}

void imprimeQuadrado(char m[4][4]){

    for(int i=0; i<4; i++){
        for(int j=0; j<4; j++){
            printf("%c ",m[i][j]);
        }
        printf("\n");
    }

}

#include <stdlib.h>
#include <stdio.h>
#define NUM_MOV 4

int desLin [NUM_MOV] = {0, 1, 0, -1};
int desCol [NUM_MOV] = {1, 0, -1, 0};

//resposta do programa, caso encontre ou não o caminho
int r = 0;

int posValida(int **labirinto, int lin, int col, int labLinhas, int labColunas);
int resolveLabirinto(int **labirinto, int labLinhas, int labColunas);
int resolveLabirintoR(int **labirinto, int lin, int col, int linDest, int colDest, int labLinhas, int labColunas);

int main() {

    int **labirinto;
    int linhas = 5;
    int colunas = 6;

    labirinto = (int **)malloc(linhas * sizeof(int *));

    for(int i=0; i<linhas; i++){
        labirinto[i] = (int *)malloc(colunas * sizeof(int));

        for(int j=0; j<colunas; j++){
            labirinto[i][j] = 0;
        }
    }

    labirinto[0][4] = 1;
    labirinto[1][1] = 1;
    labirinto[1][2] = 1;
    labirinto[2][4] = 1;
    labirinto[3][0] = 1;
    labirinto[3][2] = 1;
    labirinto[3][3] = 1;
    labirinto[3][4] = 1;
    labirinto[3][5] = 1;


    printf(" Labirinto:\n");
    for(int i=0; i<linhas; i++){
        for(int j=0; j<colunas; j++){
            printf("\t%d",labirinto[i][j]);
        }
        printf("\n");
    }

    resolveLabirinto(labirinto, linhas, colunas);
    printf("\n\nEncontrou caminho ? (1 = Sim / 0 = Não) = %d\n\n",r);

return 0;
}

int posValida(int **labirinto, int lin, int col, int labLinhas, int labColunas){

    if(lin >= 0 && lin < labLinhas && col >=0 < labColunas){

        if(labirinto[lin][col] == 0){
            return 1;

        }
    }

    return 0;
}

int resolveLabirinto(int **labirinto, int labLinhas, int labColunas){

    printf("\n\n Caminho Percorrido: ");

    return resolveLabirintoR(labirinto, 0, 0, labLinhas - 1, labColunas - 1, labLinhas, labColunas);

}

int resolveLabirintoR(int **labirinto, int lin, int col, int linDest, int colDest, int labLinhas, int labColunas){

    int achou = 0, k = 0;

    if(posValida(labirinto, lin, col, labLinhas, labColunas)){

        labirinto[lin][col] = 1;

        printf("\n\t(%d, %d) ", lin, col);

            if(lin == linDest && col == colDest){
                printf("\n\t(%d, %d) ", lin, col);
                achou = 1;
                r = 1;
            }

            while (achou == 0 && k <NUM_MOV){
                achou = resolveLabirintoR(labirinto, lin + desLin[k], col + desCol[k], linDest, colDest, labLinhas, labColunas);
                k++;
            }

            labirinto[lin][col] = 0;

    }

    return achou;

}

#include <stdlib.h>
#include <stdio.h>

int W;
int nItens;
int linhasZ;
int colunasZ;
int e = 0;

//-----------------------------------------------------RESOLVER MOCHILA COM MATRIZ------------------------------------------
int resolveMochila(int z[linhasZ][colunasZ], int w[nItens], int c[nItens]);
int resolveMochilaR(int z[linhasZ][colunasZ],  int w[nItens], int c[nItens], int inicioL, int inicioC, int custoTotal);
int max(int z[linhasZ][colunasZ], int k, int d, int w[nItens], int c[nItens]);

//-----------------------------------------------------SELECIONA OS ITENS---------------------------------------------------
void itensSelecionados(int z[linhasZ][colunasZ], int x[nItens], int k, int d, int w[nItens], int c[nItens]);

//---------------------IMPRIMIR---------------------------------------------------------------------------------------------
void imprimeMatrizAuxiliar(int z[linhasZ][colunasZ]);
void imprimeItensS(int x[nItens], int w[nItens], int c[nItens]);


int main() {

    printf("\n Resolucao do problema da Mochila 0-1:\n")    ;
    printf(" Forneca a capacidade maxima da mochila (W): ");
    scanf("%d",&W);

    printf("\n Quantos itens distintos e unicos existem: ");
    scanf("%d",&nItens);

    int w[nItens];
    int c[nItens];

    for(int i=0; i<nItens; i++){
        printf(" Peso (w) do item %d: ",i+1);
        scanf("%d",&w[i]);
        printf(" Custo (c) do item %d: ",i+1);
        scanf("%d",&c[i]);
        printf("\n");
    }

    printf(" Possiveis itens a serem adicionados:");
    for(int i=0; i<nItens; i++){
        printf("\n Item %d - w: %d / c: %d",i+1,w[i],c[i]);
    }
    printf("\n\n");

    linhasZ = nItens+1;
    colunasZ = W+1;
    int z[linhasZ][colunasZ];

    for(int i=0; i<linhasZ; i++){
        for(int j=0; j<colunasZ; j++){
            z[i][j] = 0;
        }
    }

    resolveMochila(z, w, c);

    int x[nItens];
    int k = nItens;
    int d = W;

    itensSelecionados(z, x, k, d, w, c);
    imprimeItensS(x , w, c);

    return 0;
}

int resolveMochila(int z[linhasZ][colunasZ], int w[nItens], int c[nItens]){

    int custoTotal;
    int k = 1;
    int d = 1;

    printf(" Matriz - Programacao Dinamica:\n");
    resolveMochilaR(z, w, c, k, d, custoTotal);
    imprimeMatrizAuxiliar(z);

    printf("\n\n Solucao do problema da Mochila 0-1:");
    custoTotal = z[nItens][W];
    printf("\n Custo Total dos Itens Selecionados: %d ",custoTotal);

}

int resolveMochilaR(int z[linhasZ][colunasZ],  int w[nItens], int c[nItens], int k, int d, int custoTotal){

    int resolvido = 0;

    if(k == linhasZ){
        resolvido = 1;
    }

    while(resolvido == 0 && d<colunasZ){
        if(w[e] > d){
            z[k][d] = z[k-1][d];
        }else{
            z[k][d] = max(z,k,d,w,c);
        }
        d++;
    }
    if(k<linhasZ){
        d = 1;
        k++;
        e++;
        resolveMochilaR(z,w,c,k,d,custoTotal);
    }


    return resolvido;
}

int max(int z[linhasZ][colunasZ], int k, int d, int w[nItens], int c[nItens]){

    int max;
    int cima = z[k-1][d];
    int diagonal = z[k-1][d-w[e]] + c[e];

    if(cima > diagonal){
        max = cima;
    }else{
        max = diagonal;
    }

return max;
}

void itensSelecionados(int z[linhasZ][colunasZ], int x[nItens], int k, int d, int w[nItens], int c[nItens]){

    if(k>0){
        if(z[k][d] == z[k-1][d]){
            x[k-1] = 0;
            itensSelecionados(z,x,k-1,d,w,c);
        }else{
            x[k-1] = 1;
            itensSelecionados(z,x,k-1,d-(w[k]+1),w,c);
        }
    }

}

void imprimeItensS(int x[nItens], int w[nItens], int c[nItens]){

    printf("\n\n Itens Selecionados para a Mochila:\n");
    for(int i=0; i<linhasZ; i++){
        if(x[i] == 1){
            printf(" Item %d - w: %d / c: %d\n",i+1,w[i],c[i]);
        }
    }
}

void imprimeMatrizAuxiliar(int z[linhasZ][colunasZ]){

    for(int i=0; i<linhasZ; i++){
        for(int j=0; j<colunasZ; j++){
            printf("\t%d",z[i][j]);
        }
        printf("\n");
    }
}

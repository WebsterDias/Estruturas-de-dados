#include <stdlib.h>
#include <stdio.h>

int n;

int resolveKadane(int a[n]);
int max(int resposta, int soma);

int main(){

    printf("\n\n Resolucao do problema do Subarranjo Maximo - Kadane:\n");
    printf(" Forneca o tamanho do array(n): ");
    scanf("%d",&n);

    int a[n];
    for(int i=0; i<n; i++){
        printf(" Entre com o %d elemento do array: ",i+1);
        scanf("%d",&a[i]);
    }

    printf("\n Imprimindo o Array Analisado: ");
    for(int i=0; i<n; i++){
        printf("%d ",a[i]);
    }

    resolveKadane(a);
    printf("\n O Valor do Subarranjo Maximo eh: %d", resolveKadane(a));

return 0;
}

int resolveKadane(int a[n]){

    int soma = 0;
    int resposta = 0;

    for(int i=0; i<n; i++){
        soma += a[i];
        resposta = max(resposta,soma);
        if(soma < 0){
            soma = 0;
        }
    }

return resposta;
}

int max(int resposta, int soma){

    int max;

    if(resposta > soma){
        max = resposta;
    }else{
        max = soma;
    }

return max;
}

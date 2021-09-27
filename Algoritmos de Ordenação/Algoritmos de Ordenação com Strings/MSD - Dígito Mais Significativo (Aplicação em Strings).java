/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listex10;

/**
 *
 * @author Webster Dias Wolak
 */
public class Exercício03_MSD {
    
    public static void sort(String[] a, int tF){
        int R = 256;
        int N = a.length;
        int c = 1;
        
        ordenar(a,R,N);
        int [] p = particionar(a,R,N);
        ordenarPorParticao(a,p,c,tF);
    }
    
    public static int[] particionar(String[] a, int R, int N){
        int[] alfabeto = new int[R+1];
        int tamanhoP = 1;
        int q = 0;
        
        for(int i=0; i<N; i++){
            boolean existe = false;
            for(int j=i-1; j>-1; j--){
                if(a[i].charAt(0) == a[j].charAt(0)){
                    existe = true;
                }
            }
            if(existe == false){
                alfabeto[q] = i;
                tamanhoP++;
                q++;
            }
        }
        
        int particoes[] = new int[tamanhoP];
        for (int i = 0; i < particoes.length; i++) {
            particoes[i] = alfabeto[i];
            if(i == (particoes.length -1)){
                particoes[i] = N;
            }
        }
        
        return particoes;
    }
    
    public static void ordenar(String[] a, int R, int N){
        String temp;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if(a[j].charAt(0) < a[j-1].charAt(0)){
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
    }
    
    public static void ordenarPorParticao(String[] a, int[] p, int c, int tF){
        
        for (int i = 0; i < p.length-1; i++) {
            int iteracoes = (p[i+1] - p[i]);
            for(int j = p[i]; j < p[i+1]-1; j++){
                for (int k = iteracoes; k >= 2; k--) {
                    if(a[j].charAt(c) > a[j+1].charAt(c)){
                        troca(a, j);
                    }else if(a[j].charAt(c) == a[j+1].charAt(c)){
                        if(c <= (tF-1)){
                            c++;
                            k++;
                        }
                    }
                }
            }
        }
    }
    
    public static void troca(String[] a, int i){
        String temp = a[i];
        a[i] = a[i+1];
        a[i+1] = temp;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
//        String[] exemplo = {"she","sells","seashells","by","the","sea","shore","the",
//        "shells","she","sells","are","surely","seashells"};
        String[] ex = {"dab","add","cab","fad","fee","bad","dad","bee",
            "fed","bed","ebb","ace"};
        
        // Tamanho fixo
        int tF = 3;
        sort(ex, tF);
        
        for (int i = 0; i < ex.length; i++) {
            System.out.println(ex[i]);
        }
        
    }
    
}

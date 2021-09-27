/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_Funções;

/**
 *
 * @author Webster Dias Wolak
 */
public class Merge {
    
    private static int comp = 0;
    private static int troca = 0;
    
    private static void merge(Comparable[] a,Comparable[] aux,int lo,
            int mid,int hi){
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        
        int i = lo, j = mid+1;
        for(int k = lo; k<=hi; k++){
            comp++;
            if (i > mid){
                a[k] = aux[j++];
            }else if(j > hi){
                a[k] = aux[i++];
            }else if (less(aux[j], aux[i])){
                a[k] = aux[j++];
            }else{
                a[k] = aux[i++];
            }
        }
        troca++;
        imprimeSubV(a,lo,hi);
    }
    
    private static void sort(Comparable[] a, Comparable[] aux, 
        int lo, int hi){
        
        if(hi<=lo) return;
        int mid = lo + (hi-lo) / 2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        merge(a,aux,lo,mid,hi);
        
    }
    
    public static void sort(Comparable[] a){
        
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }
    
    public static void show(Comparable[] a) {
        System.out.println("");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }
    
    private static void imprimeSubV(Comparable[] a, int lo, int hi){
        for (int i = 0; i < a.length; i++) {
            if(lo<=i && i<= hi){
                System.out.print(a[i]+" ");
            }else{
                System.out.print("  ");
            }
         }
        System.out.println("");
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    
    public static void comparacoesEtrocas(){
        System.out.println("Número de comparações: " +comp);
        System.out.println("Número de trocas: "+troca);
    }
    
}

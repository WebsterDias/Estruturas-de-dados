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
public class Merge_Melhoria1 {
    
    private static void merge(Comparable[] a,Comparable[] aux,int lo,
            int mid,int hi){
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        
        int i = lo, j = mid+1;
        for(int k = lo; k<=hi; k++){
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
    
    private static void InsertionSort(Comparable[] a){
        int n = a.length;
        for (int i = 0; i < n; i++){
            for (int j = i; j > 0; j--){
                if(less(a[j],a[j-1])){
                    exch(a,j,j-1);
                }else{
                    break;
                }
            }
            imprimeInsertion(a,i);;
        }
    }
    
    private static void imprimeInsertion(Comparable[] a, int i){
        for (int k = 0; k < a.length; k++) {
            if(k==i){
                System.out.print(a[k]+" | ");
            }else{
                System.out.print(a[k]+" ");
            }
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
    
    public static void sort(Comparable[] a){
        
        Comparable[] aux = new Comparable[a.length];
        if(a.length <= 10){
            System.out.println("Usando Insertion Sort:\nIniciando Ordenação...");
            InsertionSort(a);
        }else{
            System.out.println("Usando Merge Sort:\nIniciando Ordenação...");
            sort(a,aux,0,a.length-1);
        }
    }
    
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }
    
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    
    private static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}

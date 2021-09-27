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
public class Merge_BottomUp {
    
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
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
        troca++;
    }
    
    
    public static void sort(Comparable[] a){ 
        int n = a.length;
        int c = 0;
        int m;
        Comparable aux[] = new Comparable[n];
        
        for (int sz = 1; sz < n; sz += sz) {
            System.out.print("Subarray(s) de tamanho " + sz*2 + ": \n");
            for (int lo = 0; lo < n-sz; lo += sz+sz) {
                m = Math.min(lo+sz+sz-1, n-1);
                c++;
                merge(a,aux,lo,lo+sz-1,m);
                imprimeSubV(a,lo,sz,n,m);
                if(c == n-1){
                    System.out.println(c);
                }
            }
            c = 0;
            System.out.println("");
        }
    }
    
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
    
    private static void imprimeSubV(Comparable[] a, int lo, int sz,int n,int m){
        for (int i = 0; i < n; i++) {
            if(lo<=i && i<= m){
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_Funções;

import edu.princeton.cs.algs4.StdRandom;

/**
 *
 * @author Webster Dias Wolak
 */
public class Quick {
    
    private static int comp = 0;
    private static int troca = 0;
    
    private static int partition(Comparable[] a,int lo,int hi){
        int c = 0;
        int i = lo, j = hi+1;
        while(true){
            
            while(less(a[++i],a[lo])){
                comp++;
                if(i == hi)break;
            }
            while(less(a[lo], a[--j])){
                comp++;
                if(j == lo)break;
            }
            if(i >= j) break;
            exch(a,i,j);
        }
        troca++;
        exch(a,lo,j);
        return j;
    }

    public static void sort(Comparable[] a){
        System.out.println("Embaralhando...");
        StdRandom.shuffle(a);
        show(a);
        System.out.println("\nIniciando a ordenação...");
        sort(a,0,a.length-1);
    }
    
    private static void sort(Comparable[] a,int lo,int hi){
        if(hi <= lo ) return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    
    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
            
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
        imprimeQuick(a,i,j);
    }
    
    private static void imprimeQuick(Comparable[] a,int i,int j){
        for (int k = 0; k < a.length; k++) {
            if(k == i || k == j){
                System.out.print("("+a[k]+")");
            }else{
                System.out.print(" "+ a[k] +" ");
            }
        }
        System.out.println("");
    }

    public static void comparacoesEtrocas(){
        System.out.println("Número de comparações: " +comp);
        System.out.println("Número de trocas: "+troca);
    }
}

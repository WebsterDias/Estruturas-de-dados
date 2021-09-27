/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_Funções;

import Ordenação_Elementar.Insertion;
import edu.princeton.cs.algs4.StdRandom;

/**
 *
 * @author Webster Dias Wolak
 */
public class Quick_Melhoria1 {

    private static int partition(Comparable[] a,int lo,int hi){
        int c = 0;
        int i = lo, j = hi+1;
        while(true){
            
            while(less(a[++i],a[lo])){
                if(i == hi)break;
            }
            while(less(a[lo], a[--j])){
                if(j == lo)break;
            }
            if(i >= j) break;
            exchQ(a,i,j);
        }
        exchQ(a,lo,j);
        return j;
    }

    public static void sort(Comparable[] a){
        if(a.length > 10){
            System.out.println("Usando Quick Sort (tamanho do vetor > 10):");
            System.out.println("Embaralhando...");
            StdRandom.shuffle(a);
            show(a);
            System.out.println("\nIniciando a ordenação...");
            sort(a,0,a.length-1);
        }else{
            System.out.println("Usando Insertion Sort (tamanho do vetor <= 10):");
            InsertionSort(a);
        }
        
    }
    
    private static void sort(Comparable[] a,int lo,int hi){
        if(hi <= lo ) return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    
    private static void InsertionSort(Comparable[] a){
        int n = a.length;
        for (int i = 0; i < n; i++){
            for (int j = i; j > 0; j--){
                if(less(a[j],a[j-1])){
                    exchI(a,j,j-1);
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
    
    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
            
        }
        System.out.println("");
    }
    
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    
    private static void exchI(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    private static void exchQ(Comparable[] a, int i, int j){
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
}

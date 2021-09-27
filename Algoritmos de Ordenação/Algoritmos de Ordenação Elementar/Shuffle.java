/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenação_Elementar;

import edu.princeton.cs.algs4.StdRandom;

/**
 *
 * @author Webster Dias Wolak
 */
public class Shuffle {
    
    public static void sort(Comparable[] a){
        int n = a.length;
        for (int i = 0; i < n; i++){
            int min = i;
            for (int j = i+1; j < n; j++){
                if(less(a[j],a[min])){
                    min = j;
                }
            }
            exch(a,i,min);
        }
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
    }
    
    public static void shuffle(Comparable[] a){
        
        int n = a.length;
        Comparable embaralha[] = new Comparable[n];
        for (int i = 0; i < n; i++) {
            embaralha[i] = StdRandom.uniform();
        }
        
        for (int i = 0; i < n; i++){
            int min = i;
            for (int j = i+1; j < n; j++){
                if(less(embaralha[j],embaralha[min])){
                    min = j;
                }
            }
            exch(embaralha,i,min);
            exch(a,i,min);
        }
    }
    
}

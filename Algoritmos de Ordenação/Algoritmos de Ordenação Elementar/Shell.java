/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenação_Elementar;


/**
 *
 * @author Webster Dias Wolak
 */
public class Shell {
    
    public static void sort(Comparable[] a){
        
        int n = a.length;
        int h = 1;
        
        while(h < n/3){
            h = 3*h+1;
        }
        while(h >= 1){
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a,j,j-h);
                }
            }
            h = h/3;
        }
    }
    
    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
            
        }
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

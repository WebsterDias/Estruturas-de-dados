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
public class Insertion {
    public static void sort(Comparable[] a){
        int n = a.length;
        for (int i = 0; i < n; i++){
            for (int j = i; j > 0; j--){
                if(less(a[j],a[j-1])){
                    exch(a,j,j-1);
                }else{
                    break;
                }
            }
        }
    }
    
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
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

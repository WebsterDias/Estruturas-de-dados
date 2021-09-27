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
public class Quick_Melhoria2 {
    
    private static int partition(Comparable[] a,int lo,int hi){
        
        int i = lo, j = hi+1;
        int median = medianOf3(a,lo,lo+(hi-lo)/2,hi);
        System.out.println("\nAmostras:\n   "+a[lo]+", "+a[lo+(hi-lo)/2]
                +" e "+a[hi]+"\nMediana Verdadeira = "+a[median]);
        exch(a,lo,median);
        while(true){
            
            while(less(a[++i],a[lo])){
                if(i == hi)break;
            }
            
            while(less(a[lo], a[--j])){
                if(j == lo) break;
            }
            
            if(i >= j) break;
            exch(a,i,j);
        
        }
        
        exch(a,lo,j);
        return j;
    }

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }
    
    private static void sort(Comparable[] a,int lo,int hi){
        if(hi <= lo ) return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    
    private static int medianOf3(Comparable[] a, int i, int j, int k) {
        return (less(a[i], a[j]) ?
               (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
               (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
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
}

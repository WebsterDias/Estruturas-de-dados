/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listex10;

import java.util.ArrayList;

/**
 *
 * @author Webster Dias Wolak
 */
public class Exercício02_LSD {

    /**
     * @param args the command line arguments
     */
    
    public static void sort(String[] a, int W){
        int R = 256;
        int N = a.length;
        String temp;
        
        for(int d=W-1; d >= 0; d--){
            for (int i = 0; i < N; i++) {
                for (int j = i; j > 0; j--) {
                    if(a[j].charAt(d) < a[j-1].charAt(d)){
                        temp = a[j];
                        a[j] = a[j-1];
                        a[j-1] = temp;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        String[] ex = {"dab","add","cab","fad","fee","bad","dad","bee",
            "fed","bed","ebb","ace"};
        
        sort(ex,3);
        
        for (int i = 0; i < ex.length; i++) {
            System.out.println(ex[i]);
        }
    }
    
}

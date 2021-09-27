/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listex12;

/**
 *
 * @author Webster Dias Wolak
 */
public class BM {
    private static int R = 256;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String txt = "FINDINAHAYSTACKNEEDLEINA";
        String pat = "NEEDLE";
        int M = pat.length();
        
        int[] right = new int[R];
        for (int c = 0; c < R; c++) {
            right[c] = -1;
        }
        for (int j = 0; j < M; j++) {
            right[pat.charAt(j)] = j;
        }
        
        int f = txt.length();
        int index = search(txt,pat,right);
        
        if(index != f){
            System.out.println("Padrão ENCONTRADO!\n"
                    + "Início do padrão no índice: " + index);
            for (int i = 0; i < f; i++) {
                if(index == i){
                    System.out.print("(" +txt.charAt(i)+ ")");
                }else{
                    System.out.print(txt.charAt(i));
                }
            }
            System.out.println("");
        }else{
            System.out.println("Padrão NÃO encontrado!");
        }
    }
    
    public static int search(String txt, String pat, int[] right){
        int N = txt.length();
        int M = pat.length();
        int skip;
        for (int i = 0; i <= N-M; i += skip) {
            skip = 0;
            for (int j = M-1; j >= 0; j--) {
                if(pat.charAt(j) != txt.charAt(i+j)){
                    skip = Math.max(1, j - right[txt.charAt(i+j)]);
                    break;
                }
            }
            if(skip == 0){
                return i;
            }
        }
        return N;
    }
}

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
public class BruteForce_Melhorado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String txt = "AAAAAAAAAAAAAAAAAAAAAB";
        String pat = "AAAAAB";
        
        int f = txt.length();
        int index = search(pat,txt);
        
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
    
    public static int search(String pat, String txt){
        int i, N = txt.length();
        int j, M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            if(txt.charAt(i) == pat.charAt(j)){
                j++;
            }else{
                i -= j;
                j = 0;
            }
        }
        if(j == M){
            return i - M;
        }else{
            return N;
        }
    }
}

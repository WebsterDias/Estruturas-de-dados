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
public class BruteForce {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String txt = "ABACADABRAC";
        String pat = "ABRA";
        
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
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= N-M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if(txt.charAt(i+j) != pat.charAt(j)){
                    break;
                }
            }
            if(j == M){
                return i;
            }
        }
        return N;
    }
}

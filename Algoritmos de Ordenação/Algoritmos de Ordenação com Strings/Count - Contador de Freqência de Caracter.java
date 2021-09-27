/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listex10;
import java.util.Scanner;
/**
 *
 * @author Webster Dias Wolak
 */
public class Exercício01_Count {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner t = new Scanner(System.in);
        String a = t.nextLine();
        
        int N = a.length();
        int R = 256;
        int count[] = new int[R+1];
        char b[] = new char[N];
        
        for (int i = 0; i < b.length; i++) {
            b[i] = a.charAt(i);
        }
        
        char alfabeto[] = new char[R+1];
        int tamanhoL = 0;
        int q = 0;
        
        for(int i=0; i<N; i++){
            boolean existe = false;
            for(int j=i-1; j>-1; j--){
                if(b[i] == b[j]){
                    existe = true;
                }
            }
            if(existe == false){
                alfabeto[q] = b[i];
                tamanhoL++;
                q++;
            }
        }
        
        int frequencia[] = new int[tamanhoL];
        int acumulado = 0;
        for (int i = 0; i < frequencia.length; i++) {
            frequencia[i] = 0;
        }
        
        for (int i = 0; i < tamanhoL; i++) {
            for(int j=0; j<N; j++){
                if(alfabeto[i] == b[j]){
                    frequencia[i]++;
                }
            }
        }
        
        for (int i = 0; i < frequencia.length; i++) {
            acumulado += frequencia[i];
        }
        
        System.out.print(" Alfabeto: ");
        System.out.println(alfabeto);
        
        System.out.println(" Frequencia:");
        for (int i = 0; i < frequencia.length; i++) {
            System.out.println("    "+alfabeto[i]+" = "+frequencia[i]);
        }
        System.out.println(" Acumulado: "+acumulado);
    }
   
}

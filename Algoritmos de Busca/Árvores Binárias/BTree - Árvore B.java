/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listex09;

/**
 *
 * @author Webster Dias Wolak
 */

import edu.princeton.cs.algs4.StdOut;

public class BTree<Key extends Comparable<Key>, Value>{
    
// max children per B-tree node = M-1
    // (must be even and greater than 2)
    private static final int M = 4;

    private Node root;       // root of the B-tree
    private int height;      // height of the B-tree
    private int n;           // number of key-value pairs in the B-tree

    private static final class Node {
        private int m;                             // number of children
        private Entry[] children = new Entry[M];   // the array of children

        // create a node with k children
        private Node(int k) {
            m = k;
        }
    }

    private static class Entry {
        private Comparable key;
        private Object val;
        private Node next;     // helper field to iterate over array entries
        public Entry(Comparable key, Object val, Node next) {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    /**
     * TO DO: cria uma nova árvore
     */
    public BTree() {
        root = new Node(0);
    }
 
    /**
     * TO DO: verifica se a árvore está vazia
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * TO DO: retorna o tamanho, quanto aos elementos contidos na árvore
     */
    public int size() {
        return n;
    }

    /**
     * TO DO: retorna a altura da árvore
     */
    public int height() {
        return height;
    }


    /**
     * TO DO: procura o elemento 
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return search(root, key, height);
    }

    private Value search(Node x, Key key, int ht) {
        Entry[] children = x.children;

        // external node
        if (ht == 0) {
            for (int j = 0; j < x.m; j++) {
                if (eq(key, children[j].key)) return (Value) children[j].val;
            }
        }

        // internal node
        else {
            for (int j = 0; j < x.m; j++) {
                if (j+1 == x.m || less(key, children[j+1].key))
                    return search(children[j].next, key, ht-1);
            }
        }
        return null;
    }

	/**
     * TO DO: 
     * PUT: procura a posição correta para inserir o novo elemento
     */    
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("argument key to put() is null");
        Node u = insert(root, key, val, height); 
        n++;
        if (u == null) return;

        // need to split root
        Node t = new Node(2);
        t.children[0] = new Entry(root.children[0].key, null, root);
        t.children[1] = new Entry(u.children[0].key, null, u);
        root = t;
        height++;
    }

    private Node insert(Node h, Key key, Value val, int ht) {
        int j;
        Entry t = new Entry(key, val, null);

        // external node
        if (ht == 0) {
            for (j = 0; j < h.m; j++) {
                if (less(key, h.children[j].key)) break;
            }
        }

        // internal node
        else {
            for (j = 0; j < h.m; j++) {
                if ((j+1 == h.m) || less(key, h.children[j+1].key)) {
                    Node u = insert(h.children[j++].next, key, val, ht-1);
                    if (u == null) return null;
                    t.key = u.children[0].key;
                    t.val = null;
                    t.next = u;
                    break;
                }
            }
        }

        for (int i = h.m; i > j; i--)
            h.children[i] = h.children[i-1];
        h.children[j] = t;
        h.m++;
        if (h.m < M) return null;
        else         return split(h);
    }

    /**
     * TO DO: Divide o nó que excedeu o tamanho permitido (M-1) em dois nós
     */
    private Node split(Node h) {
        Node t = new Node(M/2);
        h.m = M/2;
        for (int j = 0; j < M/2; j++)
            t.children[j] = h.children[M/2+j]; 
        return t;    
    }

    /**
     * TO DO: chama a função PRIVATE toString para que esta faça as devidas 
     *      transformações
     */
    public String toString() {
        return toString(root, height, "") + "\n";
    }

	/**
     * TO DO: passa as informações de cada nó para uma string, ou seja,
     *      transforma o nó em string
     */
    private String toString(Node h, int ht, String indent) {
        StringBuilder s = new StringBuilder();
        Entry[] children = h.children;

        if (ht == 0) {
            for (int j = 0; j < h.m; j++) {
                s.append(indent + children[j].key + " " + children[j].val + "\n");
            }
        }
        else {
            for (int j = 0; j < h.m; j++) {
                if (j > 0) s.append(indent + "(" + children[j].key + ")\n");
                s.append(toString(children[j].next, ht-1, indent + "     "));
            }
        }
        return s.toString();
    }


    /**
     * TO DO:
     * LESS: Passados 2 elementos, retorna TRUE se k1 for menor que k2
     * EQ: Passados 2 elementos, retorna TRUE se k1 for igual a k2
     */
    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }

    private boolean eq(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }


    public static void main(String[] args) {
        
        BTree<String, Integer> st = new BTree<String, Integer>();
        System.out.println("Chaves a serem inseridas:");
        System.out.println("D A B C H E F G L I J K M N O P Q");
        System.out.println("Obs: As chaves em questão foram atribuidas aos"
                + " valores fornecidos no Exercício01:");
        System.out.println("5 1 2 3 10 7 8 9 30 13 18 19 40 46 49 80 89\n");
        
        System.out.println("A árvore está vazia ? " + st.isEmpty());
       
        String [] chaves = {"D","A","B","C","H","E","F","G","L","I","J","K","M",
            "N","O","P","Q"};
        for (int k = 0; k < chaves.length; k++) {
            st.put(chaves[k],k);
        }
        System.out.println("\n"+st.toString());
        
        System.out.println("A árvore está vazia ? " + st.isEmpty());
        System.out.println("Tamanho da árvore: " + st.size());
        System.out.println("Altura da árvore: " + st.height());
        System.out.println("Procurando o elemento (C):");
        System.out.println(st.get("C"));
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listex11;

/**
 *
 * @author Webster Dias Wolak
 */
public class TrieST <Value> {
    
    private static final int R = 256;
    private Node root = new Node();
    private int size = 0;
    
    private static class Node{
        private Object value;
        private Node[] next = new Node[R];
    }
    
    public void put(String key, Value val){
        size++;
        root = put(root,key,val,0);
    }
    
    private Node put(Node x, String key, Value val, int d){
        if(x == null){
            x = new Node();
        }
        
        if(d == key.length()){
            if(x.value != null){
                size--;
            }
            x.value = val;
            return x;
        }
        
        char c = key.charAt(d);
        x.next[c] = put(x.next[c],key,val,d+1);
        return x;
    }
    
    public boolean contains(String key){
        return get(key) != null;
    }
    
    public Value get(String key){
        Node x = get(root,key,0);
        if(x == null){
            return null;
        }
        
        return (Value) x.value;
    }
    
    private Node get(Node x, String key, int d){
        if(x == null){
            return null;
        }
        
        if(d == key.length()){
            return x;
        }
        
        char c = key.charAt(d);
        return get(x.next[c],key,d+1);
    }
    
    public void delete(String k){
        root = delete(root,k,0);
    }
    
    private Node delete(Node x, String k, int d){
        if(x == null){
            return null;
        }
        
        if(d == k.length()){
            size--;
            x.value = null;
        }else{
            char c = k.charAt(d);
            x.next[c] = delete(x.next[c],k,d+1);
        }
        
        if(x.value != null){
            return x;
        }
        
        for(char c = 0; c < R; c++){
            if(x.next[c] != null){
                return x;
            }
        }
        return null;
    }
    
    public int size(){
        return size;
    }
}

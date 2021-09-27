package BST;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Webster Dias Wolak
 */
public class BST_Exercícios2e3 <Key extends Comparable<Key>,Value>{
    
    private Node root;
    
    private class Node{
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int count;
        
        public Node(Key key, Value val, int count){
            this.key = key;
            this.val = val;
            this.count = count;
        }
    }
    
    public void put(Key key, Value val){
       root = put(root,key,val);
    }
    
    private Node put(Node x,Key key,Value val){
        if(x == null){
            return new Node(key, val,1);
        }
        int cmp = key.compareTo(x.key);
        
        if(cmp < 0){
            x.left = put(x.left,key,val);
        }else if(cmp > 0){
            x.right = put(x.right,key,val);
        }else{
            x.val = val;
        }
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }
    
    public int size(){
        return size(root);
    }
    
    private int size(Node x){
        if(x == null){
            return 0;
        }
        return x.count;
    }
    
    public Value get(Key key){
        Node x = root;
        while(x != null){
            int cmp = key.compareTo(x.key);
            if(cmp < 0){
                x = x.left;
            }else if(cmp > 0){
                x = x.right;
            }else{
                return x.val;
            }
        }
        return null;
    }
    
    public Key min(){
        if(root == null){
            return null;
        }
        return min(root);
    }
    
    private Key min(Node x){
        if(x.left == null){
            return x.key;
        }
        return min(x.left);
    }
    
    public Key max(){
        if(root == null){
            return null;
        }
        return max(root);
    }
    
    private Key max(Node x){
        if(x.right == null){
            return x.key;
        }
        return min(x.right);
    }
    
    public Key floor(Key key){
        Node x = floor(root,key);
        if(x == null){
            return null;
        }
        return x.key;
    }
    
    private Node floor(Node x,Key key){
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        
        if(cmp == 0){
            return x;
        }
        
        if(cmp < 0){
            return floor(x.left,key);
        }
        
        Node t = floor(x.right,key);
        if(t != null){
            return t;
        }else{
            return x;
        }
    }
    
    public Key ceiling(Key key){
        Node x = ceiling(root,key);
        if(x == null){
            return null;
        }
        return x.key;
    }
    
    private Node ceiling(Node x,Key key){
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        
        if(cmp == 0){
            return x;
        }
        
        if(cmp > 0){
            return ceiling(x.right,key);
        }
        
        Node t = ceiling(x.left,key);
        if(t != null){
            return t;
        }else{
            return x;
        }
    }
    
    public int rank(Key key) {
        
        return rank(key, root);
    }
    
    private int rank(Key key, Node x) {
        
        if(x == null) {
            return 0;
        }
        
        int cmp = key.compareTo(x.key);
        
        if(cmp < 0) {
            return rank(key, x.left);
        } else if(cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }
    
     public void removeMin() {
        
        root = removeMin(root);
    }
    
    private Node removeMin(Node x) {
        
        if(x.left == null) {
            
            return x.right;
        }
        
        x.left = removeMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }
    
    public void removeMax(){
        root =  removeMax(root);
    }
    
    private Node removeMax(Node x){
        if(x.right == null){
            return x.right;
        }
        x.right = removeMax(x.right);
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }
    
    public void remove(Key key) {
        
        root = remove(root, key);
    }
    
    private Node remove(Node x, Key key) {
        
        if(x == null) {
            return null;
        }
        
        int cmp = key.compareTo(x.key);
        
        if(cmp < 0) {
            x.left = remove(x.left, key);
        } else if(cmp > 0) {
            x.right = remove(x.right, key);
        } else {
            if(x.right == null) {
                return x.left;
            }
            
            if(x.left == null) {
                return x.right;
            }
            
            Node t = x;
            x = (Node) min(t.right);
            x.right = removeMin(t.right);
            x.left = t.left;
        }
        
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }
    
}

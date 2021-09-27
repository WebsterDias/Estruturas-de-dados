/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listex08;

/**
 *
 * @author Webster Dias Wolak
 */
public class BST_RubroNegra <Key extends Comparable<Key>,Value>{
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    
    private class Node{
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private boolean color;
        
        public Node(Key key, Value val, boolean color){
            this.key = key;
            this.val = val;
        }
    }
    
    private boolean isRed(Node x){
        if(x == null){
            return BLACK;
        }
        return x.color = RED;
    }
    
    public Value get(Key key){
        Node x = root;
        while(x!=null){
            int cmp = key.compareTo(x.key);
            if(cmp<0){
                x = x.left;
            }else if(cmp>0){
                x = x.right;
            }else{
                System.out.println(x.color);
                return x.val;
            }
        }
        
        return null;
    }
    
    private Node rotateLeft(Node h){
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h){
        assert isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
    
    private void flipColors(Node h){
        assert isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    
    public void put(Key key, Value val){
       root = put(root,key,val);
    }
    private Node put(Node h, Key key, Value val){
        if(h == null){
            return new Node(key, val, RED);
        }
        int cmp = key.compareTo(h.key);
        if(cmp<0){
            h.left = put(h.left,key,val);
        }else if(cmp>0){
            h.right = put(h.right,key,val);
        }else{
            h.val = val;
        }
        if(isRed(h.right) && !isRed(h.left)){
            h = rotateLeft(h);
        }
        if(isRed(h.left) && isRed(h.left.left)){
            h = rotateRight(h);
        }
        if(isRed(h.left) && isRed(h.right)){
            flipColors(h);
        }
        return h;
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
        return max(x.right);
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
}

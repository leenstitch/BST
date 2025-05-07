
package com.mycompany.bst;

public class node {
 int data;
 node right,left;

    public node(int data, node right, node left) {
        this.data = data;
        this.right = right;
        this.left = left;
    }

    node(int x) {
        this.data=x;
        left=right=null;
        
      
   }
 
}

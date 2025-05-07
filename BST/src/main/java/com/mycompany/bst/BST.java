
package com.mycompany.bst;

import java.time.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

public class BST<Integer> {
node root;
static int size=0;
String str="";

public BST() {
    
}

public void add(int x){
    int m=(int)x;
    if(!search(x))
        size++;
        root=add(root,m);
    }
 private node add( node root ,int data) {
    
     if(root==null){
          root=new node(data);
      
          return root;
     }
    else  if(data<root.data){
            root.left=add(root.left,data);
    }
     else if(data>root.data){
          root.right=add(root.right,data);
     }
     return root;
 }
 public String inOrder(){
     return inOrder(root);
 }
 public String inOrder(node root){
     if(root==null){
         return "";
     }

        // inOrder(root.left); 
        
           inOrder(root.left);
           //  System.out.print(root.data + " "); 
             str=str+root.data + " ";
           inOrder(root.right); 
           
       return str;     
     }
  
    public boolean search(int x){
       if(search(root,x)==null){
           return false;
       }
       return true;
    }
    private node search(node root, int data) {
       if(root==null){
           return null;
       }
       if(root.data==data){
     return root;
       }
       if(data>root.data){
       return   search(root.right,data);
       }
       else if(data<root.data){
 return search(root.left,data);
       }
      return null;
    }
 public void delete(int x){
     size--;
    root=delete(root,x);
 }
 private node delete(node root, int data) {
     if(root==null){
        return root;
     }
     else{
         if(data<root.data){
             root.left=delete(root.left,data);
         }
         else if(data>root.data){
             root.right=delete(root.right,data);
         }
         else{
           if(root.left==null){
               return root.right;
             }
           else if(root.right==null){
              return  root.left;
           }
           else{
               root.data=minval(root.right);
               root.right=delete(root.right,root.data);
           }
                     }
     }
    return root;
     }
 private int minval(node root) {
    int min=root.right.data;
       while(root.left!=null){
         min=root.left.data;
         root=root.left;
     }
     return min;
    }
public void update(int data,int x){
    if(search(x))return;
     BST l=new BST();
        size--;  
root=copy(l,this.root,data).root;
add(x);

    
}
private node update(node root,int data,int x){
  if(search(x)==true){
        return null;
    }
   if(root==null){
        return root;
    }
    else{
       if(data<root.data){
             update(root.left,data,x);
         }
         else if(data>root.data){
            update(root.right,data,x);
         }
         else{
            delete(this.root,data);
            add(this.root,x);
         }
    }
    return root;
}
public BST copy(BST l,node root,int m){
  if(root==null)return l;
if(root.data!=m){
    l.add(root.data);size--;
}
if(root.left!=null)copy(l,root.left,m);
if(root.right!=null)copy(l,root.right,m);
return l;
}

// ArrayList<Integer> leftView(node root)
//    {
//        if(root==null)return a;
//       if(root.left!=null)
//           leftView(root.left);
//           h(root,a);
//    
//      if(root.right!=null)leftView(root.left);
//   return a;
//    }
//     ArrayList<Integer> h(node root, ArrayList<Integer> a){
//        if(root==null)return a;
//        if(root.left!=null){
//         h(root.left,a);
//         a.add(root.data);
//     }
//    return a;
//}
public boolean level(node root){
    if(root==null)return true;
    if(root.left!=null)level(root.left);
    if(root.left==null&&root.right==null)return true;
    if(root.left==null&&root.right!=null)return false;
    if(root.left!=null&&root.right!=null)return level(root.right)&& true;
    return true;
    
//    if(root.left!=null){
//        if(root.right!=null&&root.left!=null)return level(root.left);
//                //&&true;
//        if(root.left==null&&root.right==null)return true;
//        if(root.right==null&&root.left!=null)return level(root.left);
//                //&&true;
//        
//        if(root.right!=null&&root.left==null)return false;
//        
//    }
//    if(root.right!=null)return level(root.right);
//    return false;
}
    public static void main(String[] args) {
     BST b=new BST();

    b.add(10);
      b.add(15);
     b.add(14);
      b.add(30);
      b.add(7);
      b.add(5);
     b.add(8);
     b.add(4);
     b.add(6);
     b.inOrder();
       //   b.add(9);
        System.out.println(b.level(b.root));
    
        //System.out.println( b.inOrder());
//        System.out.println(size);
//     b.update(10, 166);
//     
//     b.update(5, 30);
//     System.out.println(size);
     //   Stopwatch timer = Stopwatch.createUnstarted();
//Random r=new Random();
//long t=System.currentTimeMillis();
//while(size<5000){
//    b.add(r.nextInt());
//}
////
//long m=System.currentTimeMillis();
// System.out.println(m-t);
//System.out.println( b.inOrder());
//        System.out.println();
//      long m1=System.currentTimeMillis();
//        System.out.println("inorder" +(m1-m));
//         long m11=System.currentTimeMillis();
//        for(int i=0;i<size;i++){
//            b.delete(r.nextInt());
//        }
//        long m12=System.currentTimeMillis();
//        System.out.println(size);
//        System.out.println("delet"+(m12-m11));
           //long t1=System.currentTimeMillis();
       // b.m(b.root,r);
//Clock t=Clock.systemDefaultZone();
//long n=t.millis();
//        System.out.println(n);
//int sum=size;
//node curr=b.root;
//node curr1=b.root;
//while(sum!=0){
//   while(curr.left!=null){
//        b.update(curr.data,r.nextInt());sum--;
//        curr=curr.left;
//    }
//    while(curr1.right!=null){
//        b.update(curr.data,r.nextInt());sum--;
//        curr=curr.right;
//    }
//        
//}

//b.update(10, 18);

//        System.out.println();
     //System.out.println(size);
////b.inOrder();
//b.m(b.root,r);
////b.inOrder();
// System.out.println();
  //System.out.println(size);
       

        //ystem.out.println();


    }
public void m( node root,Random r){
    if(root==null)return ;
    if(root.left!=null)m(root.left,r);
        update(root.data,r.nextInt());
        if(root.right!=null)m(root.right,r);
    
}

   
   
}
    

    

    

    

   

    


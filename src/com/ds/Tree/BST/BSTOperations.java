package com.ds.Tree.BST;

import java.util.Scanner;

public class BSTOperations {
    public static void main(String[] args) {
        BST tree=new BST();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            tree.insert(sc.nextInt());
        }
        /* System.out.println("In Order Traversal");
        tree.inOrderTraversal();
        System.out.println("Post Order Traversal");
        tree.postOrderTraversal();
        System.out.println("Pre Order Traversal");
        tree.preOrderTraversal();
        */

        System.out.println(   tree.heightOfBST());
        sc.close();
    }
}


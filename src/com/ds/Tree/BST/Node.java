package com.ds.Tree.BST;

class Node{
    Node left;
    Node right;
    int data;
    public Node(int item){
        data=item;
        left=right=null;
    }
}

class BST{
    //Root Node Creating
    Node root;
    //Initilize the root node
    public BST(){
        root=null;
    }
    //inserting the element
    public void insert(int key){
        root = insertRec(root,key);
    }
    // Insert record
    Node insertRec(Node root,int key){

        if(root==null){
            root=new Node(key);
            return root;
        }
        if(key <= root.data)
            root.left=insertRec(root.left,key);
        else if(key > root.data)
            root.right=insertRec(root.right,key);

        return root;
    }
    public void inOrderTraversal(){
        inOrderRec(root);
    }
    public void preOrderTraversal(){
        preOrderRec(root);
    }
    public void postOrderTraversal(){
        postOrderRec(root);
    }
    public void levelOrderTraversal() {
    	levelOrderRec(root);
    }
    private void inOrderRec(Node root){
        if(root!=null){
            inOrderRec(root.left);
            System.out.println(root.data);
            inOrderRec(root.right);
        }
    }
    private void preOrderRec(Node root){
        if(root!=null){
            System.out.println(root.data);
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    private void postOrderRec(Node root){
        if(root!=null){
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.println(root.data);
        }
    }
    private void levelOrderRec(Node root) {
    	if(root!=null) {
    		
    	}
    }
    public int heightOfBST(){
        return findHeight(root);
    }
    // Finding the Height of Tree
    private int findHeight(Node aNode) {
        if (aNode == null) {
            return 0;
        }

        int lefth = findHeight(aNode.left);
        int righth = findHeight(aNode.right);

        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }
    
    

}

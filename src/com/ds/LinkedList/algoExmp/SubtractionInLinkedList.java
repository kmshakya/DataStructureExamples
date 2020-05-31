package com.ds.LinkedList.algoExmp;

import java.math.BigInteger;

public class SubtractionInLinkedList {

	public static Node append(Node head,int data) {
		if(head==null) {
			return new Node(data);
		}
		head.next=append(head.next,data);
		return head;
	}
	public static void printList(Node node) {
		if(node == null ) System.out.print("");
		else {
			while(node!=null) {
				System.out.print(node.data+" ");
				node =node.next;
			}
		}
	}
	
	public static void main(String[] args) {
		Node head1=null;
		Node head2=null;
		head1=append(head1,1);
		head1=append(head1,0);
		head1=append(head1,0);
		
		head2=append(head2,1);
		head2=append(head2,2);
		System.out.println(sublinkedList(head1, head2).data);

	}
	
	/*Return the Subtraction in Node*/
    public static Node sublinkedList(Node l1, Node l2) {
        BigInteger v1= BigInteger.ZERO;
        BigInteger v2= BigInteger.ZERO;
        if(l1!=null){
            while(l1!=null){
            	v1= v1.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(l1.data));
                l1=l1.next;
            }
        }
        if(l2!=null){
            while(l2!=null){
            	v2= v2.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(l2.data));
                l2=l2.next;
            }
        }
        return v1.compareTo(v2)==1 ? new Node(v1.subtract(v2).intValue()) : new Node(v2.subtract(v1).intValue());
    }

}

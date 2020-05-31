package com.ds.LinkedList.algoExmp;

import com.ds.LinkedList.SingleLinkedList;

public class ReverseLinkedList extends SingleLinkedList<Integer>{

	public static void main(String[] args) {
		ReverseLinkedList reverseList=new ReverseLinkedList();
		SingleLinkedList<Integer> linkedList=new SingleLinkedList<>();
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(30);
		linkedList.add(40);
		System.out.println("Linked List before Reverse. ");
		linkedList.displayLinkedList();
		System.out.println("After Reversing : ");
		reverseList.reverseLinkedList(linkedList);
		reverseList.displayLinkedList();
	}
	public void reverseLinkedList(SingleLinkedList<Integer> singleLinkedList){
		Node<Integer> current=singleLinkedList.getHead();
		Node<Integer> prev=null;
		Node<Integer> next=null;
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		head=prev;
	}

}

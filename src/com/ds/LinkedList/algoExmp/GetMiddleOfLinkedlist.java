package com.ds.LinkedList.algoExmp;

import com.ds.LinkedList.SingleLinkedList;
import com.ds.LinkedList.SingleLinkedList.Node;

/* Finding middle element in a linked list */
public class GetMiddleOfLinkedlist {
	public static void main(String[] args) {
		SingleLinkedList<Integer> linkedList=new SingleLinkedList<>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.add(6);
		//output should be 4 since it's even so we need to print second in middle
		System.out.println("Middle of the List is : "+getMiddle(linkedList));
	}
	public static Integer getMiddle(SingleLinkedList linkedList) {
		Node<Integer> head = linkedList.getHead();
		if(head!=null) {
			Node<Integer> slow_pointer=head;
			Node<Integer> fast_pointer=head;
			while(fast_pointer!=null && fast_pointer.next!=null) {
				slow_pointer=slow_pointer.next;
				fast_pointer=fast_pointer.next.next;
			}
			return slow_pointer.data;
		}
		return 0;
	}
}

package com.ds.LinkedList.algoExmp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

class Node {
	int data;
	Node next;
	public Node(int data) {
		this.data=data;
		this.next=null;
	}
	public Node() {}
}
public class GetIntersectionOfLinkedList {
	
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
		//First LinkedList
		Node head1=null;
		Node head2=null;
		head1=append(head1,9);
		head1=append(head1,6);
		head1=append(head1,4);
		head1=append(head1,2);
		head1=append(head1,3);
		head1=append(head1,8);
		
		head2=append(head2,1);
		head2=append(head2,2);
		head2=append(head2,8);
		head2=append(head2,6);
		/*System.out.println("List 1 : ");
		printList(head1);
		System.out.println("List 2 : ");
		printList(head2); */
		// Implementing Intersection of these two LinkedList
		Node intersection=interSection(head1,head2);
		printList(intersection);
	}
	private static Node interSection(Node head1, Node head2) {
		Node intersectionList=null;
		if(head1==null || head2==null) {
			return null;
		}
		HashMap<Integer,Integer> hashMap=new HashMap<>();
		ArrayList<Integer> tempArray=new ArrayList<>();
		while(head1!=null) {
			if(hashMap.containsKey(head1.data)) {
				hashMap.put(head1.data, hashMap.get(head1.data)+1);
			}else {
				hashMap.put(head1.data, 0);
			}
			head1=head1.next;
		}
		while(head2!=null) {
			if(hashMap.containsKey(head2.data) && hashMap.get(head2.data) >= 0) {
				tempArray.add(head2.data);
				hashMap.replace(head2.data, hashMap.get(head2.data) -1 );
			}
			head2=head2.next;
		}
		Collections.sort(tempArray);
		for (Integer integer : tempArray) {
			intersectionList=append(intersectionList,integer);
		}
		return intersectionList;
	}

}

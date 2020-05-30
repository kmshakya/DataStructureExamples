package com.ds.LinkedList;


public class SingleLinkedList<T> {
	
	Node<T> head=null;
	
	//Private Class to represent the nodes
	@SuppressWarnings("hiding")
	private class Node<T>{
		T data;
		Node<T> next;
		public Node(T data) {
			super();
			this.data = data;
			this.next = null;
		}
	}
	//Adding a element at last of the list
	public void addTail(T data) {
		Node<T> newNode= new Node<T>(data);
		if(head==null) head = newNode;
		else {
			Node<T> last=head;
			while(last.next != null) last=last.next;
			last.next=newNode;
		}
	}
	//Adding at first
	public void addFirst(T data) {
		Node<T> newNode= new Node<T>(data);
		newNode.next=head;
		head = newNode;
	}
	
	//Adding before any node
	public void addBefore(T beforeNodeData,T data) {
		
	}
	
	//Adding after any Node
	public void addAfter(T afterNodeData,T data) {
		
	}
	
	//Display The List
	public void displayLinkedList() {
		Node<T> node = head;
		while(node!=null) {
			System.out.println(node.data);
			node=node.next;
		}
	}
	
	public static void main(String[] args) {
		//Creating SingleLinkedList of Integers
		SingleLinkedList<Integer> singleLinkedList= new SingleLinkedList<>();
		singleLinkedList.addTail(10);
		singleLinkedList.addTail(20);
		singleLinkedList.addTail(4);
		singleLinkedList.addFirst(11);
		singleLinkedList.addFirst(12);
		singleLinkedList.displayLinkedList();
		
		//Creating the SingleLinkedListOfStrings
		SingleLinkedList<String> listofStrings = new SingleLinkedList<String>();
		listofStrings.addTail("Ram");
		listofStrings.addTail("Shyam");
		listofStrings.displayLinkedList();
	}

}

package com.ds.LinkedList;


public class SingleLinkedList<T> {
	
	Node<T> head=null;
	Node<T> tail=null;
	
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
	public void add(T data) {
		Node<T> newNode= new Node<T>(data);
		if(head==null) head =tail= newNode;
		else {
			Node<T> last=head;
			while(last.next != null) last=last.next;
			last.next=tail=newNode;
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
		Node<T> currentNode=head;
		Node<T> previousNode=head;
		if(beforeNodeData==head.data) {
			addFirst(data);
			return;
		}
		while(currentNode!=null) {
			if(currentNode.data==beforeNodeData) {
				Node<T> newNode=new Node<T>(data);				
				Node<T> tempNode=previousNode.next;
				previousNode.next=newNode;
				newNode.next=tempNode;
				return;
			}
			previousNode=currentNode;
			currentNode=currentNode.next;
			if(currentNode==null) System.out.println("Node "+beforeNodeData+" Not Found In Linked List");
		}
	}
	
	//Adding after any Node
	public void addAfter(T afterNodeData,T data) {
		Node<T> node=head;
		if(afterNodeData==tail.data) {
			add(data);
			return;
		}
		while(node!=null) {
			if(node.data==afterNodeData) {
				Node<T> newNode=new Node<T>(data);				
				Node<T> tempNode=node.next;
				node.next=newNode;
				newNode.next=tempNode;
				return;
			} 
			node=node.next;
			if(node==null) System.out.println("Node "+afterNodeData+" Not Found In Linked List");
		}
	}
	
	//Deleting a Node from LinkedList
	public void delete(T data) {
		Node<T> node=head;
		if(data==head.data) {
			head=head.next;
			return;
		}
		while(node!=null) {
			if(node.data==data) {
				
			}
			node=node.next;
		}
	}
	//Display The List
	public void displayLinkedList() {
		Node<T> node = head;
		while(node!=null) {
			System.out.println(node.data);
			node=node.next;
		}
	}
	//Returns Head Data
	public T getHead() {
		return head.data;
	}
	
	//Returns Tail Data
	public T getTail() {
		return tail.data;
	}
	
	//Returns true if empty
	public boolean isEmpty() {
		return head==null;
	}
	
	/* Main Method For Testing Purpose */
	public static void main(String[] args) {
		//Creating SingleLinkedList of Integers
		SingleLinkedList<Integer> singleLinkedList= new SingleLinkedList<>();
		singleLinkedList.add(10);
		singleLinkedList.add(20);
		singleLinkedList.add(4);
		singleLinkedList.add(11);
		singleLinkedList.addAfter(10, 9);
		singleLinkedList.addBefore(2, 3);
		singleLinkedList.addFirst(12);
		singleLinkedList.displayLinkedList();
		System.out.println("Head of LikedList: "+singleLinkedList.getHead());
		System.out.println("Tail of LikedList: "+singleLinkedList.getTail());
		System.out.println("Is LinkedList Empty ? "+singleLinkedList.isEmpty());
		
	}

}

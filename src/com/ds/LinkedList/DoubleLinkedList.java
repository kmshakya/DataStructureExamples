package com.ds.LinkedList;

public class DoubleLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	
	private class Node<T>{
		T data;
		Node<T> prev;
		Node<T> next;
		public Node(T data) {
			this.data=data;
			this.prev=null;
			this.next=null;
		}
	}
	
	//Adding a node
	public void add(T data) {
		Node<T> newNode= new Node<T>(data);
		if(head==null) {
			head=newNode;
			tail=newNode;
		}else {
			Node<T> node=head;
			while(node.next!=null) {
				node=node.next;
			}
			node.next=newNode;
			newNode.prev=node.next;
			tail=newNode;
		}
	}
	//Display List
	public void display() {
		Node<T> node=head;
		while(node!=null) {
			System.out.println(node.data);
			node=node.next;
		}
	}
	
	//Get Head
	public T getHead() {
		return this.head.data;
	}
	//Get Tail
	public T getTail() {
		return this.tail.data;
	}
	
	public static void main(String[] args) {
		DoubleLinkedList<Integer> doubleLinkedList=new DoubleLinkedList<>();
		doubleLinkedList.add(10);
		doubleLinkedList.add(4);
		doubleLinkedList.add(12);
		doubleLinkedList.add(6);
		doubleLinkedList.add(2);
		doubleLinkedList.display();
		System.out.println("Head "+doubleLinkedList.getHead());
		System.out.println("Tail "+doubleLinkedList.getTail());

	}

}

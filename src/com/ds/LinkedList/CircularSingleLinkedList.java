package com.ds.LinkedList;

public class CircularSingleLinkedList<T> {
	
	public Node<T> head;
	public Node<T> tail;

	public class Node<t>{
		public T data;
		public Node<T> next;
		public Node(T data){
			this.data=data;
			this.next=null;
		}
	}
	//Appending the list
	public void add(T data) {
		Node<T> node=head;
		Node<T> newNode= new Node<>(data);
		if(head==null) {
			head=tail=newNode;
			tail.next=head;
		}else {
				while(node.next!=head) {
					node = node.next;
				}
				newNode.next=tail.next;
				node.next=newNode;
				tail=newNode;
				
			}
		}
	//Add at first
	public void affFirst(T data) {
		Node<T> newNode=new Node<T>(data);
		newNode.next=head;
		head=newNode;
		tail.next=newNode;
	}
	//Display the List 
	public void display() {
		Node<T> node=head;
		if(head!=null) {
			do {
				System.out.println(node.data);
				node=node.next;
			}while(node!=head);
		}
	}
	//Get Head
	public Node<T> getHead() {
		return this.head;
	}
	//Get Tail
	public Node<T> getTail() {
		return this.tail;
	}
	
	public static void main(String[] args) {
		CircularSingleLinkedList<Integer> circularSingleLinkedList=new CircularSingleLinkedList<>();
		circularSingleLinkedList.add(10);
		circularSingleLinkedList.add(5);
		circularSingleLinkedList.add(11);
		circularSingleLinkedList.add(12);
		
		//System.out.println(circularSingleLinkedList.getHead());
		//System.out.println(circularSingleLinkedList.getTail());
		circularSingleLinkedList.display();
	}

}

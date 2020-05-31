package com.ds.LinkedList.algoExmp;

import java.util.HashSet;
import java.util.TreeMap;

import com.ds.LinkedList.CircularSingleLinkedList;

public class LoopDetectionInLinkedList extends CircularSingleLinkedList<Integer> {
	
	public static void main(String[] args) {
		LoopDetectionInLinkedList detectionInLinkedList=new LoopDetectionInLinkedList();
		CircularSingleLinkedList<Integer> linkedList=new CircularSingleLinkedList<Integer>();
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(30);
		linkedList.add(40);
		System.out.println("Is Loop Detected(Hashing) : "+detectionInLinkedList.detectLoopUsingHashing(linkedList));
		System.out.println("Is Loop Detected(TwoPointer) : "+detectionInLinkedList.detectLoopUsingTwoPointer(linkedList));
		//TreeMap<Integer,Integer> treeMap=new TreeMap<Integer,Integer>();
		

	}
	//Using Hashing detect Loop
	public boolean detectLoopUsingHashing(CircularSingleLinkedList<Integer> linkedList) {
		Node<Integer> head=linkedList.getHead();
		if(head!=null) {
			HashSet<Node<Integer>> set=new HashSet<>();
			while(head!=null) {
				if(set.contains(head)) {
					return true;
				}
				set.add(head);
				head=head.next;
			}
		}
		return false;
	}
	//Using Two Pointers Detect Loop
	public boolean detectLoopUsingTwoPointer(CircularSingleLinkedList<Integer> linkedList) {
		Node<Integer> slow_pointer=linkedList.getHead();
		Node<Integer> fast_pointer=linkedList.getHead();
		if(slow_pointer!=null) {
			while(fast_pointer!=null && fast_pointer.next!=null) {
				if(slow_pointer==fast_pointer) {
					return true;
				}
				slow_pointer=slow_pointer.next;
				fast_pointer=fast_pointer.next.next;
			}
		}
		return false;
	}

}

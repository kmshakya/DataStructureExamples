package com.ds.stack.algoExmp;


import java.util.Scanner;
import java.util.Stack;

public class RemoveFriendHackerEarth {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int k=sc.nextInt();
			Stack<Integer> s=new Stack<Integer>();
				for(int i=0;i<n;i++) {
					int data=sc.nextInt();
						if(!s.empty() && k>0) {
							if(s.peek()<=data) {
								s.pop();
								k--;
							}
						}
						s.push(data);
				}
			Stack<Integer> st=new Stack<>();
			for (Integer integer : s) {
				st.add(integer);
			}
			for(int i=0;i<k;i++) {
				st.pop();
			}
			for (Integer integer : st) {
				System.out.print(integer+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}

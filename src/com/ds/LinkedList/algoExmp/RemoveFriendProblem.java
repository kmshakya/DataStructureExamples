package com.ds.LinkedList.algoExmp;

import java.util.LinkedList;
import java.util.Scanner;

public class RemoveFriendProblem {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int k=sc.nextInt();
			LinkedList<Integer> ls=new LinkedList<>();
			for(int i=0;i<n;i++) {
				ls.add(sc.nextInt());
			}
			for(int i=0;i<k;i++) {
				ls=removeIfLess(ls);
			}
			for (Integer integer : ls) {
				System.out.println(integer+" ");
			}
		}
		sc.close();
	}

	private static LinkedList<Integer> removeIfLess(LinkedList<Integer> ls) {
		if(ls.size()<2) {
			return ls;
		}
		int itr=0;
		while(itr+1 <= ls.size()) {
			if(ls.get(itr)<ls.get(itr+1)) {
				ls.remove(ls.get(itr));
				break;
			}
			itr++;
		}
		return ls;
	}

}

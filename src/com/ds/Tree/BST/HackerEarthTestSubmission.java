package com.ds.Tree.BST;
/* IMPORTANT: Multiple classes and nested static classes are supported */
 
/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
//import for Scanner and other utility classes*/
import java.io.*;
import java.util.*;
 
 
class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
 
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
 
        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
 
        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */
        InputReader in = new InputReader(new BufferedInputStream(System.in));
 
       PrintWriter pw = new PrintWriter(System.out);
		int noOfNodes = in.readInt();
		int[] nodeValues = new int[noOfNodes];
 
		Node[] nodes = new Node[noOfNodes];
 
		for (int i = 0; i < noOfNodes; i++) {
			nodeValues[i] = in.readInt();
		}
		inorderTraversal(nodeValues, 0, nodes);
		Arrays.sort(nodes);
		pw.println(calculateSwapsRequired(nodes));
		pw.flush();
		pw.close();
 
	}
 
	private static int calculateSwapsRequired(Node[] nodes) {
		int length = nodes.length;
		int swapsRequired = 0;
		for (int i = 0; i < length; i++) {
			Node node = nodes[i];
			int nodesInCycle = 0;
			while (!node.isVisited() && node.position != i) {
				int position = node.position;
				node.markVisited();
				node = nodes[position];
				nodesInCycle++;
			}
			node.markVisited();
			swapsRequired += nodesInCycle;
		}
		return swapsRequired;
	}
	
	static private void printNodes(Node[] nodes)
	{
		for(Node node: nodes)
		{
			System.out.print(node.value + " " + node.position + ",");
		}
		System.out.println();
	}
 
	private static void inorderTraversal(int array[], int pos, Node[] nodes) {
		if (pos >= array.length) {
			return;
		}
		inorderTraversal(array, 2 * pos + 1, nodes);
		nodes[Node.count] = new Node(array[pos], Node.count);
		Node.count++;
		inorderTraversal(array, 2 * pos + 2, nodes);
	}
 
	static private class Node implements Comparable<Node> {
 
		private static int count = 0;
 
		public Node(int value) {
			this.value = value;
		}
 
		public Node(int value, int position) {
			this(value);
			this.position = position;
		}
 
		private int value;
		private int position;
		private boolean visited;
 
		public boolean isVisited() {
			return visited;
		}
 
		public void markVisited() {
			visited = true;
		}
 
		@Override
		public int compareTo(Node o) {
			if (this.value >= o.value) {
				return 1;
			}
			return -1;
		}
	}
 
	static class InputReader {
		private BufferedInputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
 
		public InputReader(BufferedInputStream stream) {
			this.stream = stream;
		}
 
		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
 
		public int readInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
 
		public long readLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
 
		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
	}
 
}
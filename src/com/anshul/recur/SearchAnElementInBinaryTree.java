package com.anshul.recur;

import java.util.LinkedList;
import java.util.Queue;

class Tode {
	int data;
	Tode left;
	Tode right;

	public Tode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class SearchAnElementInBinaryTree {

	public boolean findElement(Tode root, int data) {

		if (root == null)
			return false;
		else {
			if (root.data == data)
				return true;
			boolean temp = findElement(root.left, data);
			if (temp != false)
				return temp;
			return findElement(root.right, data);
		}
	}

	public void printPreOrderTraversal(Tode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		printPreOrderTraversal(root.left);
		printPreOrderTraversal(root.right);
	}
	
	public void printInOrderTraversal(Tode root) {
		if(root == null) {
			return;
		}
		printInOrderTraversal(root.left);
		System.out.print(root.data + " ");
		printInOrderTraversal(root.right);
	}
	
	public void printPostOrderTraversal(Tode root) {
		if(root == null) {
			return;
		}
		printPostOrderTraversal(root.left);
		printPostOrderTraversal(root.right);
		System.out.print(root.data + " ");
	}

	public void printLevelOrderTraversal(Tode root) {
		Queue<Tode> queue = new LinkedList<Tode>();
		if(root == null) {
			return;
		}
		queue.add(root);
		
		while (!queue.isEmpty()) {
			Tode node = queue.remove();
			System.out.print(node.data + " ");
			
			if(node.left != null) {
				queue.add(node.left);
			}
			if(node.right != null) {
				queue.add(node.right);
			}
		}
	}

	public static void main(String[] args) {
		Tode root = null;

		Tode tode1 = new Tode(1);
		Tode tode2 = new Tode(2);
		Tode tode3 = new Tode(3);
		Tode tode4 = new Tode(4);
		Tode tode5 = new Tode(5);
		Tode tode6 = new Tode(6);
		Tode tode7 = new Tode(7);
		tode1.left = tode2;
		tode1.right = tode3;
		tode2.left = tode4;
		tode2.right = tode5;
		tode3.left = tode6;
		tode3.right = tode7;

		root = tode1;

		SearchAnElementInBinaryTree search = new SearchAnElementInBinaryTree();
		System.out.println(search.findElement(root, 7));
		System.out.println(search.findElement(root, 8));
		System.out.println(search.findElement(root, 3));
		System.out.println("============pre order===============");
		search.printPreOrderTraversal(root);
		System.out.println("\n============in order================");
		search.printInOrderTraversal(root);
		System.out.println("\n============post order==============");
		search.printPostOrderTraversal(root);
		System.out.println("\n============level order=============");
		search.printLevelOrderTraversal(root);
	}
}

package com.anshul.recur;

/*
 * LinkedList Reversal program
 * */

class Node {
	int data;
	Node next;

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

public class LinkedList {

	public static Node reverseIterative(Node head) {
		Node current = head;
		Node next = null;
		Node prev = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}

	static Node reverseRecursive(Node curr, Node prev, Node head) {
		if(curr.next == null) {
			curr.next = prev;
			head = curr;
			return head;
		}
		Node next = curr.next;
		curr.next = prev;
		return reverseRecursive(next, curr, head);
	}

	public static Node reverseRecursively(Node node) {
		Node newHead;
		if (node.next == null) {
			return node;
		}
		newHead = reverseRecursively(node.next);

		node.next.next = node;
		node.next = null;
		return newHead;
	}

	public static void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		Node node1 = new Node(1, null);
		Node node2 = new Node(2, node1);
		Node node3 = new Node(3, node2);
		Node node4 = new Node(4, node3);
		Node node5 = new Node(5, node4);
		Node node6 = new Node(6, node5);

		// Node head = node6;
		Node head = node6;
		System.out.println("Before reversal : ");
		printList(head);
		head = reverseIterative(head);
		System.out.println("\nAfter reversal : ");
		printList(head);
		System.out.println("\n=============");
		head = reverseRecursively(head);
		printList(head);
		System.out.println("\n=============");
		Node dummy = null;
		head = reverseRecursive(head, null, dummy);
		printList(head);

	}
}

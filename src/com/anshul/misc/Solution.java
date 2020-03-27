package com.anshul.misc;

import java.util.HashMap;

/*
 * LRU Cache implementation
 * 
 * 
 * */
import java.util.Map;

class Node {
	int data;
	Node next;
	Node prev;

	public Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

public class Solution {
	int listLength;
	int cacheCapacity;
	Map<Integer, Integer> valueMap;
	Node head;

	public Solution(int capacity) {
		listLength = 0;
		cacheCapacity = capacity;
		head = null;
		valueMap = new HashMap<Integer, Integer>(capacity);
	}

	public void bringAtFront(int key) {
		Node temp = head;
		while (temp.data != key) {
			temp = temp.next;
		}
		if (temp.prev != null) {
			temp.prev.next = temp.next;
			if (temp.next != null) {
				temp.next.prev = temp.prev;
			}
			temp.prev = null;
			temp.next = head;
			head.prev = temp;
			head = temp;
		}
	}

	public int get(int key) {
		if (valueMap.containsKey(key)) {
			bringAtFront(key);
			return valueMap.get(key);
		}
		return -1;
	}

	public void set(int key, int value) {
		if (valueMap.containsKey(key)) {
			bringAtFront(key);
		} else if (listLength < cacheCapacity) {
			Node node = new Node(key);
			if (listLength == 0) {
				head = node;
				listLength++;
			} else {
				node.next = head;
				head.prev = node;
				head = node;
				listLength++;
			}
		} else {
			Node node = new Node(key);
			node.next = head;
			head.prev = node;
			head = node;
			valueMap.remove(removeLast());
		}
		valueMap.put(key, value);
	}

	private Integer removeLast() {
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		Node prev = temp.prev;
		prev.next = null;
		temp.prev = null;
		return temp.data;
	}

	public static void main(String[] args) {
		Solution solution = new Solution(7);
		solution.set(2, 1);
		solution.set(1, 10);
		solution.set(8, 13);
		System.out.println(solution.get(12));
		solution.set(2, 8);
		System.out.println(solution.get(11));
		System.out.println(solution.get(7));
		solution.set(14, 7);
		solution.set(12, 9);
		solution.set(7, 10);
		System.out.println(solution.get(11));
		solution.set(9, 3);
		solution.set(14, 15);
		System.out.println(solution.get(15));
		System.out.println(solution.get(9));
		solution.set(4, 13);
		System.out.println(solution.get(3));
		solution.set(13, 7);
		System.out.println(solution.get(2));
		solution.set(5, 9);
		System.out.println(solution.get(6));
		System.out.println(solution.get(13));
		solution.set(4, 5);
		solution.set(3, 2);
		solution.set(4, 12);
		System.out.println(solution.get(13));
		System.out.println(solution.get(7));
		solution.set(9, 7);
		System.out.println(solution.get(3));
		System.out.println(solution.get(6));
		System.out.println(solution.get(2));
		solution.set(8, 4);
		solution.set(8, 9);
		solution.set(1, 4);
		solution.set(2, 9);
		solution.set(8, 8);
		System.out.println(solution.get(13));
		System.out.println(solution.get(3));
		System.out.println(solution.get(13));
		System.out.println(solution.get(6));
		solution.set(3, 8);
		System.out.println(solution.get(14));
		System.out.println(solution.get(4));
		solution.set(5, 6);
		solution.set(10, 15);
		System.out.println(solution.get(12));
		solution.set(13, 5);
		solution.set(10, 9);
		solution.set(3, 12);
		solution.set(14, 15);
		System.out.println(solution.get(4));
		solution.set(10, 5);
		System.out.println(solution.get(5));
		System.out.println(solution.get(15));
		solution.set(7, 6);
		System.out.println(solution.get(1));
		solution.set(5, 12);
		solution.set(1, 6);
		solution.set(11, 8);
	}
}

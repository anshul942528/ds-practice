package com.anshul.misc;

class HeapNode {
	int data;
	int row;
	int col;
	int length;
	
	public HeapNode(int data, int row, int col, int length) {
		this.data = data;
		this.row = row;
		this.col = col;
		this.length = length;
	}
}

public class MinHeap {
	
	public HeapNode[] buildMinHeap(HeapNode[] nodeArray) {
		
		for(int i = nodeArray.length / 2; i >= 0; i--) {
			minHeapify(nodeArray, i);
		}
		
		return nodeArray;
	}

	public void minHeapify(HeapNode[] nodeArray, int i) {
		int left = 2*i + 1;
		int right = 2*i + 2;
		int minimum = i;
		
		if(left < nodeArray.length && nodeArray[left].data < nodeArray[i].data) {
			minimum = left;
		}
		
		if(right < nodeArray.length && nodeArray[right].data < nodeArray[minimum].data) {
			minimum = right;
		}
		
		if(minimum != i) {
			HeapNode temp = nodeArray[minimum];
			nodeArray[minimum] = nodeArray[i];
			nodeArray[i] = temp;
			minHeapify(nodeArray, minimum);
		}
	}
	
}

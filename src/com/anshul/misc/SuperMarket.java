package com.anshul.misc;

import java.util.ArrayList;
import java.util.List;

class SeqNode {
	int row;
	int val;

	public SeqNode(int row, int val) {
		this.row = row;
		this.val = val;
	}

	public String toString() {
		return "(" + this.row + ", " + this.val + ")";
	}
}

public class SuperMarket {

	public static void main(String[] args) {
		int[][] queue = { { 3, 4, 5 }, { 5, 6, 2 }, { 4, 1, 3 }, { 1, 2, 3 } };

		SuperMarket sm = new SuperMarket();
		System.out.println(sm.gettheSequence(queue));
	}

	private List<SeqNode> gettheSequence(int[][] queue) {
		List<SeqNode> seqList = new ArrayList<>();
		HeapNode[] nodeArray = new HeapNode[queue.length];
		
		for(int i = 0; i < queue.length; i++) {
			nodeArray[i] = new HeapNode(queue[i][0], i, 0, queue[i].length);
		}
		
		MinHeap heap = new MinHeap();
		HeapNode[] heapArray = heap.buildMinHeap(nodeArray); 
		
		while (true) {
			heap.minHeapify(heapArray, 0);
			if(heapArray[0].data == Integer.MAX_VALUE) {
				break;
			}
			seqList.add(new SeqNode(heapArray[0].row, heapArray[0].data));
			if(heapArray[0].col < heapArray[0].length - 1) {
				heapArray[0].col = heapArray[0].col + 1;
				heapArray[0].data = queue[heapArray[0].row][heapArray[0].col];
			}else {
				heapArray[0].data = Integer.MAX_VALUE;
			}
		}
		
		return seqList;
	}
}

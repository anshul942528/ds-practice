package com.anshul.dp;

/* Minimum cost Path from top left to bottom right
 * Dynamic Programming
 * */
public class DP_MatrixTwo {
	
	public static void main(String[] args) {
		int[][] cost = {
				{1, 3, 5, 8},
				{4, 2, 1, 7},
				{4, 3, 2, 3}
		};
		System.out.println(minCostPath(cost, cost.length, cost[0].length));
	}

	private static int minCostPath(int[][] cost, int row, int col) {
		int[][] mem = new int[cost.length][cost[0].length];
		mem[0][0] = cost[0][0];
		
		for(int rowT = 1; rowT < row; rowT++) {
			 mem[rowT][0] = mem[rowT - 1][0] + cost[rowT][0];
		}
		
		for(int colT = 1; colT < col; colT++) {
			 mem[0][colT] = mem[0][colT - 1] + cost[0][colT];
		}
		
		for(int rowT = 1; rowT < row; rowT++) {
			for(int colT = 1; colT < col; colT++) {
				mem[rowT][colT] = min(mem[rowT][colT - 1], mem[rowT - 1][colT]) + cost[rowT][colT];
			}
		}
		
		return mem[row - 1][col - 1];
	}

	/*private static void printMatrix(int[][] mem) {
		for(int row = 0; row < mem.length; row++) {
			for(int col = 0; col < mem[0].length; col++) {
				System.out.println(mem[row][col]);
			}
		}
		
	}*/

	private static int min(int minCostPath, int minCostPath2) {
		return minCostPath < minCostPath2 ? minCostPath : minCostPath2;
	}
}

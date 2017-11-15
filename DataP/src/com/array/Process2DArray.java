package com.array;

public class Process2DArray {
	static final int ROWS = 4;
	static final int COLS = 2;

	public static void main(String[] args) {
		// first way of 2d integer array
		int[][] tableInt = new int[ROWS][COLS];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				tableInt[i][j] = i + j;
			}
		}
		String outputTable1 = "Values of tableInt:\n";

		for (int[] row : tableInt) {
			for (int val : row) {
				outputTable1 += " " + val;
			}
			outputTable1 += "\n";
		}
		System.out.println(outputTable1);

		// Second Way of Array
		String[][] fruitsTable = new String[][] { { "apple", "orange" }, { "kiwi", "strawberry" }, { "peach", "melon" },
				{ "cranberry", "grape" } };
		System.out.println("Fruits in winter are: " + fruitsTable[0][0] + " and " + fruitsTable[0][1]);
		System.out.println("Fruits in rainy are: " + fruitsTable[1][0] + " and " + fruitsTable[1][1]);
		System.out.println("Fruits in summer are: " + fruitsTable[2][0] + " and " + fruitsTable[2][1]);
	}

}

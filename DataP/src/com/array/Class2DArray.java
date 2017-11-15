package com.array;

public class Class2DArray {
	static final int ROWS = 4;
	static final int COLS = 2;

	private int num;
	private String name;

	public Class2DArray(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getNum() {
		return num;
	}

	public static void main(String[] args) {
		// Declaring the array
		Class2DArray[][] tableClass;
		tableClass = new Class2DArray[ROWS][];
		for (int i = 0; i < ROWS; i++) {
			tableClass[i] = new Class2DArray[COLS];
		}
		// Adding values to array
		for (int i = 0; i < tableClass.length; i++) {
			for (int j = 0; j < tableClass[i].length; j++) {
				tableClass[i][j] = new Class2DArray(i + j, "row" + i + "-col" + j);
			}
		}
		// print the name of the class of the tableClass
		String outputTable2 = "The values of tableClass:\n";
		for (int row = 0; row < tableClass.length; row++) {
			for (int col = 0; col < tableClass[row].length; col++) {
				outputTable2 += " name = " + tableClass[row][col].getName() + "|";
			}
			outputTable2 += "\n";
		}
		System.out.println(outputTable2);
	}

}

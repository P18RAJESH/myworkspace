package com.p74;

import java.util.Arrays;

public class GridSearch {

	public static boolean searchMatrix1(int[][] matrix, int target) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				if (matrix[i][j] == target) {
					return true;
				}
		}

		return false;

	}

	public static boolean searchMatrix2(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			return Arrays.binarySearch(matrix[i], target) >= 0;
		}
		return false;

	}

	public static boolean searchMatrix3(int[][] matrix, int target) {
		int m = matrix.length, n;
		for (int i = 0; i < m; i++) {
			n = matrix[i].length;
			if (n != 0 && matrix[i][n - 1] >= target)
				return Arrays.binarySearch(matrix[i], target) >= 0;
		}
		return false;
	}

	public static boolean searchMatrix4(int[][] matrix, int target) {
		int row = matrix.length;
		if (row == 0)
			return false;
		int col = matrix[0].length;
		for (int i = 0, j = col - 1; i < row && j >= 0;) {
			if (matrix[i][j] == target)
				return true;
			else if (matrix[i][j] > target)
				j--;
			else
				i++;
		}
		return false;

	}

	public static boolean searchMatrix5(int[][] matrix, int target) {
		int m = matrix.length;
		if (m < 1 || matrix[0].length == 0)
			return false;
		int n = matrix[0].length;
		int l = 0, r = m * n - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			int e = matrix[mid / n][mid % n];
			if (target == e)
				return true;
			if (target < e)
				r = mid - 1;
			else
				l = mid + 1;
		}
		return false;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		int ary[][] = new int[n][n];
		int num = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ary[i][j] = num++;
			}
		}
		/*
		 * for (int i = 0; i < n; i++) { System.out.print("[ "); for (int j = 0;
		 * j < n; j++) { // System.out.print(ary[i][j] + " ");
		 * System.out.printf("%2d ", ary[i][j]); } System.out.println(" ]"); }
		 */
		System.out.println("Find num is " + num);
		long ts = System.nanoTime();
		System.out.println("Element found :" + searchMatrix2(ary, num));
		long te = System.nanoTime();
		System.out.println("total time is : " + (te - ts) / 1000000 + " mill sec");
		// total time is : 40 micro sec
		// total time is : 77 micro sec
		// total time is : 1146 micro sec
		// total time is : 1220 micro sec
		// total time is : 58 micro sec

	}

}

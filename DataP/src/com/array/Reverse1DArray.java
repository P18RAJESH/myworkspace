package com.array;

import java.util.Random;

public class Reverse1DArray {

	public static void ReverseArrayContent(int n) {
		if (n < 1 || n >= 1000)
			return;
		Random r = new Random();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = r.nextInt(1000);
			// System.out.print(arr[i] + " ");
		}
		System.out.println();
		for (int i = arr.length - 1; i >= 0; --i) {
			System.out.println(arr[i] + " ");
		}

	}

	public static void ReverseArrayContent2(int n) {
		if (n < 1 || n >= 1000)
			return;
		Random r = new Random();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = r.nextInt(1000);
			// System.out.print(arr[i] + " ");
		}
		System.out.println();
		for (int i = arr.length - 1; i >= 0; --i) {
			System.out.println(arr[i] + " ");
		}

	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ReverseArrayContent(n);
	}

}

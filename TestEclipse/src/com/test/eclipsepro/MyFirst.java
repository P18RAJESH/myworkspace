package com.test.eclipsepro;

public class MyFirst {

	public static void main() {
		System.out.println("Hello Rajesh !!!");
		int sum = testsum();
		System.out.println(sum);
	}

	public static int testsum() {
		int sum = 0;
		for (int j = 1; j <= 100; j++) {
			sum += j;
		}
		// TODO check later

		if (sum >= 40)
			System.out.println("more");
		else
			System.out.println("less");
		return sum;
	}

}

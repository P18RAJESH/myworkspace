package com.p367;

public class PerfectSquare {
	public static boolean isPerfectSquare(int num) {
		if (num % 10 == 2 || num % 10 == 3 || num % 10 == 7 || num % 10 == 8)
			return false;

		int sum = 0, i = 1;
		while (sum < num) {
			sum += i;
			i += 2;
			if (sum == num)
				return true;
		}
		return false;
	}

	public static boolean isPerfectSquare2(int num) {
		if (num < 0) {
			return false;
		} else if (num < 2) {
			return true;
		}
		long start = 1;
		long end = num;
		while (start + 1 < end) {
			long mid = (end - start) / 2 + start;
			if (mid * mid == num) {
				return true;
			} else if (mid * mid < num) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (start * start == num || end * end == num) {
			return true;
		}
		return false;

	}

	public boolean isPerfectSquare3(int num) {
		int x = num;
		for (int i = 1; i <= x; i += 2) {
			num -= i;
			if (num == 0) {
				return true;
			}
			if (num < 0) {
				return false;
			}
		}
		return num == 0;
	}

	public static void main(String[] args) {
		System.out.println(isPerfectSquare2(0));
	}

}

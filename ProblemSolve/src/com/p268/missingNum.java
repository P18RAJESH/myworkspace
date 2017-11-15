package com.p268;

public class missingNum {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 3, 4, 5 };
		int num = missingNumber(arr);
		System.out.println("missing num :" + num);
	}

	public static int missingNumber1(int[] nums) {
		int missNum = 0;
		boolean flag = false;
		for (int i = 0; i < nums.length; i++) {
			if (i != nums[i]) {
				missNum = i;
				flag = true;
				break;
			}
		}
		if (flag == false) {
			missNum = nums.length;
		}
		return missNum;

	}

	public static int missingNumber2(int[] nums) {

		return 0;
	}

	public static int missingNumber(int[] nums) {
		int sum = 0, n = nums.length;
		int compare = ((1 + n) * n) / 2;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return compare - sum;
	}
}

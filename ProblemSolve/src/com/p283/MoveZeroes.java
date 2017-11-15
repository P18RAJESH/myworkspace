package com.p283;

import java.util.Arrays;

public class MoveZeroes {
	public static void moveZeroes(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length - count; i++) {
			if (nums[i] == 0) {
				for (int j = i; j < nums.length - count - 1; j++) {
					nums[j] = nums[j + 1];
				}
				nums[nums.length - i - 1] = 0;
				count++;
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	public static void main(String[] args) {
		int[] testcase = { 0, 0, 0, 1 };
		System.out.println(Arrays.toString(testcase));
		moveZeroes(testcase);

	}

}

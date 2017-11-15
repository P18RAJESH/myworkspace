package com.p27;

import java.util.Arrays;

public class RemoveElement {
	public static int removeElement(int[] nums, int val) {
		int count = 0;
		System.out.println(nums.length);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				nums[i] = Integer.MAX_VALUE;
				count++;
			}
		}
		Arrays.sort(nums);
		return nums.length - count;
	}

	public static int removeElement2(int[] nums, int val) {
		int count = 0;
		for (int i = 0; i < nums.length - count; i++) {
			if (nums[i] == val) {
				for (int j = i; j < nums.length - count - 1; j++) {
					nums[j] = nums[j + 1];
				}
				nums[nums.length - 1] = val;
				count++;
			}
		}
		// TODO FIX
		return nums.length - count;
	}

	public static void main(String[] args) {

		int[] testcase = { 3, 3 };
		System.out.println(removeElement2(testcase, 3));

	}

}

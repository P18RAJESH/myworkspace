package com.p26;

import java.util.Arrays;

public class RemoveDupFromArray {

	public static int removeDuplicates1(int[] nums) {
		if (nums.length == 0)
			return 0;
		int[] withoutdup = new int[nums.length];
		withoutdup[0] = nums[0];
		for (int i = 1, j = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				withoutdup[j++] = nums[i];
			}

		}
		int count = 0;
		for (int i = 0; i < withoutdup.length; i++) {
			if (withoutdup[i] == 0) {
				withoutdup[i] = Integer.MAX_VALUE;
				count++;
			}
		}
		Arrays.sort(withoutdup);
		int len = withoutdup.length - count;
		nums = withoutdup;
		return len;

	}

	public static int removeDuplicates2(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length && i + 1 < nums.length; i++) {
			if (nums[i] == nums[i + 1]) {
				nums[i] = Integer.MAX_VALUE;
				count++;
			}
		}
		Arrays.sort(nums);
		return nums.length - count;

	}

	public static int removeDuplicates4(int[] nums) {
		int count = 0;
		for (int i = 0; i + 2 < nums.length; i++) {
			if (nums[i] == nums[i + 1]) {
				nums[i] = nums[i + 1];
				count++;
			}
		} // TODO
			// Arrays.sort(nums);
		return nums.length - count;

	}

	public static int removeDuplicates3(int[] nums) {
		int newIdx = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1])
				nums[newIdx++] = nums[i];
		}
		return newIdx;

	}

	public static void main(String[] args) {
		int[] testcase = { 1, 1, 1, 2 };
		Arrays.sort(testcase);
		int len = removeDuplicates4(testcase);
		System.out.println("lenght " + len);
		System.out.println(Arrays.toString(testcase));
		/*
		 * for (int i = 0; i < len; i++) { System.out.print(testcase[i] + " ");
		 * }
		 */
	}

}

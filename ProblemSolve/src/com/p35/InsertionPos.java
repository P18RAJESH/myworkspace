package com.p35;

public class InsertionPos {
	public static int searchInsert(int[] nums, int target) {
		int m = nums.length;
		if (m < 1 || nums.length == 0)
			return 0;
		int l = 0, r = m - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			int e = nums[mid];
			if (target == e)
				return mid;
			if (target < e)
				r = mid - 1;
			else
				l = mid + 1;
		}
		return l;

	}

	public static int searchInsert2(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= target) {
				return i;
			}
		}
		return nums.length;
	}

	public static int searchInsert3(int[] nums, int target) {
		int e = nums.length / 2;
		if (nums[e] > target) {
			for (int i = e - 1; i >= 0; --i) {
				if (nums[i] >= target) {
					return i;
				}
			}
		} else if (nums[e] < target) {
			for (int i = e; i < nums.length; i++) {
				if (nums[i] >= target) {
					return i;
				}
			}
		} else
			return e;
		return nums.length;

	}

	public static void main(String[] args) {
		int[] testcase = { 1, 2, 3, 4, 5 };
		System.out.println(searchInsert3(testcase, 2));

	}

}

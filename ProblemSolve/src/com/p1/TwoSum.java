package com.p1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static int[] twoSum1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == Math.abs(nums[i] - target)) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No Such Element found in array");
	}

	public static int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		int compliment;
		for (int i = 0; i < nums.length; i++) {
			compliment = Math.abs(nums[i] - target);
			if (map.containsKey(compliment) && map.get(compliment) != i) {
				return new int[] { i, map.get(compliment) };
			}
		}
		throw new IllegalArgumentException("No Such Element found");
	}

	public static int[] twoSum3(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int compliment;
		for (int i = 0; i < nums.length; i++) {
			compliment = Math.abs(nums[i] - target);
			if (map.containsKey(compliment)) {
				return new int[] { i, map.get(compliment) };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No Such Element found");
	}

	public static int[] twoSum4(int[] nums, int target) {
		int[] nums1;
		int ipos, jpos;
		nums1 = Arrays.copyOf(nums, nums.length);
		Arrays.sort(nums);
		for (int i = 0, j = nums.length - 1; i < j;) {
			if ((nums[i] + nums[j]) == target) {
				if (nums[i] == nums[j]) {
					ipos = Arrays.binarySearch(nums1, nums[i]);
					jpos = Arrays.binarySearch(nums1, ipos + 1, nums1.length - 1, nums[j]);
					return new int[] { ipos, jpos };
				} else {
					return new int[] { Arrays.binarySearch(nums1, nums[i]), Arrays.binarySearch(nums1, nums[j]) };
				}
			} else if ((nums[i] + nums[j]) > target) {
				--j;
			} else {
				++i;
			}
		} // TODO
		throw new IllegalArgumentException("No Such pair found");
	}

	public static void main(String[] args) {
		int[] testcase = { -1, -2, -3, -4, -5 };
		/*
		 * int ipos,jpos; System.out.println(Arrays.toString(testcase));
		 * ipos=Arrays.binarySearch(testcase, 5);
		 * jpos=Arrays.binarySearch(testcase, 2, testcase.length-1,6);
		 * System.out.println("ipos "+ipos); System.out.println("jpos "+jpos);
		 */
		System.out.println(Arrays.toString(twoSum2(testcase, -8)));
	}

}

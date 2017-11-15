package com.p13;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

	public static int romanToInt(String s) {
		Map<String, Integer> tab = new HashMap<>();
		char[] as = s.toCharArray();
		int sum = 0;
		tab.put("I", 1);
		tab.put("V", 5);
		tab.put("X", 10);
		tab.put("L", 100);
		tab.put("D", 500);
		tab.put("M", 1000);
		for (int i = 0; i < as.length - 1; i++) {
			if (tab.get(as[i]) < tab.get(as[i + 1])) {
				sum -= as[i];
			} else {
				sum += as[i];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		String roman="VI";
		System.out.println("Integer Equivalent is"+romanToInt(roman));
	}

}

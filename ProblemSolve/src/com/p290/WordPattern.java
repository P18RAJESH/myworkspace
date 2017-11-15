package com.p290;

import java.util.HashMap;

public class WordPattern {

	public static boolean wordPattern(String pattern, String str) {
		HashMap<Character, String> map = new HashMap<Character, String>();
		String[] wstr = str.split(" ");
		char[] cpat = pattern.toCharArray();
		if (wstr.length != cpat.length)
			return false;

		for (int i = 0; i < cpat.length; i++) {
			if (map.containsKey(cpat[i])) {
				if (!map.get(cpat[i]).equals(wstr[i]))
					return false;
			} else {
				if (map.containsValue(wstr[i])) {
					return false;
				}
				map.put(cpat[i], wstr[i]);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String pattern = "", str = "";
		System.out.println(wordPattern(pattern, str));
	}

}

package com.p9;

public class ChkPalindrom {

	public static boolean isPalindrome1(int x) {
		int  rem, num = 0, org = x;
		if (x < 0) {
		return false;
		}
		while (x > 0) {
			rem = x % 10;
			x = x / 10;
			try {
				num = Math.addExact(Math.multiplyExact(num, 10), rem);
			} catch (ArithmeticException e) {
				return false;
			}
		}
		return (num == org);
	}

	public static boolean isPalindrome2(int x) {
		int rnum = 0;
		if (x < 0 || (x % 10 == 0 && x != 0))
			return false;

		while (x > rnum) {
			rnum = rnum * 10 + x % 10;
			x /= 10;
		}
		return (x == rnum || x == rnum / 10);
	}
	public static boolean isPalindrome3(int x) {
		if (x < 0)
			return false;
		String snum = String.valueOf(Math.abs(x));
		char fchar, lchar;
		while (snum.length()>2) {
			fchar = snum.charAt(0);
			lchar = snum.charAt(snum.length() - 1);
			if (fchar != lchar)
				return false;
			snum = snum.substring(1,snum.length()-2);
		}
		return true;
	}
		
	public static void main(String[] args) {
		int num = 10;
		System.out.println("Given no is :" + num);
		System.out.println(" Is No Palindrome:" + isPalindrome3(num));

	}

}

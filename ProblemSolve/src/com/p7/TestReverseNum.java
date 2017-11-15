package com.p7;

public class TestReverseNum {
	public static int reverse1(int x) {
		int rem, num = 0, sign = 1;
		if (x < 0) {
			sign *= -1;
			x = x * sign;
		}
		String rnum = "";
		try {
			while (x > 0) {
				rem = x % 10;
				x = x / 10;
				rnum = rnum + rem;
			}
		} catch (Exception e) {
			return 0;
		}
		num = Integer.parseInt(rnum)*sign;
		if(sign==-1)
		rnum="-"+rnum;
		System.out.println(num);
		System.out.println(rnum);
		return num;
	}

	public static int reverse2(int x) {
		int rem, num = 0, sign = 1;
		if (x < 0) {
			sign = -1;
			x = x * sign;
		}
		while (x > 0) {
			rem = x % 10;
			x = x / 10;
			try {
				num = Math.addExact(Math.multiplyExact(num, 10), rem);
			} catch (ArithmeticException ae) {
				return 0;
			}
		}
		return num * sign;
	}

	public static void main(String args[]) {
		int num =1002;
		// num=Integer.parseInt(args[0]);
		System.out.println("Given no is :" + num);
		System.out.println("Reversed no is :" + reverse1(num));
	}
}

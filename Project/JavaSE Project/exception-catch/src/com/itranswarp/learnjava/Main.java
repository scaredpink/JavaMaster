package com.itranswarp.learnjava;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) {
		String a = "12";
		String b = "x9";
		// TODO: 捕获异常并处理
		try {
			int c = stringToInt(a);
			int d = stringToInt(b);
			System.out.println(c * d);
		} catch (NumberFormatException e) {
			System.out.println("数字类型不匹配");
		}
	}

	static int stringToInt(String s) {
		return Integer.parseInt(s);
	}
}

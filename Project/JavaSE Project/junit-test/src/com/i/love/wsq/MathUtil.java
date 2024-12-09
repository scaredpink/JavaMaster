package com.i.love.wsq;

/**
 * @author baitao
 */

public class MathUtil {
	public static int add(int ... a) {
		int sum = 0;
		for (int b : a) {
			sum += b;
		}
		return sum;
	}
}

package com.i.love.wsq;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public class FactorialTest {

	@Test
	public void testFact() {
		assertEquals(1, Factorial.fact(0));
		assertEquals(1, Factorial.fact(1));
		assertEquals(2, Factorial.fact(2));
		assertEquals(6, Factorial.fact(3));
		assertEquals(3628800, Factorial.fact(10));
		assertEquals(2432902008176640000L, Factorial.fact(20)); 
	}

	@Test
	public void testNegative() {
		assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				Factorial.fact(-1);
			}
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Factorial.fact(-1);
		});
	}

	@Test
	public void testLargeInput() {
		assertThrows(ArithmeticException.class, () -> {
			Factorial.fact(21);
		});
	}
}

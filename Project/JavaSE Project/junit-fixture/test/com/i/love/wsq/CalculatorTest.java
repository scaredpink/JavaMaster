package com.i.love.wsq;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	Calculator calculator;

	@Before
	public void setUp() {
		this.calculator = new Calculator();
	}

	@After
	public void tearDown() {
		this.calculator = null;
	}

	@Test
	public void addTest() {
		Assert.assertEquals(5, calculator.add(5));
	}

	@Test
	public void subTest() {
		Assert.assertEquals(5, calculator.sub(-5));
	}

}

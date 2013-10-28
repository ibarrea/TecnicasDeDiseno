package com.grupo13.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCaseTest {

	private TestCase test;

	@Before
	public void setup() {
		// creo una clase anonima para testear TestCase que es abstracta
		test = new TestCase() {
			public void run() {
			};
		};
	}

	@Test
	public void methodNameIsThisTest() {

		Assert.assertEquals("methodNameIsThisTest", test.getMethodName(2));
	}

	@Test
	public void callerMethodNameIsThisTest() {

		Assert.assertEquals("callerMethodNameIsThisTest", test.getCallerName());
	}

}

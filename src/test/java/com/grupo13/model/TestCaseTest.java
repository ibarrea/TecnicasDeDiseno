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
			public void exampleAssertTrueTest() {
				assertTrue(true);
			}
			
			public void exampleAssertFalseTest() {
				assertFalse(false);
			}
			
			public void exampleAssertEqualsObjectsTestThatShouldPass() {
				assertEquals("Hola","Hola");
			}
			
			
			public void exampleAssertEqualsIntTestThatShouldPass() {
				assertEquals(23,23);
			}
			
			public void exampleAssertEqualsFloatTestThatShouldPass() {
				assertEquals(23.7,23.7);
			}

			public void run() {
				exampleAssertTrueTest();
				exampleAssertFalseTest();
				exampleAssertEqualsObjectsTestThatShouldPass();
				exampleAssertEqualsIntTestThatShouldPass();
				exampleAssertEqualsFloatTestThatShouldPass();
			};
		};
		test.run();
	}

	@Test
	public void callerMethodNameIsThisTest() {

		Assert.assertEquals("callerMethodNameIsThisTest", test.getCallerName());
	}

	@Test
	public void existingTestIsPassingIfItsAssertTrueDontFail() {
		
		Assert.assertTrue(test.verifyTest("exampleAssertTrueTest"));
	}

	@Test
	public void existingTestIsPassingIfItsAssertFalseDontFail() {
		
		Assert.assertTrue(test.verifyTest("exampleAssertFalseTest"));
	}

	@Test
	public void existingTestIsPassingIfItsAssertEqualObjectDontFail() {
		
		Assert.assertTrue(test.verifyTest("exampleAssertEqualsObjectsTestThatShouldPass"));
	}

	@Test
	public void existingTestIsPassingIfItsAssertEqualIntDontFail() {
		
		Assert.assertTrue(test.verifyTest("exampleAssertEqualsIntTestThatShouldPass"));
	}
	
	@Test
	public void existingTestIsPassingIfItsAssertEqualFloatDontFail() {
		
		Assert.assertTrue(test.verifyTest("exampleAssertEqualsFloatTestThatShouldPass"));
	}
}

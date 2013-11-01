package com.grupo13.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCaseTest {

	private TestSuite test;

	@Before
	public void setup() {
		// creo una clase anonima para testear TestCase que es abstracta
		test = new TestSuite() {
			
			public void exampleFailTest() {
				fail();
			}
			
			public void exampleAssertTrueTest() {
				assertTrue(true);
			}
			
			public void exampleAssertTrueTestFail() {
				assertTrue(false);
			}
			
			public void exampleAssertFalseTest() {
				assertFalse(false);
			}
			
			public void exampleAssertFalseTestFail() {
				assertFalse(true);
			}
			
			public void exampleAssertEqualsObjectsTestThatShouldPass() {
				assertEquals("Hola","Hola");
			}
			
			public void exampleAssertEqualsObjectsTestThatShouldntPass() {
				assertEquals("Hola","Chau");
			}
			
			
			public void exampleAssertEqualsIntTestThatShouldPass() {
				int a = 45;
				assertEquals(a, a);
			}
			
			public void exampleAssertEqualsIntTestThatShouldntPass() {
				int a = 23;
				int b = 1988;
				assertEquals(a, b);
			}
			
			public void exampleAssertEqualsFloatTestThatShouldPass() {
				float a = (float) 23.7;
				assertEquals(a, a);
			}
			
			public void exampleAssertEqualsFloatTestThatShouldntPass() {
				float a = (float) 23.7;
				float b = (float) 23.6;
				assertEquals(a, b);
			}

			public void run() {
				//booleans
				exampleAssertTrueTest();
				exampleAssertTrueTestFail();
				exampleAssertFalseTest();
				exampleAssertFalseTestFail();
				
				//objects
				exampleAssertEqualsObjectsTestThatShouldPass();
				exampleAssertEqualsObjectsTestThatShouldntPass();
				
				
				//floats
				exampleAssertEqualsFloatTestThatShouldPass();
				exampleAssertEqualsFloatTestThatShouldntPass();
				//integers
				exampleAssertEqualsIntTestThatShouldntPass();
				exampleAssertEqualsIntTestThatShouldPass();
				
				//fail
				exampleFailTest();
				
			}

		};
		test.start();
	}

	@Test
	public void existingTestIsPassingIfItsAssertTrueDontFail() {
		
		Assert.assertTrue(test.verifyTest("exampleAssertTrueTest"));
	}
	
	@Test
	public void existingTestIsntPassingIfItsAssertTrueFail() {
		
		Assert.assertFalse(test.verifyTest("exampleAssertTrueTestFail"));
	}

	@Test
	public void existingTestIsPassingIfItsAssertFalseDontFail() {
		
		Assert.assertTrue(test.verifyTest("exampleAssertFalseTest"));
	}
	

	@Test
	public void existingTestIsntPassingIfItsAssertFalseFail() {
		
		Assert.assertFalse(test.verifyTest("exampleAssertFalseTestFail"));
	}

	@Test
	public void existingTestIsPassingIfItsAssertEqualObjectDontFail() {
		
		Assert.assertTrue(test.verifyTest("exampleAssertEqualsObjectsTestThatShouldPass"));
	}
	
	@Test
	public void existingTestIsntPassingIfItsAssertEqualObjectFail() {
		
		Assert.assertFalse(test.verifyTest("exampleAssertEqualsObjectsTestThatShouldntPass"));
	}

	@Test
	public void existingTestIsPassingIfItsAssertEqualIntDontFail() {
		
		Assert.assertTrue(test.verifyTest("exampleAssertEqualsIntTestThatShouldPass"));
	}

	@Test
	public void existingTestIsntPassingIfItsAssertEqualIntFail() {
		
		Assert.assertFalse(test.verifyTest("exampleAssertEqualsIntTestThatShouldntPass"));
	}
	
	@Test
	public void existingTestIsPassingIfItsAssertEqualFloatDontFail() {
		
		Assert.assertTrue(test.verifyTest("exampleAssertEqualsFloatTestThatShouldPass"));
	}
	
	@Test
	public void existingTestIsntPassingIfItsAssertEqualFloatFail() {
		
		Assert.assertFalse(test.verifyTest("exampleAssertEqualsFloatTestThatShouldntPass"));
	}
	
	@Test
	public void verifyTestThatExecuteFailReturnsFalse() {
		
		Assert.assertFalse(test.verifyTest("exampleFailTest"));
	}
}

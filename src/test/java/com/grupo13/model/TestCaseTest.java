package com.grupo13.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCaseTest {

	private BaseTestCase test;

	@Before
	public void setup() {
		// creo una clase anonima para testear TestCase que es abstracta
		test = new BaseTestCase() {
			
			public void exampleFailTest() {
				fail();
			}
			
			public void exampleAssertTrueTest() {
				assertTrue(true);
			}
			
			public void exampleAssertFalseTest() {
				assertFalse(false);
			}
			
			public void exampleAssertEqualsObjectsTestThatShouldPass() {
				assertEquals("Hola","Hola");
			}
			
			public void exampleAssertEqualsObjectsTestThatShouldntPass() {
				assertEquals("Hola","Chau");
			}
			
			
			public void exampleAssertEqualsIntTestThatShouldPass() {
				assertEquals(45, 45);
			}
			
			public void exampleAssertEqualsIntTestThatShouldntPass() {
				assertEquals(23,1988);
			}
			
			public void exampleAssertEqualsFloatTestThatShouldPass() {
				assertEquals(23.7,23.7);
			}
			
			public void exampleAssertEqualsFloatTestThatShouldntPass() {
				assertEquals(23.7,23.6);
			}

			public void run() {
				//booleans
				exampleAssertTrueTest();
				exampleAssertFalseTest();
				
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

			@Override
			public void setup() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void tearDown() {
				// TODO Auto-generated method stub
				
			};
		};
		test.start();
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
